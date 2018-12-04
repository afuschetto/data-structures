package com.afuschetto.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * A graph is a non-linear data structure consisting of vertices and edges. The
 * vertices are sometimes also referred to as nodes and the edges are lines or
 * arcs that connect any two vertices in the graph.
 */
public class Graph {
    private Orientation orientation;
    private Vertex[] vertices;
    private int size;

    public Graph(Orientation orientation, int capacity) {
        this.orientation = orientation;
        vertices = new Vertex[capacity];
        size = 0;
    }

    public void addVertex(String name) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Full graph");
        }

        Vertex newVertex = new Vertex(name);
        vertices[size++] = newVertex;
    }

    public void addEdge(String fromVertexName, String toVertexName) {
        int fromVertexIdx = getVertexIdx(fromVertexName);
        if (fromVertexIdx == -1) {
            throw new IllegalArgumentException("Unknown vertex: " + fromVertexName);
        }

        int toVertexIdx = getVertexIdx(toVertexName);
        if (toVertexIdx == -1) {
            throw new IllegalArgumentException("Unknown vertex: " + toVertexName);
        }

        vertices[fromVertexIdx].adjacentIds.add(toVertexIdx);
        if (orientation == Orientation.UNDIRECTED) {
            vertices[toVertexIdx].adjacentIds.add(fromVertexIdx);
        }
    }

    private int getVertexIdx(String name) {
        for (int i = 0; i < size; i++) {
            if (vertices[i].name.equals(name)) {
                return i;
            }
        }

        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == vertices.length;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(vertices[i]);
        }
    }

    public enum Orientation {DIRECTED, UNDIRECTED}

    private class Vertex {
        String name;
        List<Integer> adjacentIds;

        public Vertex(String name) {
            this.name = name;
            adjacentIds = new ArrayList<>();
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(name + ": [");
            sb.append(adjacentIds.stream().map(x -> vertices[x].name).collect(Collectors.joining(", ")));
            sb.append("]");

            return sb.toString();
        }
    }
}
