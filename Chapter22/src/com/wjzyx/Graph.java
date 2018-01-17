package com.wjzyx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Graph {
    public ArrayList<Vertex> allVertex;

    public int timestamp=0;  //used in DFS

    public Graph(){
        allVertex=new ArrayList<Vertex>();
    }

    public void addVertex(Vertex newNode){
        allVertex.add(newNode);
    }

    public void print(){
        for(int tmp=0; tmp!=allVertex.size(); ++tmp){
            Vertex tmpVertex=allVertex.get(tmp);
            System.out.println(tmpVertex.name+" "+
                    tmpVertex.discoverdTimestamp+" "+tmpVertex.finishedTimestamp+":");
            for(int tmpEdge=0;tmpEdge!=tmpVertex.allEdges.size();++tmpEdge)
            {
                System.out.print(tmpVertex.allEdges.get(tmpEdge).terminus.name);
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    public void reset(){

        timestamp=0;
        for(int tmp=0;tmp!=allVertex.size();++tmp){
            Vertex tmpV=allVertex.get(tmp);
            tmpV.color=Color.White;
            tmpV.depth=Integer.MAX_VALUE;
            tmpV.discoverdTimestamp=0;
            tmpV.finishedTimestamp=0;
        }
    }






    public ArrayList<Vertex> BFS(Vertex start){
        reset();
        ArrayList<Vertex> searchOrder=new ArrayList<Vertex>();
        ArrayList<Vertex> queue=new ArrayList<Vertex>();
        start.depth=0;
        queue.add(start);
        while(!queue.isEmpty()){
            Vertex tmpVertex=queue.remove(0);
            tmpVertex.color=Color.Black;
            searchOrder.add(tmpVertex);
            for(int tmp=0;tmp!=tmpVertex.allEdges.size();++tmp){
                if(tmpVertex.allEdges.get(tmp).terminus.color==Color.White) {
                    queue.add(tmpVertex.allEdges.get(tmp).terminus);
                    tmpVertex.allEdges.get(tmp).terminus.color=Color.Black;
                    tmpVertex.allEdges.get(tmp).terminus.depth=tmpVertex.depth+1;
                }
            }
        }
        return searchOrder;
    }



    private void DFSVisit(Vertex vertex){
        vertex.color=Color.Black;
        vertex.discoverdTimestamp=++timestamp;
        for(int tmpV=0;tmpV!=vertex.allEdges.size();++tmpV){
            Edge tmpE=vertex.allEdges.get(tmpV);
            if(tmpE.terminus.color==Color.White){
                DFSVisit(tmpE.terminus);
            }
        }
        vertex.finishedTimestamp=++timestamp;
    }

    public Graph DFS(){
        reset();
        for(int tmpVertex=0;tmpVertex!=allVertex.size();++tmpVertex){
            if(allVertex.get(tmpVertex).color==Color.White){
                DFSVisit(allVertex.get(tmpVertex));
            }
        }
        return this;
    }


    private void transposition(){
        ArrayList<Integer> originalSize=new ArrayList<Integer>();
        for(int tmpV=0;tmpV!=allVertex.size();++tmpV){
            originalSize.add(allVertex.get(tmpV).allEdges.size());
        }
        for(int tmpV=0;tmpV!=allVertex.size();++tmpV){
            Vertex tmpVertex=allVertex.get(tmpV);
            for(int count=0;count!=originalSize.get(tmpV);++count){
                tmpVertex.allEdges.get(0).terminus.allEdges.add(new Edge(1.0,tmpVertex));
                tmpVertex.allEdges.remove(0);
            }
        }
    }

    private void descendVertexByFinishedTimestamp(int begin,int end){
        if(begin>=end)
            return;
        Vertex center=allVertex.get(begin);
        int leftP=begin+1;
        int rightP=end;
        while(true) {
            while (leftP <= end &&
                    allVertex.get(leftP).finishedTimestamp > center.finishedTimestamp) {
                ++leftP;
            }
            while (rightP >= begin+1 &&
                    allVertex.get(rightP).finishedTimestamp <= center.finishedTimestamp) {
                --rightP;
            }
            if(leftP<rightP){
                Collections.swap(allVertex,leftP,rightP);
            }
            else {
                Collections.swap(allVertex,begin,rightP);
                break;
            }
        }
        descendVertexByFinishedTimestamp(begin,rightP-1);
        descendVertexByFinishedTimestamp(rightP+1,end);
    }

    public Graph StronglyConnectedComponents(){
        DFS();
        transposition();
        descendVertexByFinishedTimestamp(0,allVertex.size()-1);
        DFS();
        return this;
    }




}

