import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int a : asteroids) {
            boolean destroyed = false;

            while (!st.isEmpty() && st.peek() > 0 && a < 0) {
                int top = st.peek();

                if (top < -a) {
                    st.pop(); // top explodes
                } 
                else if (top == -a) {
                    st.pop(); // both explode
                    destroyed = true;
                    break;
                } 
                else {
                    destroyed = true; // current explodes
                    break;
                }
            }

            if (!destroyed) {
                st.push(a);
            }
        }

        int[] res = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            res[i] = st.pop();
        }

        return res;
    }
}