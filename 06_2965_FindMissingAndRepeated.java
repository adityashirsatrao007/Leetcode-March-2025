import java.util.ArrayList;
import java.util.List;

 class Solution {
    public List<Integer> findMissingAndRepeatedValues(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return new ArrayList<>(); // Return empty list for invalid input
        }

        int n = grid.length;
        int repeating = -1, missing = -1;
        int[] count = new int[n * n + 1]; // Array to track occurrences

        // Count occurrences of each number in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count[grid[i][j]]++;
            }
        }

        // Find the repeating and missing numbers
        for (int num = 1; num <= n * n; num++) {
            if (count[num] == 2) {
                repeating = num;
            } else if (count[num] == 0) {
                missing = num;
            }
        }

        List<Integer> result = new ArrayList<>();
        result.add(repeating);
        result.add(missing);
        return result;
    }
}
