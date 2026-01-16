class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st;
        int[] res=new int[nums1.length];

        for(int i=0;i<nums1.length;i++){
             st=new Stack<>();
            for(int j=nums2.length-1;j>=0;j--){
               if(nums2[j]>nums1[i]){
                  st.push(nums2[j]);
               }
               if(nums2[j]==nums1[i]){
                if(st.isEmpty()){
                    res[i]=-1;
                }
                else{
                res[i]=st.pop();
                } 
               }
            }
        }
       return res;
    }
}