class Solution {
    public List<String> validStrings(int n) {
        List<String> response=new ArrayList<>();
          StringBuilder s = new StringBuilder();
        for (int j = 0; j < n; j++) {
            s.append('1');
        }
    
        
        generateBinaryString(n,0, response,s);
        return response;
    }


    private void generateBinaryString(int n,int index,List<String> output,StringBuilder s){

    if(index>=n){
       output.add(s.toString());
       System.out.println(s.toString());
       return;
    }
    generateBinaryString(n,index+1,output,s);
    s.setCharAt(index,'0');
    generateBinaryString(n,index+2,output,s);
    s.setCharAt(index,'1');
        
    }
}