class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = max(weights);
        int high = sum(weights);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (noDays(weights, mid) > days) {
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        return low;
    }

    private int sum(int[] weights) {
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
        }
        return sum;
    }

    private int noDays(int[] weights, int cap) {
        int days = 1;
        int tcap = cap;
        for (int i = 0; i < weights.length; i++) {
            if (tcap >= weights[i]) {
                tcap = tcap - weights[i];
            } else {
                days++;
                tcap = cap;
                tcap = tcap - weights[i];
            }
        }
        return days;
    }

    private int max(int[] weights) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < weights.length; i++) {
            max = Math.max(max, weights[i]);
        }
        return max;
    }

}