class Solution {
    public int characterReplacement(String s, int k) {
        
        int left = 0;
        int right = 0;
        int maxl = 0;
        int maxf = 0;

        int[] map = new int[26];

        while (right < s.length()) {

            map[s.charAt(right) - 'A']++;

            maxf = Math.max(maxf, map[s.charAt(right) - 'A']);

            while ((right - left + 1) - maxf > k) {
                map[s.charAt(left) - 'A']--;
                left++;
            }

            maxl = Math.max(maxl, right - left + 1);

            right++;
        }

        return maxl;
    }
}