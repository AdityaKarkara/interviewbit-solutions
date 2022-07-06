package interviewbit;

import interviewbit.util.TreeNode;

import java.util.ArrayList;

public class UniqueBinarySearchTrees {
    public ArrayList<TreeNode> generateTrees(int a) {
        return generateTrees(1, a);
    }

    public ArrayList<TreeNode> generateTrees(int start, int end) {
        ArrayList<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; i++) {
            ArrayList<TreeNode> left = generateTrees(start, i - 1);
            ArrayList<TreeNode> right = generateTrees(i + 1, end);

            for (int j = 0; j < left.size(); j++) {
                TreeNode leftNode = left.get(j);
                for (int k = 0; k < right.size(); k++) {
                    TreeNode rightNode = right.get(k);
                    TreeNode node = new TreeNode(i);
                    node.left = leftNode;
                    node.right = rightNode;
                    list.add(node);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<TreeNode> list = new UniqueBinarySearchTrees().generateTrees(3);
    }
}
