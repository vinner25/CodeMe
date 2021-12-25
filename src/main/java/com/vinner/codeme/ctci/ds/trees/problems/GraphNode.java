package com.vinner.codeme.ctci.ds.trees.problems;

import java.util.ArrayList;
import java.util.List;

public class GraphNode<T>{

    private T value;
    private List<GraphNode<T>> adjacentVertices;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public List<GraphNode<T>> getAdjacentVertices() {
        return adjacentVertices;
    }

    public void setAdjacentVertices(List<GraphNode<T>> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }

    public void addVertix(GraphNode<T> vertix)
    {
        if(null == this.adjacentVertices)
            this.adjacentVertices = new ArrayList<>();

        this.adjacentVertices.add(vertix);
    }
}
