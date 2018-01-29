package com.wjzyx;

import java.util.ArrayList;

//Directed graph vertex
public class Vertex {
    public String name;
    public ArrayList<Edge> allEdges;
    public Double shortestPathLength;
    public Vertex preVertex;

    public Color color;
    public int discoverdTimestamp;   //the time when the vertex is found    //It is used in DFS
    public int finishedTimestamp;    //the time when the vertex's allEdges has been searched
    // It is used in DFS


    public Vertex(String name){
        this.name=name;
        this.allEdges=new ArrayList<Edge>();
        this.shortestPathLength=Double.MAX_VALUE;
        this.preVertex=null;
        this.discoverdTimestamp=0;
        this.finishedTimestamp=0;
        this.color=Color.White;
    }

    public void addEdge(Edge newEdge){
        this.allEdges.add(newEdge);
    }



}
