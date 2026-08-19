class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=max(nums);
        while(low<=high){
            int mid=low+(high-low)/2;
            if(divSum(nums,mid)>threshold){
                low=mid+1;
            }
            else {
                high=mid-1;
            }
        }
        return low;
    }

private int max(int[] nums){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        return max;
}

private int divSum(int[] nums,int div){
        int res=0;
        for(int i=0;i<nums.length;i++){
           res+=Math.ceil((double) nums[i]/div);
        }
        return res;
}



}