class Solution {
    public String frequencySort(String s) {
        Pair[] freq = new Pair[256];
        
        // Initialize the frequency array
        for (int i = 0; i < 256; i++) {
            freq[i] = new Pair(0, (char)(i + '0'));
        }

        // Count frequency of each character in the string
        for (char ch : s.toCharArray()) {
            freq[ch - '0'].freq++;
        }

        // Sort array by frequency descending, then by character ascending
        Arrays.sort(freq, (p1, p2) -> {
            if (p1.freq != p2.freq) return p2.freq - p1.freq;
            return p1.ch - p2.ch;
        });

        // Collect characters with non-zero frequency into result list
        StringBuilder res=new StringBuilder("");
        for (Pair p : freq) {
            if (p.freq > 0){
               for(int i=0;i<p.freq;i++){
                res.append(p.ch);
               }
            } 
        }

        
        return  res.toString();
    }

    class Pair {
        int freq;
        char ch;
        Pair(int f, char c) {
            this.freq = f;
            this.ch = c;
        }
    }
}