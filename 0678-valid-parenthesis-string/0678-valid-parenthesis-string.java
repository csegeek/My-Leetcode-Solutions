class Solution {
    public boolean checkValidString(String s) {
        Boolean[][] dp=new Boolean[s.length()][s.length()];
        return recursive(s,0,0,dp);
    }

    private boolean recursive(String s,int i,int count,Boolean[][] dp){
        
        
        if(count<0) return false;
        if(i>=s.length()){
            if(count==0)return true;
            else return false;
        }
        if(dp[i][count]!=null) return dp[i][count];
        if(s.charAt(i)=='('){
            return dp[i][count]=recursive(s,i+1,count+1,dp);
        }
        if(s.charAt(i)==')'){
            return dp[i][count]=recursive(s,i+1,count-1,dp);
        }
        return dp[i][count]=recursive(s,i+1,count+1,dp)|| recursive(s,i+1,count-1,dp) || recursive(s,i+1,count,dp);
    }
}
