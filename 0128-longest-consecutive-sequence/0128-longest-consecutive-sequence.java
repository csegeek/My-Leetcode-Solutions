class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        HashSet<Integer> set=new HashSet<>();
        int maxCount=1;
        for(int a:nums){
            set.add(a);
        }

        for(int a:set){
            if(!set.contains(a-1)){
                int temp=a;
                int count=1;
                while(set.contains(temp+1)){
                    count++;
                    maxCount=Math.max(count,maxCount);
                    temp=temp+1;
                }
            }
        }
        return maxCount;
        
    }
}