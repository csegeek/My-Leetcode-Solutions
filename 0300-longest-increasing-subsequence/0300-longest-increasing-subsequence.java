class Solution {
    public int lengthOfLIS(int[] nums) {
    //     int [][] dp=new int [nums.length][nums.length+1];
    //     for(int[] dpi:dp){
    //         Arrays.fill(dpi,-1);
    //     }
    //   return recursion(0,-1,nums,dp);  
   // return tabulation(nums);
   return binarySearch(nums);
    }

    int recursion(int i,int prev,int[] nums,int[][] dp){
    if(i>=nums.length) return 0;
    if(dp[i][prev+1]!=-1) return dp[i][prev+1];
      int pick=Integer.MIN_VALUE;
     if(prev==-1 || nums[i]>nums[prev]){
         pick=1+recursion(i+1,i,nums,dp);
     }
        int notPick=recursion(i+1,prev,nums,dp);
        return dp[i][prev+1]=Math.max(pick,notPick);
     }

     int tabulation(int [] nums){
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        int max=1;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<=i-1;j++){
                if(nums[i]>nums[j]){
                dp[i]=Math.max(dp[i],1+dp[j]);
                } 
            }
            max=Math.max(dp[i],max);
        }
        return max;
     }


int binarySearch(int[] nums){
 ArrayList<Integer> temp=new ArrayList<>();
 temp.add(nums[0]);
 for(int i=1;i<nums.length;i++){
    if(nums[i]>temp.get(temp.size()-1)){
        temp.add(nums[i]);
    }
    else{
        int ind=lowerBound(temp,nums[i]);
        temp.set(ind,nums[i]);
    }
 }
 return temp.size();
}

        public static int lowerBound(ArrayList<Integer> arr, int x) {
            int low = 0;
            int high = arr.size() - 1;
            int ans = arr.size(); // Default if all elements are smaller than x

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arr.get(mid) >= x) {
                    ans = mid;
                    high = mid - 1; // Try to find an even smaller index
                } else {
                    low = mid + 1; // Search in the right half
                }
            }
            return ans;
        }


}