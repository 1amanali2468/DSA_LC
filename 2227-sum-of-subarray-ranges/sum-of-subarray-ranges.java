import java.util.*;

class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        long minSum = getMinSum(nums);
        long maxSum = getMaxSum(nums);

        return maxSum - minSum;
    }

    private long getMinSum(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        int[] pse = new int[n];

        Stack<Integer> st = new Stack<>();

        // NSE (next smaller or equal)
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        st.clear();

        // PSE (previous smaller)
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            sum += left * right * arr[i];
        }

        return sum;
    }

    private long getMaxSum(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        int[] pge = new int[n];

        Stack<Integer> st = new Stack<>();

        // NGE (next greater or equal)
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        st.clear();

        // PGE (previous greater)
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            long left = i - pge[i];
            long right = nge[i] - i;
            sum += left * right * arr[i];
        }

        return sum;
    }
}