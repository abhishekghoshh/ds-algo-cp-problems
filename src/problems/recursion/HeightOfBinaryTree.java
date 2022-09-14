package problems.recursion;

import util.BinaryTreeNode;

public class HeightOfBinaryTree {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10)
                                .left(new BinaryTreeNode<Integer>(6)
                                        .left(new BinaryTreeNode<Integer>(5)
                                                .left(new BinaryTreeNode<Integer>(4))
                                            )
                                        .right(new BinaryTreeNode<Integer>(7))
                                    )
                                .right(new BinaryTreeNode<Integer>(11));
        int height = height(root);
        System.out.println(height);
    }

    private static int height(BinaryTreeNode<Integer> root) {
        if(null==root) return 0 ;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
