package dsa.rkr.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Depth first search of a graph
 */
public class DFSImpl {

    public static void main(String[] args) {
        List<Node> graph = GraphUtils.createSampleGraph2();
        dfs(graph);

        for(Node root : dff) {
            TreeLevelWise.printTreeLevelWise(root);
            System.out.println();
        }
    }

    private static List<Node> dff = new ArrayList<>();
    private static int time = 0;
    public static void dfs(List<Node> graph) {
        //GraphUtils.resetGraph(graph);
        for(Node node : graph) {
            if(node.color == COLOR.WHITE) {
                dfsVisit(graph, node);
                dff.add(node); //--- adding root of each DFT to the DFF;
            }
        }
    }
    private static void dfsVisit(List<Node> graph, Node parent) {
        time++;
        parent.tstart = time;
        parent.color = COLOR.GRAY;
        for(Node node : parent.adjList) {
            if(node.color == COLOR.WHITE) {
                node.parent = parent;
                dfsVisit(graph, node);

                parent.childList.add(node); //--- adding child node to construct DFT
            }
        }
        parent.color = COLOR.BLACK;
        time++;
        parent.tend = time;
    }

}
