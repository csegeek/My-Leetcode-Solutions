class Solution {
    public List<String> letterCombinations(String digits) {
      if(digits.length()==0) return new ArrayList();
      Map<Character, Character[]> map = Map.of(
            '2', new Character[]{'a', 'b', 'c'},
            '3', new Character[]{'d', 'e', 'f'},
            '4', new Character[]{'g', 'h', 'i'},
            '5', new Character[]{'j', 'k', 'l'},
            '6', new Character[]{'m', 'n', 'o'},
            '7', new Character[]{'p', 'q', 'r', 's'},
            '8', new Character[]{'t', 'u', 'v'},
            '9', new Character[]{'w', 'x', 'y', 'z'}
        );
     List<String> response=new ArrayList<>();
     recursiveSol(0,new StringBuilder(""),digits,map,response);
     return response;
        
    }

    private void recursiveSol(int index,StringBuilder temp,String digits,Map<Character,Character[]> map,List<String> response){
        if(index>=digits.length()){
            System.out.println(temp.toString());
            response.add(temp.toString());
            return;
        }
       Character[] values=map.get(digits.charAt(index));
       for(int i=0;i<values.length;i++){
        temp.append(values[i]);
        recursiveSol(index+1,temp,digits,map,response);
        temp.deleteCharAt(temp.length()-1);
       }
    }
}