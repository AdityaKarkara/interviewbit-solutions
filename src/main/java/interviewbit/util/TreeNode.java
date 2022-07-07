package interviewbit.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
    }
}
