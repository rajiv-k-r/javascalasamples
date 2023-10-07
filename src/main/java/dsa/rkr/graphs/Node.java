package dsa.rkr.graphs;

import java.util.ArrayList;
import java.util.List;

public class Node {
    String name;
    List<Node> adjList = new ArrayList<>();
    COLOR color = COLOR.WHITE;
    int dist = Integer.MAX_VALUE;
    Node parent;
    Node(String name) {
        this.name = name;
    }

    List<Node> childList = new ArrayList<>();
    void addChild(Node child) {
        childList.add(child);
    }
}

enum COLOR {
    WHITE,
    GRAY,
    BLACK
}