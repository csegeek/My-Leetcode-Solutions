class Solution {
    public boolean canJump(int[] nums) {
        // Boolean[] dp=new Boolean [nums.length];
        // return recursive(nums,0,dp);
        int maxInd=0;
        for(int i=0;i<nums.length;i++){
            if(i>maxInd) return false;
            maxInd=Math.max(maxInd,i+nums[i]);
        }
        return true;

    }
    private boolean recursive(int[] nums,int ind,Boolean[] dp){
        if(ind>=nums.length-1) return true;
        if(dp[ind]!=null) return dp[ind];
        for(int stp=1;stp<=nums[ind];stp++){
            if(recursive(nums,ind+stp,dp)) return dp[ind]=true;
        }
        return dp[ind]=false;
    }
}