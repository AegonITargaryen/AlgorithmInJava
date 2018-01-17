package com.wjzyx;

public class Edge {
    public double weight;       //the weight of this edge
    public Vertex terminus;     //the terminus of this edge

    public Edge(double weight, Vertex terminus){
        this.weight=weight;
        this.terminus=terminus;
    }
}
