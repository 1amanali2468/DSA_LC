import java.util.*;

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        for (char c : num.toCharArray()) {
            while (!st.isEmpty() && k > 0 && st.peek() > c) {
                st.pop();
                k--;
            }
            st.push(c);
        }

        // if k still left → remove from end
        while (k > 0) {
            st.pop();
            k--;
        }

        // build result
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        sb.reverse();

        // remove leading zeros
        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }

        String res = sb.substring(i);

        return res.isEmpty() ? "0" : res;
    }
}