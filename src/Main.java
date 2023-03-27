

public class Main {
    /*
    * Напишите алгоритм создания бинарного дерева поиска с минимальной высотой
    * для отсортированного по возрастанию массива с уникальными целочисленными элементами
    * */

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 7, 9, 23, 28, 42, 66, 78};

        Node tree = createNode(arr, 0, arr.length - 1);
        printTree(tree);
    }

    public static void printTree(Node node) {
        if (node != null) {
            printTree(node.left);
            System.out.println(node.value);
            printTree(node.right);
        }
    }

    public static Node createNode(int[] arr, int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);
        node.left = createNode(arr, start, mid - 1);
        node.right = createNode(arr, mid + 1, end);
        return node;
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}