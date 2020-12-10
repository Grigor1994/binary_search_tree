package com.grigor.picsart;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(15);
        tree.add(4);
        tree.add(6);
        System.out.println(tree.contains(4));
        tree.delete(4);
        System.out.println(tree.contains(4));
        tree.add(4);
        System.out.println(tree.contains(4));
        tree.add(42);
        tree.add(3);
        tree.inOrder();
    }
}
