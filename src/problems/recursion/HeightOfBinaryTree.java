package problems.recursion;

public class HeightOfBinaryTree {
    public static void main(String[] args) {
        Node<Integer> root = new Node<>(10)
                                .left(new Node<Integer>(6)
                                        .left(new Node<Integer>(5)
                                                .left(new Node<Integer>(4))
                                            )
                                        .right(new Node<Integer>(7))
                                    )
                                .right(new Node<Integer>(11));
        int height = height(root);
        System.out.println(height);
    }

    private static int height(Node<Integer> root) {
        if(null==root) return 0 ;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
