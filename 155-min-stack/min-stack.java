import java.util.*;

class MinStack {

    Stack<Long> st;
    long min;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {

        if(st.isEmpty()){
            min = val;
            st.push((long)val);
        }
        else{

            if(val > min){
                st.push((long)val);
            }
            else{
                st.push(2L * val - min);
                min = val;
            }
        }
    }

    public void pop() {

        long x = st.pop();

        if(x < min){
            min = 2 * min - x;
        }
    }

    public int top() {

        long x = st.peek();

        if(x < min)
            return (int)min;

        return (int)x;
    }

    public int getMin() {
        return (int)min;
    }
}