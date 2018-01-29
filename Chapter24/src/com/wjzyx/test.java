package com.wjzyx;

import java.util.ArrayList;

public class test {
    public static void main(String[] args){
        //testBellmanFord();
        //testDFS();
        testDAGShortestPaths();
    }

    private static void testBellmanFord(){
        Graph myGraph=new Graph();
        Vertex vertexS=new Vertex("Vertex S");
        Vertex vertexT=new Vertex("Vertex T");
        Vertex vertexX=new Vertex("Vertex X");
        Vertex vertexY=new Vertex("Vertex Y");
        Vertex vertexZ=new Vertex("Vertex Z");
        vertexS.addEdge(new Edge(vertexT,6.0));
        vertexS.addEdge(new Edge(vertexY,7.0));
        vertexT.addEdge(new Edge(vertexX,5.0));
        vertexT.addEdge(new Edge(vertexY,8.0));
        vertexT.addEdge(new Edge(vertexZ,-4.0));
        vertexX.addEdge(new Edge(vertexT,-2.0));
        vertexY.addEdge(new Edge(vertexX,-3.0));
        vertexY.addEdge(new Edge(vertexZ,9.0));
        vertexZ.addEdge(new Edge(vertexX,7.0));
        vertexZ.addEdge(new Edge(vertexS,2.0));
        myGraph.addVertex(vertexS);
        myGraph.addVertex(vertexT);
        myGraph.addVertex(vertexX);
        myGraph.addVertex(vertexY);
        myGraph.addVertex(vertexZ);

        System.out.println(myGraph.BellmanFord(vertexS));

        for(Vertex tmpVertex : myGraph.allVertexs){
            System.out.print(tmpVertex.name+" "+
                    tmpVertex.shortestPathLength+" ");
            if(tmpVertex.preVertex!=null)
                System.out.print(tmpVertex.preVertex.name);
            System.out.print("\n");
        }
    }

    private static void testDFS(){
//        Graph myGraph=new Graph();
//        Vertex vertexR=new Vertex("Vertex R");
//        Vertex vertexS=new Vertex("Vertex S");
//        Vertex vertexT=new Vertex("Vertex T");
//        Vertex vertexX=new Vertex("Vertex X");
//        Vertex vertexY=new Vertex("Vertex Y");
//        Vertex vertexZ=new Vertex("Vertex Z");
//        vertexR.addEdge(new Edge(vertexS,5.0));
//        vertexR.addEdge(new Edge(vertexT,3.0));
//        vertexS.addEdge(new Edge(vertexT,2.0));
//        vertexS.addEdge(new Edge(vertexX,6.0));
//        vertexT.addEdge(new Edge(vertexX,7.0));
//        vertexT.addEdge(new Edge(vertexY,4.0));
//        vertexT.addEdge(new Edge(vertexZ,2.0));
//        vertexX.addEdge(new Edge(vertexY,-1.0));
//        vertexX.addEdge(new Edge(vertexZ,1.0));
//        vertexY.addEdge(new Edge(vertexZ,-2.0));
//        myGraph.addVertex(vertexX);
//        myGraph.addVertex(vertexZ);
//        myGraph.addVertex(vertexS);
//        myGraph.addVertex(vertexR);
//        myGraph.addVertex(vertexY);
//        myGraph.addVertex(vertexT);

//        Graph myGraph=new Graph();
//        Vertex vertexA=new Vertex("Vertex A");
//        Vertex vertexB=new Vertex("Vertex B");
//        Vertex vertexC=new Vertex("Vertex C");
//        Vertex vertexD=new Vertex("Vertex D");
//        Vertex vertexE=new Vertex("Vertex E");
//        Vertex vertexF=new Vertex("Vertex F");
//        Vertex vertexG=new Vertex("Vertex G");
//        Vertex vertexH=new Vertex("Vertex H");
//        Vertex vertexI=new Vertex("Vertex I");
//
//        vertexA.addEdge(new Edge(vertexB,6.0));
//        vertexA.addEdge(new Edge(vertexH,7.0));
//        vertexB.addEdge(new Edge(vertexC,5.0));
//        vertexB.addEdge(new Edge(vertexH,8.0));
//        vertexC.addEdge(new Edge(vertexF,-4.0));
//        vertexD.addEdge(new Edge(vertexC,-2.0));
//        vertexD.addEdge(new Edge(vertexE,-3.0));
//        vertexE.addEdge(new Edge(vertexF,9.0));
//        vertexG.addEdge(new Edge(vertexH,7.0));
//
//        myGraph.addVertex(vertexA);
//        myGraph.addVertex(vertexB);
//        myGraph.addVertex(vertexC);
//        myGraph.addVertex(vertexD);
//        myGraph.addVertex(vertexE);
//        myGraph.addVertex(vertexF);
//        myGraph.addVertex(vertexG);
//        myGraph.addVertex(vertexH);
//        myGraph.addVertex(vertexI);
//
//        ArrayList<Vertex> result=myGraph.DFS();
//        for(Vertex tmpVertex : result){
//            System.out.println(tmpVertex.name);
//        }
    }

    private static void testDAGShortestPaths(){
        Graph myGraph=new Graph();
        Vertex vertexR=new Vertex("Vertex R");
        Vertex vertexS=new Vertex("Vertex S");
        Vertex vertexT=new Vertex("Vertex T");
        Vertex vertexX=new Vertex("Vertex X");
        Vertex vertexY=new Vertex("Vertex Y");
        Vertex vertexZ=new Vertex("Vertex Z");
        vertexR.addEdge(new Edge(vertexS,5.0));
        vertexR.addEdge(new Edge(vertexT,3.0));
        vertexS.addEdge(new Edge(vertexT,2.0));
        vertexS.addEdge(new Edge(vertexX,6.0));
        vertexT.addEdge(new Edge(vertexX,7.0));
        vertexT.addEdge(new Edge(vertexY,4.0));
        vertexT.addEdge(new Edge(vertexZ,2.0));
        vertexX.addEdge(new Edge(vertexY,-1.0));
        vertexX.addEdge(new Edge(vertexZ,1.0));
        vertexY.addEdge(new Edge(vertexZ,-2.0));
        myGraph.addVertex(vertexX);
        myGraph.addVertex(vertexZ);
        myGraph.addVertex(vertexS);
        myGraph.addVertex(vertexR);
        myGraph.addVertex(vertexY);
        myGraph.addVertex(vertexT);
        ArrayList<Vertex> result = myGraph.DAGShortestPaths(vertexS);
        for(Vertex tmpVertex : result){
            System.out.print(tmpVertex.name+" "+tmpVertex.shortestPathLength);
            if(tmpVertex.preVertex==null)
            {
                System.out.println("\n");
            }
            else{
                System.out.println(" "+tmpVertex.preVertex.name);
            }
        }
    }
}
