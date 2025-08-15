class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int pg=0;
        int ps=0;
        int count=0;
        while(pg<g.length && ps<s.length){
            if(g[pg]<=s[ps]){
                count++;
                pg++;
            }
            ps++;
        }
        return count;
    }
}