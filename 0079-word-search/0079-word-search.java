class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                  boolean searchResult=search(board,word,i,j,0,board.length,board[0].length);
                  System.out.println("Search result ------>"+searchResult);
                  if(searchResult) {
                    return true;
                  }
                }
            }
        }
        return false;
        
    }

   private boolean search(char[][] board,String word,int i,int j,int index,int n,int m){
        if(index>=word.length()){
            System.out.println("returning true");
            return true;
        }
        if(i<0||j<0||i==n||j==m||board[i][j]!=word.charAt(index)) return false;
        char temp=board[i][j];
        board[i][j]='#';
        boolean op1=search(board,word,i+1,j,index+1,n,m);
         boolean op2=search(board,word,i,j+1,index+1,n,m);
          boolean op3=search(board,word,i-1,j,index+1,n,m);
           boolean op4=search(board,word,i,j-1,index+1,n,m);
           board[i][j]=temp;
   return op1|| op2||op3||op4;
}
}