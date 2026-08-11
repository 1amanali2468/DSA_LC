/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int preIndex = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Store inorder value -> index
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length - 1);
    }
    private TreeNode build(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd)
            return null;
        // Preorder gives the root
        int rootValue = preorder[preIndex++];
        TreeNode root = new TreeNode(rootValue);
        // Find root position in inorder
        int rootIndex = map.get(rootValue);
        // Build left subtree
        root.left = build(preorder, inStart, rootIndex - 1);
        // Build right subtree
        root.right = build(preorder, rootIndex + 1, inEnd);
        return root;
    }
}