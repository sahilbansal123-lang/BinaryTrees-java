//     Binary trees: are a type of data structure commonly used in computer science and programming. A binary tree
//                   is a tree data structure in which each node has at most two children, referred to as the left child
//                   and the right child. The nodes themselves can contain data, such as a number, string, or object.
//
//                   The topmost node of the tree is called the root, and it is the only node that does not have a parent.
//                   The children of a node can also be nodes that have their own children, creating a hierarchy that can be used
//                   to represent relationships between data.


public class BuildBinaryTreeyt {

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
   
   static class BinaryTree {
       static int idx = -1;
       public static Node buildTree(int[] nodes) {
           idx++;
           if (nodes[idx] == -1) {
               return null;
           }
           Node newNode = new Node(nodes[idx]);
           newNode.left = buildTree(nodes);
           newNode.right = buildTree(nodes);

           return newNode;
       }
   }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = BinaryTree.buildTree(nodes);

        System.out.println(root.data);
    }

}