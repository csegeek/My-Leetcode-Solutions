class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> fmap=new HashMap<>();
        HashMap<Integer,ArrayList<Integer>> bucket=new HashMap<>();
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int n:nums){
            fmap.put(n,fmap.getOrDefault(n,0)+1);
        }

        for(int key:fmap.keySet()){
            int frequency=fmap.get(key);
           
            if(bucket.containsKey(frequency)){
                ArrayList<Integer> temp=bucket.get(frequency);
                temp.add(key);
                bucket.put(frequency,temp);
            }
            else{
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(key);
                bucket.put(frequency,temp);
                 maxHeap.add(frequency);
            }
        }
        int[] res = new int[k];
        int idx = 0;

        // collect top k
        while (idx < k) {
            int freq = maxHeap.poll();
            ArrayList<Integer> list = bucket.get(freq);

            for (int val : list) {
                if (idx < k) {
                    res[idx++] = val;
                }
            }
        }

        return res;
    }
}