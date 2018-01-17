package com.wjzyx;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args){
        testMSTPrim();
    }

    public static void testMSTKruskal() {
        UGraph graph = new UGraph();

        Vertex vertexA = new Vertex("Vertex A");
        Vertex vertexB = new Vertex("Vertex B");
        Vertex vertexC = new Vertex("Vertex C");
        Vertex vertexD = new Vertex("Vertex D");
        Vertex vertexE = new Vertex("Vertex E");
        Vertex vertexF = new Vertex("Vertex F");
        Vertex vertexG = new Vertex("Vertex G");
        Vertex vertexH = new Vertex("Vertex H");
        Vertex vertexI = new Vertex("Vertex I");

        graph.addVertex(vertexA);
        graph.addVertex(vertexB);
        graph.addVertex(vertexC);
        graph.addVertex(vertexD);
        graph.addVertex(vertexE);
        graph.addVertex(vertexF);
        graph.addVertex(vertexG);
        graph.addVertex(vertexH);
        graph.addVertex(vertexI);

        vertexA.addEdge(4.0,vertexB);
        vertexA.addEdge(8.0,vertexH);
        vertexB.addEdge(11.0,vertexH);
        vertexB.addEdge(8.0,vertexC);
        vertexC.addEdge(2.0,vertexI);
        vertexI.addEdge(9.0,vertexH);
        vertexH.addEdge(1.0,vertexG);
        vertexI.addEdge(6.0,vertexG);
        vertexC.addEdge(7.0,vertexD);
        vertexC.addEdge(4.0,vertexF);
        vertexG.addEdge(2.0,vertexF);
        vertexD.addEdge(14.0,vertexF);
        vertexD.addEdge(9.0,vertexE);
        vertexF.addEdge(10.0,vertexE);

        ArrayList<Edge> result = graph.MSTKruskal();
        for(int tmpE=0;tmpE!=result.size();++tmpE){
            Edge tmpEdge=result.get(tmpE);
            System.out.println(tmpEdge.endpoint1.name+"  "
                    +tmpEdge.endpoint2.name+"  "+tmpEdge.value);
        }
    }

    public static void testMSTPrim() {
        UGraph graph = new UGraph();

        Vertex vertexA = new Vertex("Vertex A");
        Vertex vertexB = new Vertex("Vertex B");
        Vertex vertexC = new Vertex("Vertex C");
        Vertex vertexD = new Vertex("Vertex D");
        Vertex vertexE = new Vertex("Vertex E");
        Vertex vertexF = new Vertex("Vertex F");
        Vertex vertexG = new Vertex("Vertex G");
        Vertex vertexH = new Vertex("Vertex H");
        Vertex vertexI = new Vertex("Vertex I");

        graph.addVertex(vertexA);
        graph.addVertex(vertexB);
        graph.addVertex(vertexC);
        graph.addVertex(vertexD);
        graph.addVertex(vertexE);
        graph.addVertex(vertexF);
        graph.addVertex(vertexG);
        graph.addVertex(vertexH);
        graph.addVertex(vertexI);

        vertexA.addEdge(4.0,vertexB);
        vertexA.addEdge(8.0,vertexH);
        vertexB.addEdge(11.0,vertexH);
        vertexB.addEdge(8.0,vertexC);
        vertexC.addEdge(2.0,vertexI);
        vertexI.addEdge(9.0,vertexH);
        vertexH.addEdge(1.0,vertexG);
        vertexI.addEdge(6.0,vertexG);
        vertexC.addEdge(7.0,vertexD);
        vertexC.addEdge(4.0,vertexF);
        vertexG.addEdge(2.0,vertexF);
        vertexD.addEdge(14.0,vertexF);
        vertexD.addEdge(9.0,vertexE);
        vertexF.addEdge(10.0,vertexE);

        ArrayList<Edge> result = graph.MSTPrim(vertexA);
        for(int tmpE=0;tmpE!=result.size();++tmpE){
            Edge tmpEdge=result.get(tmpE);
            System.out.println(tmpEdge.endpoint1.name+"  "
                    +tmpEdge.endpoint2.name+"  "+tmpEdge.value);
        }
    }
}
