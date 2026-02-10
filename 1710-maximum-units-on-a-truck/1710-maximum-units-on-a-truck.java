class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int n=boxTypes.length;
        int maxUnits=0;
        Arrays.sort(boxTypes,(a,b)->b[1]-a[1]);
        int i=0;
        while(i<n && truckSize>0 ){
            int t=Math.min(boxTypes[i][0],truckSize);
            maxUnits+=t*boxTypes[i][1];
            truckSize-=t;
            i++;
        }
        return maxUnits;
    }
}