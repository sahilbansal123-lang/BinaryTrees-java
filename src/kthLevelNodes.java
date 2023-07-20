
public class kthLevelNodes {

    public static void kthLevel(DiameterOfTree.Node root, int level, int k) {
        if (level == k) {
            System.out.println(root.data + " ");
            return;
        }
        if (root == null) {
            return;
        }

        kthLevel(root.left, level+1, k);
        kthLevel(root.right, level+1, k);

    }

    public static void main(String[] args) {

    }

}
