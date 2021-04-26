package MaximumDepthOfBinaryTree;

import java.util.Random;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        int nodeNum = new Random().nextInt(101);
        for(int i = 0; i < nodeNum;i++){
            
        }
    }
    
}


//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return  0;
        }
        int depthLeft = maxDepth(root.left) + 1;
        int depthRight = maxDepth(root.right) + 1;

        if (depthLeft > depthRight){
            return depthLeft;
        } else {
            return depthRight;
        }
    }
}