package Recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class recursion_1991 {
    static Tree2 root = new Tree2("A");
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            Tree2 parent = new Tree2(str);
//            if (str.equals("A"))
//                parent = root;
            for (int j = 0; j < 2; j++) {
                String str2 = st.nextToken();
                Tree2 child = new Tree2(str2);
                if (!str2.equals(".")) {
                    if (j == 0)
                        addTree(root, parent, child, j);
                    else
                        addTree(root, parent, child, j);
                }
            }
        }
        preOrder(root);
        sb.append("\n");
        inOrder(root);
        sb.append("\n");
        postOrder(root);
        System.out.println(sb);
    }

    static void addTree(Tree2 find, Tree2 parent, Tree2 child, int j) {
        if (find != parent && find.left != null)
            addTree(find.left, parent, child, j);
        if (find != parent && find.right != null)
            addTree(find.right, parent, child, j);

        if (find.node.equals(parent.node)) {
            if (j == 0)
                find.left = child;
            else
                find.right = child;
        }
    }

    static void preOrder(Tree2 tree) {
        sb.append(tree.node);
        if (tree.left != null)
            preOrder(tree.left);
        if (tree.right != null)
            preOrder(tree.right);
    }

    static void inOrder(Tree2 tree) {
        if (tree.left != null)
            inOrder(tree.left);
        sb.append(tree.node);
        if (tree.right != null)
            inOrder(tree.right);
    }

    static void postOrder(Tree2 tree) {
        if (tree.left != null)
            postOrder(tree.left);
        if (tree.right != null)
            postOrder(tree.right);
        sb.append(tree.node);
    }
}

class Tree2 {
    String node;
    Tree2 left;
    Tree2 right;

    public Tree2(String data) {
        this.node = data;
    }
}
