package com.wjzyx;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args){
        Graph myGraph=new Graph();


        /**************        test BFS         ***************/
//        Vertex vertexR=new Vertex("vertex r");
//        Vertex vertexS=new Vertex("vertex s");
//        Vertex vertexT=new Vertex("vertex t");
//        Vertex vertexU=new Vertex("vertex u");
//        Vertex vertexV=new Vertex("vertex v");
//        Vertex vertexW=new Vertex("vertex w");
//        Vertex vertexX=new Vertex("vertex x");
//        Vertex vertexY=new Vertex("vertex y");
//        myGraph.allVertex.add(vertexR);
//        myGraph.allVertex.add(vertexS);
//        myGraph.allVertex.add(vertexT);
//        myGraph.allVertex.add(vertexU);
//        myGraph.allVertex.add(vertexV);
//        myGraph.allVertex.add(vertexW);
//        myGraph.allVertex.add(vertexX);
//        myGraph.allVertex.add(vertexY);
//        vertexR.allEdges.add(new Edge(1.0,vertexS));
//        vertexR.allEdges.add(new Edge(1.0,vertexV));
//        vertexS.allEdges.add(new Edge(1.0,vertexR));
//        vertexS.allEdges.add(new Edge(1.0,vertexW));
//        vertexT.allEdges.add(new Edge(1.0,vertexW));
//        vertexT.allEdges.add(new Edge(1.0,vertexX));
//        vertexT.allEdges.add(new Edge(1.0,vertexU));
//        vertexU.allEdges.add(new Edge(1.0,vertexT));
//        vertexU.allEdges.add(new Edge(1.0,vertexX));
//        vertexU.allEdges.add(new Edge(1.0,vertexY));
//        vertexV.allEdges.add(new Edge(1.0,vertexR));
//        vertexW.allEdges.add(new Edge(1.0,vertexS));
//        vertexW.allEdges.add(new Edge(1.0,vertexT));
//        vertexW.allEdges.add(new Edge(1.0,vertexX));
//        vertexX.allEdges.add(new Edge(1.0,vertexW));
//        vertexX.allEdges.add(new Edge(1.0,vertexT));
//        vertexX.allEdges.add(new Edge(1.0,vertexU));
//        vertexX.allEdges.add(new Edge(1.0,vertexY));
//        vertexY.allEdges.add(new Edge(1.0,vertexU));
//        vertexY.allEdges.add(new Edge(1.0,vertexX));

//        ArrayList<Vertex> BFSResult=myGraph.BFS(vertexS);
//        for(int tmp=0;tmp!=BFSResult.size();++tmp){
//            System.out.println(BFSResult.get(tmp).name+"    "+"depth is "+BFSResult.get(tmp).depth);
//        }


        /**************        test DFS         ***************/
//        Vertex vertexU=new Vertex("vertex u");
//        Vertex vertexV=new Vertex("vertex v");
//        Vertex vertexW=new Vertex("vertex w");
//        Vertex vertexX=new Vertex("vertex x");
//        Vertex vertexY=new Vertex("vertex y");
//        Vertex vertexZ=new Vertex("vertex z");
//        myGraph.allVertex.add(vertexU);
//        myGraph.allVertex.add(vertexV);
//        myGraph.allVertex.add(vertexW);
//        myGraph.allVertex.add(vertexX);
//        myGraph.allVertex.add(vertexY);
//        myGraph.allVertex.add(vertexZ);
//        vertexU.allEdges.add(new Edge(1.0,vertexV));
//        vertexU.allEdges.add(new Edge(1.0,vertexX));
//        vertexV.allEdges.add(new Edge(1.0,vertexY));
//        vertexW.allEdges.add(new Edge(1.0,vertexY));
//        vertexW.allEdges.add(new Edge(1.0,vertexZ));
//        vertexX.allEdges.add(new Edge(1.0,vertexV));
//        vertexY.allEdges.add(new Edge(1.0,vertexX));
//        vertexZ.allEdges.add(new Edge(1.0,vertexZ));
//
//        Graph DFSGraph=myGraph.DFS();
//        for(int tmpV=0;tmpV!=DFSGraph.allVertex.size();++tmpV){
//            System.out.print(DFSGraph.allVertex.get(tmpV).discoverdTimestamp+"  ");
//            System.out.print(DFSGraph.allVertex.get(tmpV).finishedTimestamp+"\n");
//        }


        /**************        test transposition and descendVertexByFinishedTimestamp function        ***************/
//        Vertex vertexU=new Vertex("vertex u");
//        Vertex vertexV=new Vertex("vertex v");
//        Vertex vertexW=new Vertex("vertex w");
//        Vertex vertexX=new Vertex("vertex x");
//        Vertex vertexY=new Vertex("vertex y");
//        Vertex vertexZ=new Vertex("vertex z");
//        myGraph.allVertex.add(vertexU);
//        myGraph.allVertex.add(vertexV);
//        myGraph.allVertex.add(vertexW);
//        myGraph.allVertex.add(vertexX);
//        myGraph.allVertex.add(vertexY);
//        myGraph.allVertex.add(vertexZ);
//        vertexU.allEdges.add(new Edge(1.0,vertexV));
//        vertexU.allEdges.add(new Edge(1.0,vertexX));
//        vertexV.allEdges.add(new Edge(1.0,vertexY));
//        vertexW.allEdges.add(new Edge(1.0,vertexY));
//        vertexW.allEdges.add(new Edge(1.0,vertexZ));
//        vertexX.allEdges.add(new Edge(1.0,vertexV));
//        vertexY.allEdges.add(new Edge(1.0,vertexX));
//        vertexZ.allEdges.add(new Edge(1.0,vertexZ));
//        myGraph.descendVertexByFinishedTimestamp(0,myGraph.allVertex.size()-1);
//        myGraph.print();
//        myGraph.transposition();
//        myGraph.print();

        /**************        test StronglyConnectedComponents        ***************/
//        Vertex vertexU=new Vertex("vertex u");
//        Vertex vertexV=new Vertex("vertex v");
//        Vertex vertexW=new Vertex("vertex w");
//        Vertex vertexX=new Vertex("vertex x");
//        Vertex vertexY=new Vertex("vertex y");
//        Vertex vertexZ=new Vertex("vertex z");
//        myGraph.allVertex.add(vertexU);
//        myGraph.allVertex.add(vertexV);
//        myGraph.allVertex.add(vertexW);
//        myGraph.allVertex.add(vertexX);
//        myGraph.allVertex.add(vertexY);
//        myGraph.allVertex.add(vertexZ);
//        vertexU.allEdges.add(new Edge(1.0,vertexV));
//        vertexU.allEdges.add(new Edge(1.0,vertexX));
//        vertexV.allEdges.add(new Edge(1.0,vertexY));
//        vertexW.allEdges.add(new Edge(1.0,vertexY));
//        vertexW.allEdges.add(new Edge(1.0,vertexZ));
//        vertexX.allEdges.add(new Edge(1.0,vertexV));
//        vertexY.allEdges.add(new Edge(1.0,vertexX));
//        vertexZ.allEdges.add(new Edge(1.0,vertexZ));
//        myGraph.StronglyConnectedComponents().print();

//        Vertex vertexA=new Vertex("vertex a");
//        Vertex vertexB=new Vertex("vertex b");
//        Vertex vertexC=new Vertex("vertex c");
//        Vertex vertexD=new Vertex("vertex d");
//        Vertex vertexE=new Vertex("vertex e");
//        Vertex vertexF=new Vertex("vertex f");
//        Vertex vertexG=new Vertex("vertex g");
//        Vertex vertexH=new Vertex("vertex h");
//        myGraph.allVertex.add(vertexA);
//        myGraph.allVertex.add(vertexB);
//        myGraph.allVertex.add(vertexC);
//        myGraph.allVertex.add(vertexD);
//        myGraph.allVertex.add(vertexE);
//        myGraph.allVertex.add(vertexF);
//        myGraph.allVertex.add(vertexG);
//        myGraph.allVertex.add(vertexH);
//        vertexA.allEdges.add(new Edge(1.0,vertexB));
//        vertexB.allEdges.add(new Edge(1.0,vertexC));
//        vertexB.allEdges.add(new Edge(1.0,vertexE));
//        vertexB.allEdges.add(new Edge(1.0,vertexF));
//        vertexC.allEdges.add(new Edge(1.0,vertexD));
//        vertexC.allEdges.add(new Edge(1.0,vertexG));
//        vertexD.allEdges.add(new Edge(1.0,vertexC));
//        vertexD.allEdges.add(new Edge(1.0,vertexH));
//        vertexE.allEdges.add(new Edge(1.0,vertexA));
//        vertexE.allEdges.add(new Edge(1.0,vertexF));
//        vertexF.allEdges.add(new Edge(1.0,vertexG));
//        vertexG.allEdges.add(new Edge(1.0,vertexF));
//        vertexG.allEdges.add(new Edge(1.0,vertexH));
//        vertexH.allEdges.add(new Edge(1.0,vertexH));
//        myGraph.StronglyConnectedComponents().print();

    }
}
