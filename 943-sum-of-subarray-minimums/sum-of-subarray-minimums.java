class Solution {
    public int sumSubarrayMins(int[] arr) {
        int [] nse = findNse(arr);
        int [] psee = findPsee(arr);
        long total = 0;
        int mod = (int)(1e9 + 7);
        for (int i = 0; i < arr.length; i++) {
            int left = i - psee[i];
            int right = nse[i] - i;

            total = (total + ((long) left * right * arr[i]) % mod) % mod;
        }
        return (int) total;
    }
    public static int[] findNse(int[] a){
        int n = a.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && a[st.peek()] >= a[i]){
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }
    public static int[] findPsee(int[] a){
        int n = a.length;
        int[] psee = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && a[st.peek()] > a[i]){
                st.pop();
            }
            psee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return psee;
    }
}