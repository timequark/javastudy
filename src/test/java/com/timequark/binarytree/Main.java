package com.timequark.binarytree;

public class Main {




    public static void main(String[] args) {
        /**
         *                         1
         *                    /       \
         *                    2               3
         *                  /  \              /      \
         *                 4      5           6             7
         *                / \    /  \        /   \        /   \
         *               8   9   10  11     12   13    14    15
         *              /\  /  \  /\    / \   /  \  /  \  /  \  /  \
         *           20 21 22 23  24 25 26 27 28 29 30 31 32 33 34 35
         *
         * */

/*
        Node root = Node.create(null, 1, null, null);
        Node.buildFromTop(root, true, 2, 4, 5);
        Node.buildFromTop(root, false, 3, 6, 7);

        Node.buildFromTop(root.left.left, true, 8);
        Node.buildFromTop(root.left.left, false, 9);
        Node.buildFromTop(root.left.right, true, 10);
        Node.buildFromTop(root.left.right, false, 11);

        Node.buildFromTop(root.right.left, true, 12);
        Node.buildFromTop(root.right.left, false, 13);
        Node.buildFromTop(root.right.right, true, 14);
        Node.buildFromTop(root.right.right, false, 15);

        Node ancestor = findAncestor(root.left.left.left, root.right.right.left);
*/

        Node root = Node.create(null, 1, null, null);

        Node node8 = Node.buildFromBottom(8, 20, 21);
        Node node9 = Node.buildFromBottom(9, 22, 23);
        Node node10 = Node.buildFromBottom(10, 24, 25);
        Node node11 = Node.buildFromBottom(11, 26, 27);
        Node node12 = Node.buildFromBottom(12, 28, 29);
        Node node13 = Node.buildFromBottom(13, 30, 31);
        Node node14 = Node.buildFromBottom(14, 32, 33);
        Node node15 = Node.buildFromBottom(15, 34, 35);

        Node node2 = Node.buildFromBottom(2, 4, 5);
        Node node3 = Node.buildFromBottom(3, 6, 7);

        Node.bind(root, node2, node3);
        Node.bind(root.left.left, node8, node9);
        Node.bind(root.left.right, node10, node11);
        Node.bind(root.right.left, node12, node13);
        Node.bind(root.right.right, node14, node15);

        Node ancestor = findAncestor(root.left.right.left.left, root.left.right.right.right);
        ancestor = findAncestor(root.left.left.left.left, root.left.right.right.right);


        System.out.println();
    }

    private static Node findAncestor(Node a, Node b) {
        Node ancestor = null;

        if (a == null || b == null) return null;

        if (a == b) return a;
        if (a == b.parent) return a;
        if (a.parent == b) return b;
        if (a.parent == b.parent) return a.parent;

        return findAncestor(a.parent, b.parent);
    }
}
