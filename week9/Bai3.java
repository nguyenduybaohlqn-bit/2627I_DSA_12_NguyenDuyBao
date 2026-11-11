
public class BSTInsertion {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static class BST {
        Node root;

        public Node insert(Node root, int x) {
            if (root == null) {
                return new Node(x);
            }

            if (x < root.data) {
                root.left = insert(root.left, x);
            } else if (x > root.data) {
                root.right = insert(root.right, x);
            }

            return root;
        }

        public void insertIterative(int x) {
            Node newNode = new Node(x);

            if (root == null) {
                root = newNode;
                return;
            }

            Node current = root;
            Node parent = null;

            while (current != null) {
                parent = current;

                if (x < current.data) {
                    current = current.left;
                } else if (x > current.data) {
                    current = current.right;
                } else {
                    return;
                }
            }

            if (x < parent.data) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
        }

        public void inorder(Node root) {
            if (root == null) return;

            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();

        int[] values = {50, 30, 70, 20, 40, 60, 80};

        for (int x : values) {
            tree.root = tree.insert(tree.root, x);
        }

        System.out.print("BST sau khi insert de quy: ");
        tree.inorder(tree.root);

        // Insert using iteration
        tree.insertIterative(35);

        System.out.print("\nBST sau khi insert tuan tu: ");
        tree.inorder(tree.root);
    }
}
