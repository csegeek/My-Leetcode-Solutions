class Solution {
    public char kthCharacter(int k) {
       String finalString="a";
       String temp="";
       while(finalString.length()<=k){
         int i=0;
         temp="";
         while(i<finalString.length()){
            temp+=generateNext(finalString.charAt(i));
            i++;
         }
         System.out.println(temp);
        finalString+=temp;
       }
       
       return finalString.charAt(k-1);
    }

    private char generateNext(char c){
        int temp=(int) c;
        if(temp>=92 && temp <=122){
        temp=temp+1;
        }
        return (char) temp;
    }
}