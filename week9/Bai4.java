
public class BSTLowestCommonAncestor {

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

        public Node lowestCommonAncestor(Node root, int p, int q) {
            if (root == null) {
                return null;
            }

            if (p < root.data && q < root.data) {
                return lowestCommonAncestor(root.left, p, q);
            }

            if (p > root.data && q > root.data) {
                return lowestCommonAncestor(root.right, p, q);
            }

            return root;
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();

        int[] values = {50, 30, 70, 20, 40, 60, 80};

        for (int x : values) {
            tree.root = tree.insert(tree.root, x);
        }

        int p = 20;
        int q = 40;

        Node result = tree.lowestCommonAncestor(tree.root, p, q);

        if (result != null) {
            System.out.println(result.data);
        } else {
            System.out.println("LCA not found");
        }
    }
}
