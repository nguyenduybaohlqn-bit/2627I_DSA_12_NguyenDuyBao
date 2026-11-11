import java.util.ArrayList;
import java.util.List;

public class w9_25021650 {

    public static final int NIL = -1;

    public static class Node {
        char data;
        int firstChild;
        int nextSibling;

        public Node(char data, int firstChild, int nextSibling) {
            this.data = data;
            this.firstChild = firstChild;
            this.nextSibling = nextSibling;
        }
    }

    public static class Tree {
        List<Node> nodes;
        int root;

        public Tree(int root) {
            this.nodes = new ArrayList<>();
            this.root = root;
        }
    }

    public static int getFirstChild(Tree tree, int u) {
        if (u < 0 || u >= tree.nodes.size()) {
            return NIL;
        }
        return tree.nodes.get(u).firstChild;
    }

    public static int getNextSibling(Tree tree, int u) {
        if (u < 0 || u >= tree.nodes.size()) {
            return NIL;
        }
        return tree.nodes.get(u).nextSibling;
    }


    public static int getParent(Tree tree, int u) {
        if (u < 0 || u >= tree.nodes.size() || u == tree.root) {
            return NIL;
        }

        for (int p = 0; p < tree.nodes.size(); p++) {
            int child = tree.nodes.get(p).firstChild;
            while (child != NIL) {
                if (child == u) {
                    return p;
                }
                child = tree.nodes.get(child).nextSibling;
            }
        }
        return NIL;
    }

    public static void main(String[] args) {
        Tree tree = new Tree(0);

        tree.nodes.add(new Node('A', 1, NIL));
        tree.nodes.add(new Node('B', 4, 2));
        tree.nodes.add(new Node('C', NIL, 3));
        tree.nodes.add(new Node('D', NIL, NIL));
        tree.nodes.add(new Node('E', NIL, 5));
        tree.nodes.add(new Node('F', NIL, NIL));

        int nodeB = 1;
        int childOfB = getFirstChild(tree, nodeB);
        if (childOfB != NIL) {
            System.out.println("Con truong của B: " + tree.nodes.get(childOfB).data);
        }

        int siblingOfB = getNextSibling(tree, nodeB);
        if (siblingOfB != NIL) {
            System.out.println("Em lien ke của B: " + tree.nodes.get(siblingOfB).data);
        }

        int nodeF = 5;
        int parentOfF = getParent(tree, nodeF);
        if (parentOfF != NIL) {
            System.out.println("Bo của F: " + tree.nodes.get(parentOfF).data);
        }
    }
}