import java.util.*;

class MinStack {

    Stack<Long> st;
    long min;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        long v = val;

        if (st.isEmpty()) {
            st.push(v);
            min = v;
        } else {
            if (v > min) {
                st.push(v);
            } else {
                st.push(2 * v - min); // encoded value
                min = v;
            }
        }
    }
    
    public void pop() {
        if (st.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        long x = st.pop();

        if (x < min) {
            min = 2 * min - x; // restore previous min
        }
    }
    
    public int top() {
        if (st.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        long x = st.peek();

        if (x > min) return (int)x;
        return (int)min;
    }
    
    public int getMin() {
        if (st.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return (int)min;
    }
}