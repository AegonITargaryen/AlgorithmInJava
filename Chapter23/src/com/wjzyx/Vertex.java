package com.wjzyx;

import java.util.ArrayList;

//Undirected graph's vertex
public class Vertex extends DisjointNode {
    public String name;
    public ArrayList<Edge> allEdges;

    public Vertex(String name){
        super();
        this.name=name;
        this.allEdges=new ArrayList<Edge>();
    }

    public void addEdge(Double value,Vertex anotherNode){
        Edge newEdge=new Edge(this,anotherNode,value);
        this.allEdges.add(newEdge);
        anotherNode.allEdges.add(newEdge);
    }



}
