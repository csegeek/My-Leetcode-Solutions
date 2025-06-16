class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
       int [][] dp=new int[s.length()+1][s.length()+1];
       for(int[] arr:dp){
        Arrays.fill(arr,-1);
       }
        Set<String> dictSet=wordDict.stream().collect(Collectors.toSet());
        return recursion(0,0,s,dictSet,dp);
    }
    private boolean recursion(int str,int end,String s,Set<String> wordDict,int[][] dp){
        if(dp[str][end]!=-1) return dp[str][end]==1? true:false;
        if(end>=s.length()){
            if(wordDict.contains(s.substring(str,end))) {
                dp[str][end]=1;
                return true;
            }
            dp[str][end]=0;
            return false;
        }
        if(wordDict.contains(s.substring(str,end))){
            if(recursion(end,end+1,s,wordDict,dp)) {
                dp[str][end]=1;
                return true;  
            }
        }
        boolean response=recursion(str,end+1,s,wordDict,dp);
        dp[str][end]=response?1:0;
        return response;
    }
}