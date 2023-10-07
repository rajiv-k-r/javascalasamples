package dsa.rkr.graphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeLevelWise {

    /**
     * Print tree levelwise
     * @param root
     */
    public static void printTreeLevelWise(Node root) {
        Node dummy = new Node("DUMMY");
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        queue.offer(dummy);
        while(queue.size() != 1 || queue.peek() != dummy) {
            Node node = queue.poll();
            if(node != dummy) {
                System.out.print(node.name + "\t");
                queue.addAll(node.childList);
            }
            else {
                System.out.println();
                queue.offer(dummy);
            }
        }
        System.out.println();
    }

}
