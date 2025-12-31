class Solution {
    public String longestCommonPrefix(String[] strs) {
     StringBuilder res=new StringBuilder("");
     Arrays.sort(strs);
     String first=strs[0];
     String last=strs[strs.length-1];  
     int fp=0;
     int lp=0;
     while(fp<first.length() && lp<last.length()){
       if(first.charAt(fp)==last.charAt(lp)) res.append(first.charAt(fp));
       else break;
       fp++;
       lp++;
     }
   return res.toString();
    }
}