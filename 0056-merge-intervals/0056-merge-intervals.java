class Solution {
    public int[][] merge(int[][] intervals) {
        int m = intervals.length;
        int n = 2;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList();
        for (int i = 0; i < m; i++) {
            if (ans.isEmpty() || ans.getLast()[1] < intervals[i][0]) {
                ans.add(intervals[i]);
            } else {
                ans.set(ans.size() - 1,
                        new int[] {
                                ans.get(ans.size() - 1)[0],
                                Math.max(ans.get(ans.size() - 1)[1], intervals[i][1])
                        });
            }
        }
      int[][] response = new int[ans.size()][2];

for (int i = 0; i < ans.size(); i++) {
    response[i] = ans.get(i);
}
return response;
     
    }
}