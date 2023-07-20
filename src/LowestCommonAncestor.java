import java.util.ArrayList;

public class LowestCommonAncestor {

    static class Node {
        BuildBinaryTreeyt.Node right;
        BuildBinaryTreeyt.Node left;
        int data;

        public Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }
    public static void getPath(Node root, int n1, ArrayList<Node> path1) {
    }
    public static Node lowectCommonAncestor(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        // Last Common Ancestor
        int i = 0;
        for(; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)){
                break;
            }
        }
        Node lca = path1.get(i-1);
        return lca;
    }



    public static void main(String[] args) {

    }
}
