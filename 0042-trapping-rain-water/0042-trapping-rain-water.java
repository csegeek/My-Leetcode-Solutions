class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] lmax=new int[n];
        int[] rmax=new int[n];
        //Stack<Integer> st =new Stack<>();
        //maxleft 
        lmax[0]=height[0];
        for(int i=1;i<n;i++){
         lmax[i]=Math.max(lmax[i-1],height[i]);
        }
        //st=new Stack<>();
        // maxRight
        rmax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
          rmax[i]=Math.max(rmax[i+1],height[i]);
        }


        int result=0;

        for(int i=0;i<n;i++){
            System.out.println(height[i]+": "+"L-->"+lmax[i]+"R-->"+rmax[i]);
            int min=Math.min(lmax[i],rmax[i]);
            result+=min!=0?min-height[i]:0;
        }
        return result;
    }
}