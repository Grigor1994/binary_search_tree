package com.grigor.picsart;

public class BinarySearchTree {
    private Node head;

    public void add(Integer value) {
        head = addRecursion(head, value);
    }

    private Node addRecursion(Node current, Integer value) {
        if (current == null) {
            return new Node(value);
        }
        if (value > current.value) {
            current.right = addRecursion(current.right, value);
        } else {
            current.left = addRecursion(current.left, value);
        }
        return current;
    }

    public boolean contains(Integer i) {
        return find(head, i) != null;
    }

    private Node find(Node head, Integer val) {
        if (head == null) {
            return null;
        }
        if (head.value.equals(val)) {
            return head;
        }
        if (head.value > val) {
            return find(head.left, val);
        } else {
            return find(head.right, val);
        }
    }

    public void delete(int value) {
        head = deleteRecursive(head, value);
    }

    private Node deleteRecursive(Node current, Integer value) {
        if (current == null) {
            return null;
        }
        if (value.equals(current.value)) {

            // haven't children
            if (current.left == null && current.right == null) {
                return null;
            }

            // have only 1 children
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            // 2 children
            int smallestValue = min(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }

        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private Integer min(Node root) {
        return root.left == null ? root.value : min(root.left);
    }
}
