class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> response=new ArrayList<>();
        List<String> board=new ArrayList<>();
        for(int i=0;i<n;i++){
            StringBuilder s=new StringBuilder("");
          for(int j=0;j<n;j++){
            s.append(".");
          }
          board.add(s.toString());   
        }
        solve(n,0,board,response);
        
        return response;

    }

    private void solve(int n,int col,List<String> board,List<List<String>> response){
        if(col>=n){
            System.out.println(board);
            response.add(new ArrayList<>(board));
            return;
        }
        for(int row=0;row<n;row++){
            if(isSafe(n,row,col,board)){
                StringBuilder sb=new StringBuilder(board.get(row));
                sb.setCharAt(col,'Q');
                board.set(row,sb.toString());
                solve(n,col+1,board,response);
                sb.setCharAt(col,'.');
                board.set(row,sb.toString());
            }
        }

    }

    private boolean isSafe(int n,int row ,int col,List<String> board){
        int dupRow=row;
        int dupCol=col;
        //Left-Upward-diagona;
        while(row>=0 && col>=0){
            if(board.get(row).charAt(col)=='Q') return false;
            row--;
            col--;
        }
        row=dupRow;
        col=dupCol;
        //backwards
        while(col>=0){
            if(board.get(row).charAt(col)=='Q') return false;
            col--;
        }
        col=dupCol;
        while(row<n && col>=0){
            if(board.get(row).charAt(col)=='Q') return false;
            row++;
            col--;
        }
        return true;
    }

}