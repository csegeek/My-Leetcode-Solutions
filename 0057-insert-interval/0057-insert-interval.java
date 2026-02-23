class Solution {
    public int[][] insert(int[][] arr, int[] newInterval) {
        List<int[]> res=new ArrayList<>();
        int n=arr.length;
        int i=0;
        while(i<n && arr[i][1]<newInterval[0]){
            res.add(arr[i]);
            i=i+1;
        }
        while(i<n && arr[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(newInterval[0],arr[i][0]);
            newInterval[1]=Math.max(newInterval[1],arr[i][1]);
            i=i+1;
        }
        res.add(newInterval);
        while(i<n){
            res.add(arr[i]);
            i=i+1;
        }
        int[][] response=new int[res.size()][2];
        for(int j=0;j<res.size();j++){
            response[j]=res.get(j);
        }
        return response;
        
    }
}