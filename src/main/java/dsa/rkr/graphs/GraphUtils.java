package dsa.rkr.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphUtils {

    public static void resetGraph(List<Node> graph) {
        for(Node node : graph) {
            node.parent = null;
            node.color = COLOR.WHITE;
            node.dist = Integer.MAX_VALUE;
            node.childList.clear();
        }
    }

    public static List<Node> createSampleGraph() {
        Node r = new Node("R");
        Node s = new Node("S");
        Node t = new Node("T");
        Node u = new Node("U");
        Node v = new Node("V");
        Node w = new Node("W");
        Node x = new Node("X");
        Node y = new Node("Y");

        r.adjList.add(s); r.adjList.add(v);
        s.adjList.add(r); s.adjList.add(w);
        t.adjList.add(u); t.adjList.add(w); t.adjList.add(x);
        u.adjList.add(t); u.adjList.add(x); u.adjList.add(y);
        w.adjList.add(s); w.adjList.add(t); w.adjList.add(x);
        x.adjList.add(t); x.adjList.add(u); x.adjList.add(w); x.adjList.add(y);
        y.adjList.add(u); y.adjList.add(x);

        List<Node> graph = new ArrayList<>();
        //graph.addAll(Arrays.asList(r, s, t, u, v, w, x, y));
        graph.addAll(Arrays.asList(s, r, t, u, v, w, x, y));
        return graph;
    }

    public static List<Node> createSampleGraph2() {
        Node s = new Node("S");
        Node t = new Node("T");
        Node u = new Node("U");
        Node v = new Node("V");
        Node w = new Node("W");
        Node x = new Node("X");
        Node y = new Node("Y");
        Node z = new Node("Z");

        s.adjList.add(z); s.adjList.add(w);
        t.adjList.add(v); t.adjList.add(u);
        u.adjList.add(t); u.adjList.add(v);
        v.adjList.add(s); v.adjList.add(w);
        w.adjList.add(x);
        x.adjList.add(z);
        y.adjList.add(x);
        z.adjList.add(y); z.adjList.add(w);

        List<Node> graph = new ArrayList<>();
        graph.addAll(Arrays.asList(s, t, u, v, w, x, y, z));
        return graph;
    }

}
