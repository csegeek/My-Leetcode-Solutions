class Solution {
    public int maxCoins(int[] nums) {
    //     int[] numsTemp=new int[nums.length+2];
    //     int[][] dp=new int [nums.length+1][nums.length+1];
    //     for(int[] dpi:dp){
    //         Arrays.fill(dpi,-1);
    //     }
    //     numsTemp[0]=1;
    //     for(int i=1;i<=nums.length;i++){
    //         numsTemp[i]=nums[i-1];
    //     }
    //     numsTemp[nums.length+1]=1;
    //  return recursion(1,nums.length,numsTemp,dp);  
    return tabulation(nums);
    }


    int recursion(int i,int j,int[] nums,int[][] dp){
        if(i>j) return 0;
        if(dp[i][j] !=-1) return dp[i][j];
        int max=(int)-1e9;
        for(int k=i;k<=j;k++){
            int coins=nums[i-1]*nums[k]*nums[j+1]+recursion(i,k-1,nums,dp)+recursion(k+1,j,nums,dp);
            max=Math.max(max,coins);
        }
        return  dp[i][j]=max;
    }

int tabulation(int [] nums){
     int[] numsTemp=new int[nums.length+2];
     int[][] dp=new int [nums.length+2][nums.length+2];
        numsTemp[0]=1;
        for(int i=1;i<=nums.length;i++){
            numsTemp[i]=nums[i-1];
        }
        numsTemp[nums.length+1]=1;
    for(int i=nums.length;i>0;i--){
        for(int j=0;j<=nums.length;j++){
         if(i>j) continue;
        int max=(int)-1e9;
        for(int k=i;k<=j;k++){
            int coins=numsTemp[i-1]*numsTemp[k]*numsTemp[j+1]+dp[i][k-1]+dp[k+1][j];
            max=Math.max(max,coins);
        }
        dp[i][j]=max;
        }
    }
    for(int [] dpi:dp){
        System.out.println(Arrays.toString(dpi));
    }
 return dp[1][nums.length];
}
    


    
}