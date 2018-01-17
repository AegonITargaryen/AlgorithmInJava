package com.wjzyx;

public class Edge {
    public Vertex endpoint1;
    public Vertex endpoint2;
    public Double value;

    public Edge(Vertex endpoint1,Vertex endpoint2,Double value){
        this.endpoint1=endpoint1;
        this.endpoint2=endpoint2;
        this.value=value;
    }
}
