class Solution {
    public int totalFruit(int[] fruits) {
        int maxLength=Integer.MIN_VALUE;
        int l=0;
        int r=0;
        Map<Integer,Integer> map=new HashMap<>();
        while(r<fruits.length){
            map.put(fruits[r],map.getOrDefault(fruits[r],0)+1);
           while(map.size()>2){
            if(map.get(fruits[l])>1){
                map.put(fruits[l],map.get(fruits[l])-1);
            }
            else {
                map.remove(fruits[l]);
            }
            l++;
           }
        //   if(zeros>k){
        //     if(nums[l]==0) zeros--;
        //     l++;
        //   }
           if(map.size()<=2){
            maxLength=Math.max(maxLength,r-l+1);
           }
           r++;
        }
        return maxLength;
    }
}