package dsa.rkr.graphs;

import java.util.*;

/**
 * Breadth first search of a graph
 */
public class BFSImpl {

    public static void main(String[] args) {
        List<Node> graph = GraphUtils.createSampleGraph();
        Node start = graph.get(0);
        bfs(graph, start);
        TreeLevelWise.printTreeLevelWise(start);

        Node end = graph.get(7);
        System.out.println("Find shortest path from " + start.name + " to " + end.name);
        printPath(graph, start, end);
    }

    public static void bfs(List<Node> graph, Node start) {
        start.color = COLOR.GRAY;
        start.dist = 0;

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(start);

        while(!queue.isEmpty()) {
            Node u = queue.poll();
            for(Node v : u.adjList) {
                if(v.color == COLOR.WHITE) {
                    v.color = COLOR.GRAY;
                    v.dist = u.dist + 1;
                    v.parent = u;
                    queue.offer(v);

                    u.addChild(v); // added to get a tree hierarchy
                }
            }
            u.color = COLOR.BLACK;
        }
    }

    public static void printPath(List<Node> graph, Node start, Node end) {
        if(start == end) {
            System.out.println(start.name + "\t");
        }
        else if (end.parent == null) {
            System.out.println("NO path exists from " + start.name + " to " + end.name);
        }
        else {
            printPath(graph, start, end.parent);
            System.out.println(end.name + "\t");
        }
    }

}

