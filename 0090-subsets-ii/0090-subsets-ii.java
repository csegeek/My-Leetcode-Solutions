class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> response=new ArrayList<>();
        Arrays.sort(nums);
        recursiveSol(nums,0,response,new ArrayList<>());
    return response;
    }
private void recursiveSol(int[] nums,int ind,List<List<Integer>> response,List<Integer> subset){

         response.add(new ArrayList<>(subset));
        
        
       for(int i=ind;i<nums.length;i++){
            if(i>ind && nums[i]==nums[i-1]) continue;
             subset.add(nums[i]);
             recursiveSol(nums,i+1,response,subset);
             subset.remove(subset.size()-1);
            
        }   
    }
}