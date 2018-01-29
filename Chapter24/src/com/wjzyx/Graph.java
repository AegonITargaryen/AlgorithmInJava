package com.wjzyx;

import java.util.ArrayList;

public class Graph {
    public ArrayList<Vertex> allVertexs;
    public int timestamp;

    public Graph(){
        this.allVertexs=new ArrayList<Vertex>();
        this.timestamp=0;
    }

    public void addVertex(Vertex newVertex){
        this.allVertexs.add(newVertex);
    }

    private void relax(Vertex origin, Edge tmpEdge){
        if(origin.shortestPathLength+tmpEdge.value<tmpEdge.terminus.shortestPathLength){
            tmpEdge.terminus.preVertex=origin;
            tmpEdge.terminus.shortestPathLength=origin.shortestPathLength+tmpEdge.value;
        }
    }

    private void reset(){
        for(int tmpV=0;tmpV!=this.allVertexs.size();++tmpV){
            Vertex tmpVertex=this.allVertexs.get(tmpV);
            tmpVertex.shortestPathLength=Double.MAX_VALUE;
            tmpVertex.preVertex=null;
            tmpVertex.discoverdTimestamp=0;
            tmpVertex.finishedTimestamp=0;
            tmpVertex.color=Color.White;
            this.timestamp=0;
        }
    }

    public boolean BellmanFord(Vertex startVertex){
        reset();
        startVertex.shortestPathLength=0.0;
        for(int iterationNum=1;iterationNum!=this.allVertexs.size();++iterationNum){
            for(Vertex tmpVertex : this.allVertexs){
                for(Edge tmpEdge : tmpVertex.allEdges){
                    relax(tmpVertex,tmpEdge);
                }
            }
        }

        for(Vertex tmpVertex : this.allVertexs){
            for(Edge tmpEdge : tmpVertex.allEdges){
                if(tmpEdge.value+tmpVertex.shortestPathLength<tmpEdge.terminus.shortestPathLength){
                    return false;
                }
            }
        }
        return true;
    }


    //The returned object is the sequence of vertexs which is topological sorted.
    public ArrayList<Vertex> DFS(){
        reset();
        ArrayList<Vertex> topologicalSort=new ArrayList<Vertex>();
        for(Vertex tmpVertex : this.allVertexs){
            if(tmpVertex.color==Color.White){
                DFSVisit(tmpVertex,topologicalSort);
            }
        }
        return topologicalSort;
    }

    private void DFSVisit(Vertex vertex,ArrayList<Vertex> topologicalSort){
        ++timestamp;
        vertex.color=Color.Black;
        vertex.discoverdTimestamp=timestamp;
        for(Edge tmpEdge : vertex.allEdges){
            if(tmpEdge.terminus.color==Color.White){
                DFSVisit(tmpEdge.terminus,topologicalSort);
            }
        }
        ++timestamp;
        vertex.finishedTimestamp=timestamp;
        topologicalSort.add(0,vertex);
    }

    public ArrayList<Vertex> DAGShortestPaths(Vertex start){
        reset();
        ArrayList<Vertex> result=DFS();
        start.shortestPathLength=0.0;
        for(Vertex tmpVertex : result){
            for(Edge tmpEdge : tmpVertex.allEdges){
                relax(tmpVertex,tmpEdge);
            }
        }
        return result;
    }
}
