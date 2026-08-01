class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        TreeNode lastVisited = null;

        while (curr != null || !st.isEmpty()) {

            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {

                TreeNode temp = st.peek();

                if (temp.right != null && lastVisited != temp.right) {
                    curr = temp.right;
                } else {
                    ans.add(temp.val);
                    lastVisited = temp;
                    st.pop();
                }
            }
        }

        return ans;
    }
}