class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(0,nums.length-1,target,nums);
    }

    int binarySearch(int start,int end,int target,int [] nums){
        if(start>end) return -1;
        int mid=start+(end-start)/2;
        if(nums[mid]==target) return mid;
        if(nums[mid]<target) {
            return binarySearch(mid+1,end,target,nums);
        }
        else{
            return binarySearch(start,mid-1,target,nums);
        }
    }
}