class Solution {

    public int beautySum(String s) {
        int n = s.length();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];

            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;
                sum += getBeauty(freq);
            }
        }
        return sum;
    }

    // Separated for readability
    private int getBeauty(int[] freq) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int f : freq) {
            if (f > 0) {
                min = Math.min(min, f);
                max = Math.max(max, f);
            }
        }
        return max - min;
    }
}
