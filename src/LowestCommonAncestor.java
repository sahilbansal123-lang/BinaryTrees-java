import java.util.ArrayList;

public class LowestCommonAncestor {

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

//    -----------------------------------------------------------------------------------------------------------------

                            //   APPROACH 1

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }

        path.add(root);
        if (root.data == n) {
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if (foundLeft || foundRight) {
            return true;
        }

        path.remove(path.size()-1);
        return false;
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

//----------------------------------------------------------------------------------------------------------------------

                                        //  APPROACH 2



    public static void main(String[] args) {

    }
}
