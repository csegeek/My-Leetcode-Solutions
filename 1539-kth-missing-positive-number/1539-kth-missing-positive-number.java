class Solution {
    public int findKthPositive(int[] arr, int k) {
        int misCnt=0;
        int i=1;
        while(misCnt<k){
         if(!isPresent(arr,i)) misCnt++;
         if(misCnt==k) return i;
          i++;
        }
        return -1;
        
    }
    private boolean isPresent(int[] arr, int k){
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=low+(high -low)/2;
            if(arr[mid]==k) return true;
            if(arr[mid]<k){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return false;
    }
}