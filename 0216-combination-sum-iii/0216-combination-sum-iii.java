class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> response =new ArrayList<>();
        backtrack(k,n,0,0,new ArrayList<>(),response);
        return response;
    }

    private void backtrack(int k,int n,int index,int sum,List<Integer> subset,List<List<Integer>> response){

    if(subset.size()==k){
        if(sum==n){
            response.add(new ArrayList<>(subset));
        }
        return;
    }
    for(int i=index;i<=9;i++){
        if(i==0) continue;
        subset.add(i);
        sum+=i;
        backtrack(k,n,i+1,sum,subset,response);
        subset.remove(subset.size()-1);
        sum-=i;
    }
    }
}