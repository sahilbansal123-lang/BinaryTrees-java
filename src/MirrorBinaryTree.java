public class MirrorBinaryTree {

    public static CheckUnivalued.Node mirrorBt(CheckUnivalued.Node root) {
        if (root == null) {
            return root;
        }

        CheckUnivalued.Node left = mirrorBt(root.left);
        CheckUnivalued.Node right = mirrorBt(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public static void main(String[] args) {

    }
}
