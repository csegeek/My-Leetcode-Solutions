class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] res=new int[nums.length];
        int pindex=0;
        int nindex=1;
        int i=0;
        while(i<nums.length){
            if(nums[i]>0){
               res[pindex]=nums[i];
               pindex=pindex+2;
            }
            else{
                res[nindex]=nums[i];
                nindex=nindex+2;
            }
            i++;
        }
        return res;
    }
}