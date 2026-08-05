class Solution {
    public int mySqrt(int x) {
       if(x==0 || x==1) return x;
       int low=2;
       int high=x;
       int mid=-1;
       while(low<=high){
        mid=low+(high-low)/2;
        if((long)mid*mid==x) return mid;
        if((long)mid*mid>x) high=mid-1;
        else{
            low=mid+1;
        }
       } 
       return Math.round(high);
    }
}