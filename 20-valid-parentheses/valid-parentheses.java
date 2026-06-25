import java.util.*;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            if(curr=='(' || curr=='[' || curr=='{') st.push(curr);
            else{
                if(st.empty()) return false;
                char ch = st.peek();
                st.pop();
                if((curr==')' && ch=='(')|| (curr==']' && ch=='[')|| (curr=='}' && ch=='{'))
                continue;
                else return false;
            }
        }
        return st.isEmpty();
    }
}