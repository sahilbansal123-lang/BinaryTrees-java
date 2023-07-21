public class MirrorBinaryTree {

    static class Node {
        Node right;
        Node left;
        int data;

        public Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    static class Mirror {
        Node roots;

        public void Mirror() {
            roots = mirrorBt(roots);
        }
    }

    public static Node mirrorBt(Node root) {
        if (root == null) {
            return root;
        }

        Node left = mirrorBt(root.left);
        Node right = mirrorBt(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        preOrder(root.left);
        System.out.print(root.data + " ");
        preOrder(root.right);
     }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        preOrder(root);
        mirrorBt(root);
        System.out.println();
        preOrder(root);
    }
}
