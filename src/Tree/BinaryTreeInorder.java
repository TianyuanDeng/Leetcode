package Tree;

import java.util.*;

public class BinaryTreeInorder {
    public static void main(String[] args) {

    }

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) return list;

            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                }else {
                    root = stack.pop();
                    list.add(root.val);
                    root = root.right;
                }
            }

            return list;
        }
    }
}
