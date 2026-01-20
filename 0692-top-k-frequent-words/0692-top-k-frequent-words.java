class Solution {
    public List<String> topKFrequent(String[] words, int k) {
   // 1. Frequency map
        HashMap<String, Integer> freqMap = new HashMap<>();
        for (String n : words) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        // 2. Buckets: index = frequency
        List<String>[] buckets = new ArrayList[words.length + 1];

        for (String key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        // 3. Collect top k from high frequency to low
        List<String> res = new ArrayList<>();
        int idx = 0;

        for (int i = buckets.length - 1; i >= 0 && idx < k; i--) {
            if (buckets[i] != null) {
                Collections.sort(buckets[i]);
                for (String val : buckets[i]) {
                    if (idx < k) {
                        res.add(val);
                        idx++;
                    }
                }
            }
        }

        return res;
    }
}