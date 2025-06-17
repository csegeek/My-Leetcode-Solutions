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
        int [] leftRow=new int[n]; //used to store and check left
        Arrays.fill(leftRow,0);
        int [] upDiagonal=new int[2*n-1];
        Arrays.fill(upDiagonal,0);
        int[] lowDiagonal=new int[2*n-1];
        Arrays.fill(lowDiagonal,0);
     //   solve(n,0,board,response);
        solve(n,0,board,response,leftRow,upDiagonal,lowDiagonal);
        return response;
    }

    // private void solve(int n,int col,List<String> board,List<List<String>> response){
    //     if(col>=n){
    //         System.out.println(board);
    //         response.add(new ArrayList<>(board));
    //         return;
    //     }
    //     for(int row=0;row<n;row++){
    //         if(isSafe(n,row,col,board)){
    //             StringBuilder sb=new StringBuilder(board.get(row));
    //             sb.setCharAt(col,'Q');
    //             board.set(row,sb.toString());
    //             solve(n,col+1,board,response);
    //             sb.setCharAt(col,'.');
    //             board.set(row,sb.toString());
    //         }
    //     }

    // }

    // private boolean isSafe(int n,int row ,int col,List<String> board){
    //     int dupRow=row;
    //     int dupCol=col;
    //     //Left-Upward-diagona;
    //     while(row>=0 && col>=0){
    //         if(board.get(row).charAt(col)=='Q') return false;
    //         row--;
    //         col--;
    //     }
    //     row=dupRow;
    //     col=dupCol;
    //     //backwards
    //     while(col>=0){
    //         if(board.get(row).charAt(col)=='Q') return false;
    //         col--;
    //     }
    //     col=dupCol;
    //     while(row<n && col>=0){
    //         if(board.get(row).charAt(col)=='Q') return false;
    //         row++;
    //         col--;
    //     }
    //     return true;
    // }

    //##### Solved Using Hashing Techniques..........

    public void solve(int n,int col,List<String> board,List<List<String>> response,int []leftRow,int[] upDiagonal,int[] lowDiagonal){
        if(col>=n){
            response.add(new ArrayList(board));
            return;
        }

for(int row=0;row<n;row++){
            if(leftRow[row]!=1 && lowDiagonal[row+col]!=1 && upDiagonal[n-1+col-row] !=1){
                StringBuilder sb=new StringBuilder(board.get(row));
                sb.setCharAt(col,'Q');
                board.set(row,sb.toString());
                leftRow[row]=1;
                lowDiagonal[row+col]=1;
                upDiagonal[n-1+col-row]=1;
                solve(n,col+1,board,response,leftRow,upDiagonal,lowDiagonal);
                sb.setCharAt(col,'.');
                board.set(row,sb.toString());
                leftRow[row]=0;
                lowDiagonal[row+col]=0;
                upDiagonal[n-1+col-row]=0;
            }
        }
    }

}