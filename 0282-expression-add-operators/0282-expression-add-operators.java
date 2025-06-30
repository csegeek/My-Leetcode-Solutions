class Solution {
    public List<String> addOperators(String num, int target) {
       List<String> response=new ArrayList<>();
       recursion(0,num,target,"",0,0,response);
       return response;

    }

   private void recursion(int index,String num,int target,String exp,long prev,long res,List<String> response){
    if(index>=num.length() ){
     if(target==res){
      response.add(exp);
     }
      return;
    }
    
    for(int j=index;j<num.length();j++){
        if(j>index && num.charAt(index)=='0') break;
        long number=Long.parseLong(num.substring(index,j+1));
        if(index==0){
            recursion(j+1,num,target,num.substring(index,j+1),number,number,response);
        }
        else{
            recursion(j+1,num,target,exp+"+"+num.substring(index,j+1),number,res+number,response);
                        recursion(j+1,num,target,exp+"-"+num.substring(index,j+1),-number,res-number,response);
                        recursion(j+1,num,target,exp+"*"+num.substring(index,j+1),prev*number,res-prev+(prev*number),response);
            
        }

    }
    
     
   }

}