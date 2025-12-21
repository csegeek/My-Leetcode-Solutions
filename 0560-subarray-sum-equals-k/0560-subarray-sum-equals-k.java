class Solution {
    public int subarraySum(int[] nums, int k) {
        //<Sum,Freq>
        Map <Integer,Integer> psMap=new HashMap<>();
        int count=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum==k) count++;
            if(psMap.containsKey(sum-k)){
                count=count+psMap.get(sum-k);
            }
            if(psMap.containsKey(sum)){
                psMap.put(sum,psMap.get(sum)+1);
            }
            else{
                psMap.put(sum,1);
            }
        }
     return count;
        
    }
}