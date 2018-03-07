package expcalc.node;

import java.util.List;

public class NodeTest {
    static class Tnode extends Node {
        public int i;

        public Tnode(int i) {
            super();
            this.i = i;
        }
    }

    public static void main(String[] args) {
        Tnode root = new Tnode(0);
        root.addChileFirst(new Tnode(1));
        Tnode tn = (Tnode) root.getChildFirst();
        System.out.println(tn.getParent());
        tn.insertAfter(new Tnode(3));
        tn.insertAfter(new Tnode(2));
        tn.insertBefore(new Tnode(4));
        tn.addChildLast(new Tnode(5));
        tn.addChildLast(new Tnode(6));
        tn.addChileFirst(new Tnode(7));
        tn.getChildLast().remove();

        tn.getNext().remove();
        printNode(root, 1);
    }

    static void printNode(Node node, int lv) {
        for (int j = 0; j < lv; j++) {
            System.out.print(">>");
        }
        System.out.println(((Tnode) node).i);
        List<Node> list = node.getChildInList();
        for (Node n : list) {
            printNode(n, lv + 1);
        }
    }
}
