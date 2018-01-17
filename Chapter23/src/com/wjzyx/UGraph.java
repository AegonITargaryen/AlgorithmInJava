package com.wjzyx;


import java.util.ArrayList;
import java.util.Collections;

//Undirected graph
public class UGraph {
    public ArrayList<Vertex> allVertexs;

    public UGraph(){
        allVertexs=new ArrayList<Vertex>();
    }

    public void addVertex(Vertex newV){
        allVertexs.add(newV);
    }


    private void descendEdgesByValue(ArrayList<Edge> graphAllEdges,int begin,int end){
        if(begin>=end)
            return;
        Edge dividePoint=graphAllEdges.get(begin);
        int leftP=begin+1;
        int rightP=end;
        while(true) {
            while (leftP <= end && graphAllEdges.get(leftP).value <= dividePoint.value) {
                ++leftP;
            }
            while (rightP >= begin+1 && graphAllEdges.get(rightP).value > dividePoint.value) {
                --rightP;
            }

            if(rightP<leftP){
                Collections.swap(graphAllEdges,begin,rightP);
                break;
            }
            else{
                Collections.swap(graphAllEdges,leftP,rightP);
            }
        }
        descendEdgesByValue(graphAllEdges,begin,rightP-1);
        descendEdgesByValue(graphAllEdges,rightP+1,end);
    }


    public ArrayList<Edge> MSTKruskal(){
        ArrayList<Edge> graphAllEdges=new ArrayList<Edge>();
        ArrayList<Edge> MSTEdges=new ArrayList<Edge>();

        for(int tmpV=0;tmpV!=allVertexs.size();++tmpV){
            Vertex tmpVertex=allVertexs.get(tmpV);
            for(int tmpE=0;tmpE!=tmpVertex.allEdges.size();++tmpE){
                Edge tmpEdge=tmpVertex.allEdges.get(tmpE);
                if(graphAllEdges.indexOf(tmpEdge)==-1){
                    graphAllEdges.add(tmpEdge);
                }
            }
        }

        //sort graphAllEdges by the value in descending order
        descendEdgesByValue(graphAllEdges,0,graphAllEdges.size()-1);

        for(int tmpE=0;tmpE!=graphAllEdges.size();++tmpE){
            Edge tmpEdge=graphAllEdges.get(tmpE);
            Vertex endpoint1=tmpEdge.endpoint1;
            Vertex endpoint2=tmpEdge.endpoint2;
            if(endpoint1.findSet()!=endpoint2.findSet()){
                MSTEdges.add(tmpEdge);
                endpoint1.union(endpoint2);
            }
        }

        return MSTEdges;
    }

    public ArrayList<Edge> MSTPrim(Vertex tmpVertex){
        ArrayList<Edge> result=new ArrayList<Edge>();

        ArrayList<Vertex> excludeVertexs=(ArrayList<Vertex>)this.allVertexs.clone();
        excludeVertexs.remove(tmpVertex);

        ArrayList<Edge> stretchEdges=new ArrayList<Edge>();
        for(int tmpE=0;tmpE!=tmpVertex.allEdges.size();++tmpE){
            stretchEdges.add(tmpVertex.allEdges.get(tmpE));
        }

        while(excludeVertexs.size()!=0){
            Edge lightweightEdge=stretchEdges.get(0);
            for(int tmpE=1;tmpE!=stretchEdges.size();++tmpE){
                if(lightweightEdge.value>stretchEdges.get(tmpE).value){
                    lightweightEdge=stretchEdges.get(tmpE);
                }
            }
            Vertex newVertex;
            if(excludeVertexs.indexOf(lightweightEdge.endpoint1)==-1){
                newVertex=lightweightEdge.endpoint2;
            }
            else
            {
                newVertex=lightweightEdge.endpoint1;
            }
            result.add(lightweightEdge);
            excludeVertexs.remove(newVertex);

            for(int tmpE=stretchEdges.size()-1;tmpE!=-1;--tmpE){
                if( excludeVertexs.indexOf(stretchEdges.get(tmpE).endpoint1)==-1 &&
                        excludeVertexs.indexOf(stretchEdges.get(tmpE).endpoint2)==-1){
                    stretchEdges.remove(tmpE);
                }
            }
            for(int tmpE=0;tmpE!=newVertex.allEdges.size();++tmpE){
                if( !(excludeVertexs.indexOf(newVertex.allEdges.get(tmpE).endpoint1)==-1 &&
                        excludeVertexs.indexOf(newVertex.allEdges.get(tmpE).endpoint2)==-1)){
                    stretchEdges.add(newVertex.allEdges.get(tmpE));
                }
            }
        }
        return result;
    }



}
