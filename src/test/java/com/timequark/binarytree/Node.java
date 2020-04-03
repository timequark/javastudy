package com.timequark.binarytree;

public class Node {
    Node parent;
    int v;
    Node left;
    Node right;

    private Node(Node parent, int v, Node left, Node right) {
        this.parent = parent;
        this.v = v;
        this.left = left;
        this.right = right;
    }

    public static Node create(Node parent, int v, Node left, Node right) {
        return new Node(parent, v, left, right);
    }

    public static Node buildFromTop(Node parent, boolean isLeft, int v, int... children) {
        Node self = Node.create(parent, v, null, null);
        Node left = (children != null && children.length >=1) ? Node.create(self, children[0], null, null) : null;
        Node right = (children != null && children.length == 2) ? Node.create(self, children[1], null, null) : null;
        self.left = left;
        self.right = right;

        if (isLeft) {
            parent.left = self;
        } else {
            parent.right = self;
        }

        return self;
    }

    public static Node buildFromBottom(int v, int... children) {
        Node self = Node.create(null, v, null, null);
        Node left = (children != null && children.length >=1) ? Node.create(self, children[0], null, null) : null;
        Node right = (children != null && children.length == 2) ? Node.create(self, children[1], null, null) : null;
        self.left = left;
        self.right = right;

        return self;
    }

    public static void bind(Node parent, Node left, Node right) {
        parent.left = left;
        parent.right = right;
        if (left != null) left.parent = parent;
        if (right != null) right.parent = parent;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
