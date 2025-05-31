class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> response = new ArrayList();
         recursiveSol(candidates,target,0,new ArrayList<>(),response);
         return response;
    }

    private void recursiveSol(int[] candidates, int target, int index, List<Integer> subset,List<List<Integer>> response) {
     if(target==0){
     response.add(new ArrayList<>(subset));
     return;
    }
    for(int i=index;i<candidates.length;i++){
      if(candidates[i]>target){
        break;
      }
      if(i>index && candidates[i]==candidates[i-1]) continue;
      target-=candidates[i];
      subset.add(candidates[i]);
      recursiveSol(candidates,target,i+1,subset,response);
      target+=candidates[i];
      subset.remove(subset.size()-1);
    }
}
}