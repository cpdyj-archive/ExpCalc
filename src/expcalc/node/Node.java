package expcalc.node;

import java.util.LinkedList;
import java.util.List;

public class Node {
    private Node prev, next, childFirst, childLast, parent;
    private int size;

    public void addChileFirst(Node node) {
        assert checkAvailableAssert();
        if (size == 0) {
            size = 1;
            childFirst = node;
            childLast = node;
            node.parent = this;
        } else {
            childFirst.insertBefore(node);
        }
    }

    public void addChildLast(Node node) {
        assert checkAvailableAssert();
        if (size == 0) {
            size = 1;
            childFirst = node;
            childLast = node;
            node.parent = this;
        } else {
            childLast.insertAfter(node);
        }
    }

    public void remove() {
        if (prev != null) {
            prev.next = next;
        }
        if (next != null) {
            next.prev = prev;
        }
        if (parent != null) {
            parent.size--;
            if (parent.childFirst == this) {
                parent.childFirst = next;
            }
            if (parent.childLast == this) {
                parent.childLast = prev;
            }
        }
        assert prev == null || prev.checkAvailableAssert();
        assert next == null || next.checkAvailableAssert();
        assert parent == null || parent.checkAvailableAssert();
        next = null;
        prev = null;
        parent = null;
        assert checkAvailableAssert();
    }

    public void insertBefore(Node node) {
        assert checkAvailableAssert();
        node.remove();
        if (prev != null) {
            prev.next = node;
        }
        node.prev = prev;
        node.next = this;
        prev = node;
        node.parent = parent;
        if (parent != null) {
            if (parent.childFirst == this) {
                parent.childFirst = node;
            }
            parent.size++;
            assert parent.checkAvailableAssert();
        }
        assert checkAvailableAssert();
        assert prev.checkAvailableAssert();
    }

    public void insertAfter(Node node) {
        assert checkAvailableAssert();
        node.remove();
        if (next != null) {
            next.prev = node;
        }
        node.next = next;
        node.prev = this;
        next = node;
        node.parent = parent;
        if (parent != null) {
            if (parent.childLast == this) {
                parent.childLast = node;
            }
            parent.size++;
            assert parent.checkAvailableAssert();
        }
        assert checkAvailableAssert();
        assert next.checkAvailableAssert();
    }

    public List<Node> getChildInList() {
        assert checkAvailableAssert();
        List<Node> list = new LinkedList<>();
        Node p = childFirst;
        while (p != null) {
            list.add(p);
            p = p.next;
        }
        return list;
    }

    private boolean checkAvailableAssert() {
        assert next == null || next.prev == this : "next.prev not excepted.";
        assert prev == null || prev.next == this : "prev.next not excepted.";
        assert size != 0 || childFirst == null & childLast == null : "child pointer not excepted when size=0.";
        assert size != 1 || childFirst == childLast & childFirst != null : "child pointer not excepted when size=1.";
        /* wrong rule. */ //assert size != 1 || childFirst.parent == this : "chile.parent not excepted.";
        assert size < 2 || childFirst != childLast : "child pointer not excepted when size>1.";
        assert childFirst == null || childFirst.parent == this : "childFirst.parent not excepted.";
        assert childLast == null || childLast.parent == this : "childLast.parent not excepted.";
        return true;
    }

    public Node getPrev() {
        return prev;
    }

    public Node getNext() {
        return next;
    }

    public Node getChildFirst() {
        return childFirst;
    }

    public Node getChildLast() {
        return childLast;
    }

    public Node getParent() {
        return parent;
    }

    public int getSize() {
        return size;
    }

}
