package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Graph_5639 {
    static class Tree {
        int node;
        Tree left, right;

        public Tree(int node) {
            this.node = node;
        }
    }

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Tree root = new Tree(Integer.parseInt(br.readLine()));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            Tree tree = new Tree(Integer.parseInt(line));
            makeTree(root, tree);
        }

        sb = new StringBuilder();
        postOrder(root);
        System.out.println(sb);
    }

    static void makeTree(Tree root, Tree input) {
        if (root.node > input.node) {
            if (root.left == null) {
                root.left = input;
            } else {
                makeTree(root.left, input);
            }
        }
        if (root.node < input.node) {
            if (root.right == null) {
                root.right = input;
            } else {
                makeTree(root.right, input);
            }
        }
    }

    static void postOrder(Tree tree) {
        if (tree.left != null) {
            postOrder(tree.left);
        }
        if (tree.right != null) {
            postOrder(tree.right);
        }
        sb.append(tree.node).append("\n");
    }
}
