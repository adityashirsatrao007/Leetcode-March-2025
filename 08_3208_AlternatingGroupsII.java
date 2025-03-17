import java.util.List;

class Solution {
    public int numberOfAlternatingGroups(List<Integer> colors, int k) {
        int n = colors.size();
        int count = 0;
        int l = 0;
        int limit = n + k - 1;

        while (l < n) {
            // Find largest valid window
            int r = l + 1;
            while (r < limit && colors.get((r - 1) % n) != colors.get(r % n)) {
                r++;
            }

            // Count Valid Windows
            if (r - l >= k) {
                count += (r - l) - k + 1;
            }
            l = r;
        }
        return count;
    }
}