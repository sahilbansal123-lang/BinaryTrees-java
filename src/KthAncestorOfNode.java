public class KthAncestorOfNode {

    public static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }

    public static int kthAncestor(Node root, int n, int k) {
        if (root.data == n) {
            return 0;
        }
        int leftDist = kthAncestor(root.left, n, k);
        int rightDist = kthAncestor(root.right, n, k);

        if (leftDist == -1 || rightDist == -1) {
            return -1
        }
        int max = Math.max(leftDist, rightDist);
        if (max + 1 == k) {
            System.out.println(root.data);
        }

        return max+1;
    }

    public static void main(String[] args) {

    }
}
