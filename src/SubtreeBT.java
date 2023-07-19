public class SubtreeBT {

    public static boolean isIdentical(TreeTraversal.Node tree1, TreeTraversal.Node tree2) {
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


    //  Ques5: Subtree of a tree
    //  Time complexity: O()
    public static boolean isSubtree(TreeTraversal.Node tree, TreeTraversal.Node subTree) {
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

}
