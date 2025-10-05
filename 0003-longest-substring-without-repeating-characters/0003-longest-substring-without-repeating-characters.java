class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int maxLength = 0;
        while (l <= r && r < s.length()) {
            char ch = s.charAt(r);

            if (!map.containsKey(ch) || map.get(ch) < l) {
                // character not in current window
                map.put(ch, r);
                int length = r - l + 1;
                maxLength = Math.max(maxLength, length);
            } else {
                // character repeated within window
                l = map.get(ch) + 1; // move left pointer
                map.put(ch, r); // update latest index of character
            }
            r++;
        }

        return maxLength;
    }
}