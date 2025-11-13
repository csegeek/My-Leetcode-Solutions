class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        int[] result=new int [nums.length];
        for (int i=0;i<nums.length;i++){
            result[(i+k)%n]=nums[i];
        }
    for(int i=0;i<result.length;i++){
       nums[i]=result[i];
    }
        
    }
}