class Solution {
    public int maxDepth(String s) {
        int depth=0;
        int maxdepth=Integer.MIN_VALUE;
        for(char c:s.toCharArray()){
         if(c=='('){
            depth++;
         }
         if(c==')'){
            depth--;
         }
         maxdepth=Math.max(depth,maxdepth);
        }
        return maxdepth;
    }
}