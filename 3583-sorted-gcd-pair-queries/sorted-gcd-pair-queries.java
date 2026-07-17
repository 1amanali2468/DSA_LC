import java.util.*;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        // Frequency of each value
        int[] freq = new int[max + 1];
        for (int x : nums) {
            freq[x]++;
        }

        // exact[g] = number of pairs whose gcd is exactly g
        long[] exact = new long[max + 1];

        // Process from largest gcd to smallest
        for (int g = max; g >= 1; g--) {
            long cnt = 0;

            // Count numbers divisible by g
            for (int multiple = g; multiple <= max; multiple += g) {
                cnt += freq[multiple];
            }

            // Total pairs divisible by g
            exact[g] = cnt * (cnt - 1) / 2;

            // Remove pairs already counted for larger gcds
            for (int multiple = 2 * g; multiple <= max; multiple += g) {
                exact[g] -= exact[multiple];
            }
        }

        // Prefix counts
        long[] prefix = new long[max + 1];
        for (int g = 1; g <= max; g++) {
            prefix[g] = prefix[g - 1] + exact[g];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long q = queries[i] + 1; // convert 0-based index to 1-based count

            int l = 1, r = max;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (prefix[mid] >= q)
                    r = mid;
                else
                    l = mid + 1;
            }

            ans[i] = l;
        }

        return ans;
    }
}