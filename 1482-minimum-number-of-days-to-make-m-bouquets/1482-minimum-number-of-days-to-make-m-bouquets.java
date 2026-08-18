class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if(n<((long)m*k)) return -1;
        int low=min(bloomDay,n);
        int high=max(bloomDay,n);
        while(low<=high){
            int mid=low+(high-low)/2;
            if(noOfBou(bloomDay,k,mid)<m){
              low=mid+1;
            }
            else{
            high=mid-1;
            }
        }
        return low;
    }

    private int min(int[] bloomDay,int n){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
          min=Math.min(min,bloomDay[i]);
        }
        return min;
    }

    private int  max(int [] bloomDay,int n){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,bloomDay[i]);
        }
        return max;
    }

    private int noOfBou(int [] bloomDay,int k,int d){
        int nB=0;
        int tk=k;
        for(int i=0;i<bloomDay.length;i++){
         
          if(bloomDay[i]<= d) {
             tk--;
             if(tk==0) { 
                nB++;
                tk=k;
                }
            }
          else {
            tk=k;
          }
        }
        return nB;
    }
}