class Solution {
    public int searchInsert(int[] nums, int target) {
        return bs(0,nums.length-1,nums,target);
    }

    private int bs(int s,int e,int[] nums, int target){
      if(s>=e){
        if(nums[s]>=target) return s;
        else return s+1;
      }
      int mid=s+(e-s)/2;
      if(nums[mid]==target) return mid;
      if(nums[mid]>target) return bs(s,mid-1,nums,target);
      else{
        return bs(mid+1,e,nums,target);
      }
    }
}