class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int [] temp1=new int[nums.length-1];
        int [] temp2=new int [nums.length-1];
        for(int i=0;i<nums.length;i++){
            if(i!=0) temp1[i-1]=nums[i];
            if(i!=nums.length-1) temp2[i]=nums[i];
        }
        return Math.max(tabulation(temp1),tabulation(temp2));
    }

     private int tabulation(int [] nums){
        int[] dp=new int [nums.length];
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[nums.length-1];
    }
}