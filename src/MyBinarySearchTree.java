public class MyBinarySearchTree<Type extends Comparable<Type>> {

    class Node {
        public Type data;
        public Node left;
        public Node right;
        public int height;

        public Node(Type data) {
            this.data = data;
        }
        @Override
        public String toString() {
            return data.toString() + ":H" + height;
        }
    }

    private Node root;
    private int size;
    public long comparisons;

    public MyBinarySearchTree(boolean b) {
        boolean b1 = b;
        root = null;
        size = 0;
        comparisons = 0;
    }

    public void add(Type data) {
        root = add(root, data);
    }
    private Node add(Node root, Type data) {
        if (root == null) {
            root = new Node(data);
            size++;
        } else if (data.compareTo(root.data) < 0) {
            root.left = add(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = add(root.right, data);
        }
        updateHeight(root);
        return root;
    }

    public void remove(Type data) {
        root = remove(root, data);
    }
    private Node remove(Node root, Type data) {
        if (root == null) {
            return null;
        }
        if (data.compareTo(root.data) < 0) {
            root.left = remove(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = remove(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = findMin(root.right).data;
            root.right = remove(root.right, root.data);
        }
        updateHeight(root);
        return root;
    }

    private Node findMin(Node right) {
        if (right == null) {
            return null;
        }
        if (right.left == null) {
            return right;
        }
        return findMin(right.left);
    }
    private void updateHeight(Node root) {
        if (root == null) {
            return;
        }
        int leftHeight = root.left == null ? -1 : root.left.height;
        int rightHeight = root.right == null ? -1 : root.right.height;
        root.height = 1 + Math.max(leftHeight, rightHeight);
    }

    public Type find(Type data) {
        return find(root, data);
    }

    private Type find(Node root, Type data) {
        comparisons++;
        if (root == null) {
            return null;
        }
        if (data.compareTo(root.data) < 0) {
            return find(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            return find(root.right, data);
        } else {
            return root.data;
        }
    }

    public int getSize() {
        return size;
    }

    public int height() {
        return Height(root);
    }

    private int Height(Node root) {
        if (root == null) {
            return -1;
        }
        return root.height;
    }

    public boolean isEmpty() {
        return root == null;
    }
    @Override
    public String toString() {
        return toString(root);
    }

    private String toString(Node root) {
        if (root == null) {
            return "";
        }
        return toString(root.left) + root.toString() + toString(root.right);
    }
}
