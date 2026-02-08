class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] preSum = new int[n][m];
        for (int j = 0; j < m; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (matrix[i][j] == '0')
                    sum = 0;
                else
                    sum += 1;
                preSum[i][j] = sum;
            }
        }
        // for(int[] arr:preSum)
        // System.out.println(Arrays.toString(arr));
        int maxArea=0;
        for (int i = 0; i < n; i++) {
          maxArea=Math.max(maxArea,largestRectangleArea(preSum[i]));
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for (int i = 0; i <= n; i++) {
            while (i < n && !stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            while (i == n && !stack.isEmpty()) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }

}