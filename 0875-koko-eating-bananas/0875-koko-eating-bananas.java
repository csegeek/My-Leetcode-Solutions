class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=max(piles);
        while(low<=high){
            int mid=low+(high-low)/2;
            int reqhrs=eatingHours(piles,mid);
            if(reqhrs<=h){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }

    private int eatingHours(int[] piles,int e){
        int ans=0;
        for(int i=0;i<piles.length;i++){
            ans+=Math.ceil((double)piles[i]/e);
        }
        return ans;
    }

    private int max(int [] piles){
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
           ans=Math.max(ans,piles[i]);
        }
        return ans;
    }
}