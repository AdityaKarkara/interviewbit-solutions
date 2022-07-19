package interviewbit;

import interviewbit.util.TreeNode;

public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode A) {
        if (A == null) return 0;
        int left = maxDepth(A.left);
        int right = maxDepth(A.right);
        return Math.max(left, right) + 1;
    }
}
