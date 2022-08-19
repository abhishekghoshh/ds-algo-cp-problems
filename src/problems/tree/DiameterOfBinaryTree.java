package problems.tree;

public class DiameterOfBinaryTree {
    
    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree(root));
    }
    static class Value{
        public int value = Integer.MIN_VALUE;;
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        Value value = new Value();
        height(root,value);
        return value.value-1;
    }
    private static int height(TreeNode root,Value value){
       if(null==root){
           return 0;
       }
        int leftHeight = height(root.left,value);
        int rightHeight = height(root.right,value);
        int diameter = 1+leftHeight+rightHeight;
        if(value.value<diameter){
            value.value=diameter;
        }
        return 1+ Math.max(leftHeight,rightHeight);
    }
}
