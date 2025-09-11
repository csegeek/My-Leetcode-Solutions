class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        return tabulation(nums);
    }



     ArrayList<Integer> tabulation(int [] nums){
         ArrayList<Integer> response=new ArrayList<>();
         int[] hash=new int[nums.length];
         for(int i=0;i<nums.length;i++){
             hash[i]=i;
         }
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        int max=1;
        int lastIndex=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<=i-1;j++){
                if(nums[i]%nums[j]==0 && 1+dp[j]>dp[i]){
                dp[i]=1+dp[j];
                hash[i]=j;
                } 
            }
            if(dp[i]>max){
             max=dp[i];
             lastIndex=i;
            }
        }
         response.add(nums[lastIndex]);
        while(lastIndex !=hash[lastIndex]){
            lastIndex=hash[lastIndex];
            response.add(nums[lastIndex]);
        }
        Collections.reverse(response);
        return response;
     }

}