class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lb=lowerBound(nums,target);
        if(lb >= nums.length || nums[lb]!=target) {
            return new int []{-1,-1};
        }
        return new int [] {lb,upperBound(nums,target)-1};
    }

    public int upperBound(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;  // Default to length if not found

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > x) {
                ans = mid;        // Store current index as potential answer
                high = mid - 1;   // Move left
            } else {
                low = mid + 1;    // Move right
            }
        }
        return ans;  // Return final answer
    }

    public int lowerBound(int[] arr, int x) {
        int low = 0;                  // Start index
        int high = arr.length - 1;    // End index
        int ans = arr.length;         // Default value if not found

        while (low <= high) {
            int mid = (low + high) / 2;  // Find mid index

            if (arr[mid] >= x) {
                ans = mid;            // Store possible answer
                high = mid - 1;       // Move left
            } else {
                low = mid + 1;        // Move right
            }
        }
        return ans;  // Return the lower bound index
  }
}

  