class Solution {
    public int minCost(int n, int[] cuts) {
    //     int [][] dp=new int [cuts.length+2][cuts.length+2];
    //     for(int [] dpi:dp){
    //         Arrays.fill(dpi,-1);
    //     }
    //     int [] arr=new int[cuts.length+2];
    //     arr[0]=0;
    //     for(int i=0;i<cuts.length;i++){
    //         arr[i+1]=cuts[i];
    //     }
    //     arr[cuts.length+1]=n;
    //     Arrays.sort(arr);
    //   return recursion(1,arr.length-2,arr,dp);
         return tabulation(n,cuts);
    }

    int recursion(int i, int j,int[] arr,int[][] dp) {
         if(i>j) return 0;
         if(dp[i][j]!=-1) return dp[i][j];
         int min =(int) 1e9;
         for(int k=i;k<=j;k++){
                int cost=arr[j+1]-arr[i-1]+recursion(i,k-1,arr,dp)+recursion(k+1,j,arr,dp);
                min=Math.min(min,cost);
         }
         return dp[i][j]= min;
    }

    int tabulation(int n,int[] cuts){
        int [][] dp=new int [cuts.length+2][cuts.length+2];
        int [] arr=new int[cuts.length+2];
        arr[0]=0;
        for(int i=0;i<cuts.length;i++){
            arr[i+1]=cuts[i];
        }
        arr[cuts.length+1]=n;
        Arrays.sort(arr);
        for(int i=cuts.length;i>0;i--){
            for(int j=1;j<=cuts.length;j++){
                if(i>j) continue;
                int min =(int) 1e9;
         for(int k=i;k<=j;k++){
                int cost=arr[j+1]-arr[i-1]+dp[i][k-1]+dp[k+1][j];
                min=Math.min(min,cost);
         }
          dp[i][j]= min; 
            }
        } 
        return dp[1] [cuts.length];
    }
}