import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopViewOfBt {

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

    public static class Info {
        Node node;
        int hd;

        public Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }


    public static void topView(Node root) {
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new Info(root, 0));

        while(!q.isEmpty()) {
            Info curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            }

            if (!map.containsKey(curr.hd)) {
                map.put(curr.hd, curr.node);
            }
            if (curr.node.left != null) {
                q.add(new Info(curr.node, curr.hd-1));
                min = Math.min(min, curr.hd-1);
            }
            if (curr.node.right != null) {
                q.add(new Info(curr.node, curr.hd+1));
                max = Math.max(max, curr.hd+1);
            }
        }
        
        // printing data of hash map

        for (int i = min; i <= max; i++) {
            System.out.println(map.get(i).data + " ");
        }
        System.out.println();
        
    }

    public static void main(String[] args) {
        
    }
}
