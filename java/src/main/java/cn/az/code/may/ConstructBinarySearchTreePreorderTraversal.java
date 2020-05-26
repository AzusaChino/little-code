package cn.az.code.may;

import cn.az.code.common.TreeNode;

/**
 * @author az
 * @date 2020/5/25
 */
public class ConstructBinarySearchTreePreorderTraversal {

    int i = 0;

    public TreeNode bstFromPreorder(int[] A) {
        return bstFromPreorder(A, Integer.MAX_VALUE);
    }

    public TreeNode bstFromPreorder(int[] A, int bound) {
        if (i == A.length || A[i] > bound) {
            return null;
        }
        TreeNode root = new TreeNode(A[i++]);
        root.left = bstFromPreorder(A, root.val);
        root.right = bstFromPreorder(A, bound);
        return root;
    }
}