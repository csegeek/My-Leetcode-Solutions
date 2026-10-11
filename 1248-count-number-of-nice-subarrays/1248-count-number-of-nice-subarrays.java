class Solution {

    public int numberOfSubarrays(int[] nums, int goal) {
    return  numSubarraysWithLessorEqualtoGoal( nums, goal)- numSubarraysWithLessorEqualtoGoal( nums, goal-1);
    }


   private int numSubarraysWithLessorEqualtoGoal(int [] nums,int goal){
        int left=0;
        int right=0;
        int sum=0;
        int count=0;
        if(goal<0) return 0;
        while(right<nums.length){
            sum+=nums[right]%2;
            while(sum>goal){
                sum=sum-nums[left]%2;
                left++;
            }
            count+=right-left+1;
            right++;
        }
        return count;
    }





}

