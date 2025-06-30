class Solution {
    public int totalNumbers(int[] digits) {
        Set<String> set=new HashSet<>();
        int [] visited=new int[digits.length];
        Arrays.fill(visited,-1);
        recursion(digits,0,"",set,visited);
        return set.size();
    }
    private void recursion(int[] digits,int index,String number,Set<String> numbers,int [] visited){
        
        if(index>=digits.length||number.length()==3)
        {    

            if(number.length()==3 && Integer.parseInt(number)%2==0 && number.charAt(0)!='0'){
            System.out.println(number);
         if(!numbers.contains(number)){
            numbers.add(number);
         }
            }
         return;
        }
        for(int i=0;i<digits.length;i++){
            if(visited[i]!=1){
                visited[i]=1;
            recursion(digits,i,number+digits[i],numbers,visited);
            visited[i]=-1;
            }
        
        }

    }
}