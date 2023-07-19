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

    //  Post Order Traversal
    public static void postOrder(Node root){
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");

    }

    //  Level Order Traversal
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


//  Ques5: Subtree of a tree
    //  Time complexity: O()
public static boolean isSubtree(Node tree, Node subTree) {
    if (subTree == null) {
        // An empty tree is always a subtree
        return true;
    }

    if (tree == null) {
        // We've reached the end of the main tree
        return false;
    }

    // Check if the current nodes match
    if (tree.data == subTree.data && isIdentical(tree, subTree)) {
        return true;
    }

    // Check if the subtree is in the left or right subtree of the current node
    return isSubtree(tree.left, subTree) || isSubtree(tree.right, subTree);
}

    public static boolean isIdentical(Node tree1, Node tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }

        if (tree1 == null || tree2 == null) {
            return false;
        }

        if (tree1.data != tree2.data) {
            return false;
        }

        return isIdentical(tree1.left, tree2.left) && isIdentical(tree1.right, tree2.right);
    }

//  Ques6: sum of nodes at Kth level\
    public static int sumAtKth(Node root, int k){
        if(root == null) {
            return 0;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int level = 0;
        int sum = 0;
        while(!q.isEmpty()){
            Node currNode = q.remove();
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



    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 7, -1, -1, 3, -1, 6, -1, -1, };
//        int nodes[] = {2, 4, -1, -1, 5};
        BinaryTree tree = new BinaryTree();
//        BinaryTree subTree = new BinaryTree();
        Node root = tree.buildTree(nodes);
//        Node subRoot = subTree.buildTree(node1);

//        System.out.println(isSubtree(root, subRoot));

        levelOrder(root);
        System.out.println(count(root));
        System.out.println(sum(root));
        System.out.println(height(root));
        System.out.println(diameter(root));
        TreeInfo result = diameter2(root);
        System.out.println("Height: " + result.height);
        System.out.println("Diameter: " + result.diam);
        System.out.println(sumAtKth(root, 2));

    }
}
