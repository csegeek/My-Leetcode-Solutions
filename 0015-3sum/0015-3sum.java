class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i!= 0 && nums[i-1]==nums[i]) continue;
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum<0){
                   j++;
                }
                else if (sum>0){
                    k--;
                }
                else{
                  ans.add(List.of(nums[i],nums[j],nums[k]));
                  j++;
                  k--;
                  while(j<k && nums[j-1]==nums[j]) j++;
                  while(j<k && nums[k]==nums[k+1]) k--;
                }
            }
        }

        return ans;
    }
}