package Recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class recursion_5639 {
    static Tree root;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        root = new Tree(Integer.parseInt(br.readLine()));
        String str;
        while (true) {
            str = br.readLine();
            if (str == null || str.length() == 0) break;
            Tree n = new Tree(Integer.parseInt(str));
            addTree(root, n);
        }
        postOrder(root);
        System.out.println(sb);
    }

    static void addTree(Tree start, Tree input) {
        if (start.node > input.node) {
            if (start.left != null)
                addTree(start.left, input);
            else
                start.left = input;
        }
        if (start.node < input.node) {
            if (start.right != null)
                addTree(start.right, input);
            else
                start.right = input;
        }
    }

    static void postOrder(Tree tree) {
        if (tree.left != null)
            postOrder(tree.left);
        if (tree.right != null)
            postOrder(tree.right);
        sb.append(tree.node).append("\n");
    }
}

class Tree {
    int node;
    Tree left;
    Tree right;

    public Tree(int data) {
        this.node = data;
    }
}
