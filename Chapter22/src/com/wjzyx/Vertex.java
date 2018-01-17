package com.wjzyx;

import java.util.ArrayList;

public class Vertex {
    public String name;
    public ArrayList<Edge> allEdges;
    public Color color;
    public int depth;       //the depth from the root vertex to this vertex  //It is used in BFS.

    public int discoverdTimestamp;   //the time when the vertex is found    //It is used in DFS
    public int finishedTimestamp;    //the time when the vertex's allEdges has been searched
                                       // It is used in DFS



    public Vertex(String name){
        this.name=name;
        this.allEdges=new ArrayList<Edge>();
        color=Color.White;
        depth=Integer.MAX_VALUE;
        discoverdTimestamp=0;
        finishedTimestamp=0;
    }

    public Vertex(String name, ArrayList<Edge> allEdges)
    {
        this.name=name;
        this.allEdges=allEdges;
        color=Color.White;
        depth=Integer.MAX_VALUE;
        discoverdTimestamp=0;
        finishedTimestamp=0;
    }
}
