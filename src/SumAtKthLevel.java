import java.util.LinkedList;
import java.util.Queue;

public class SumAtKthLevel {



    //  Ques6: sum of nodes at Kth level\
    public static int sumAtKth(TreeTraversal.Node root, int k){
        if(root == null) {
            return 0;
        }
        Queue<TreeTraversal.Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int level = 0;
        int sum = 0;
        while(!q.isEmpty()){
            TreeTraversal.Node currNode = q.remove();
            if (currNode == null) {
                level++;
                if(q.isEmpty()){
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (level == k ){
                    sum = sum + currNode.data;
                }
                if (currNode.left!=null) {
                    q.add(currNode.left);
                }
                if (currNode.right!=null) {
                    q.add(currNode.right);
                }
            }
        }
        return sum;
    }

}
