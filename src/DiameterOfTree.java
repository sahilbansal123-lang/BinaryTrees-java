import static java.lang.Math.max;

public class DiameterOfTree {

    static class Node{
        int data;
        TreeTraversal.Node left;
        TreeTraversal.Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;
        public static TreeTraversal.Node buildTree(int nodes[]) {
            idx++;
            if(nodes[idx] == -1) {
                return null;
            }
            TreeTraversal.Node newNode = new TreeTraversal.Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

//  Time Complexity: O(n^2)

    public static int height(TreeTraversal.Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int myHeight = max(leftHeight, rightHeight) + 1;
        return myHeight;
    }

    public static int diameter(TreeTraversal.Node root){
        if (root == null) {
            return 0;
        }
        int dia1 = diameter(root.left);
        int dia2 = diameter(root.right);
        int dia3 = height(root.left) + height(root.right) + 1;

        return Math.max( Math.max(dia1, dia2), dia3);
    }

    static class TreeInfo{
        int height;
        int diam;

        TreeInfo(int height, int diam){
            this.height = height;
            this.diam = diam;
        }
    }

    //    Time Complexity: O(N)
    public static TreeInfo diameter2(TreeTraversal.Node root) {
        if(root == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo leftTI = diameter2(root.left);
        TreeInfo rightTI = diameter2(root.right);

        int myHeight = Math.max(leftTI.height, rightTI.height) + 1;


        int diam1 = leftTI.height + rightTI.height + 1;
        int diam2 = leftTI.diam;
        int diam3 = rightTI.diam;


        int myDiam = Math.max(diam1, Math.max(diam2, diam3));


        return new TreeInfo(myHeight, myDiam);
    }
}
