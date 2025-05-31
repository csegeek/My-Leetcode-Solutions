class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> response = new ArrayList();
         recursiveSol(candidates,target,0,new ArrayList<>(),0,response);
         return response;
    }

    private void recursiveSol(int[] candidates, int tagret, int index, List<Integer> subset, int sum,
            List<List<Integer>> response) {
        if (index >= candidates.length) {
            if (tagret == sum) {
             response.add(new ArrayList<>(subset));
             return;
            }
            return;
        }
        if(tagret-sum>=candidates[index]){
        sum+=candidates[index];
        subset.add(candidates[index]);
        recursiveSol(candidates,tagret,index,subset,sum,response);
          sum-=candidates[index];
        subset.remove(subset.size()-1);
        }
        // if(sum>0 && subset.size()>0){
      
        // }
        recursiveSol(candidates,tagret,index+1,subset,sum,response);
    }
}