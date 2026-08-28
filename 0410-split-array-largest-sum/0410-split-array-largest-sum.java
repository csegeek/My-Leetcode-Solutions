class Solution {
    public int splitArray(int[] nums, int k) {
        int low=Arrays.stream(nums).max().getAsInt();
        int  high=Arrays.stream(nums).sum();
        while(low<=high){
          int mid=low+(high-low)/2;
          if(noOfArrays(nums,mid)>k){
            low=mid+1;
          }
          else{
            high=mid-1;
          }
        }
        return low;

    }

    int noOfArrays(int [] nums,int max){
        int noArr=1;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(sum+nums[i]<=max){
                sum=sum+nums[i];
            }
            else{
                sum=nums[i];
                noArr++;
            }
        }
        return noArr;
    }
    
}