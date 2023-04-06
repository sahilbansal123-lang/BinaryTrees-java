import java.util.*;

import static java.lang.Math.max;

public class TreeTraversal {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;
        public static Node buildTree(int nodes[]) {
            idx++;
            if(nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

//  PreOrder Traversals
    public static void preOrder(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

//  Inorder Traversal
    public static void inOrder(Node root){
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    public static void postOrder(Node root){
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");

    }
    public static void levelOrder(Node root){
        if(root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if(q.isEmpty()){
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left!=null) {
                    q.add(currNode.left);
                }
                if (currNode.right!=null) {
                    q.add(currNode.right);
                }
            }
        }
    }


    //  Ques1: Count of nodes
    public static int count(Node root){

        if (root == null){
            return 0;
        }

        int leftCount = count(root.left);
        int rightNode = count(root.right);

        return leftCount + rightNode + 1;
    }
    //  Ques2: sum of nodes
    public static int sum(Node root){

        if (root == null){
            return 0;
        }

        int leftsum = sum(root.left);
        int rightsum = sum(root.right);

        return leftsum + rightsum + root.data;
    }

//  Ques3: Calculate height of the tree
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int myHeight = max(leftHeight, rightHeight) + 1;
        return myHeight;
    }

//  Ques4: Diameter of the tree
//  Time Complexity: O(n^2)
    public static int diameter(Node root){
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
    public static TreeInfo diameter2(Node root) {
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


    //  Time complexity: O()
    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        levelOrder(root);
        System.out.println(count(root));
        System.out.println(sum(root));
        System.out.println(height(root));
        System.out.println(diameter(root));
        System.out.println(diameter2(root));
    }
}
