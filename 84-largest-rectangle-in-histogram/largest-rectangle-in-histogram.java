class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea=0;
        int n = heights.length;
        int ind,nse,pse;
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                ind = st.pop();
                nse = i;
                pse = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, heights[ind]*(nse-pse-1));
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            nse = n;
            ind = st.pop();
            pse = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, heights[ind]*(nse-pse-1));
        }
        return maxArea;
    }
}