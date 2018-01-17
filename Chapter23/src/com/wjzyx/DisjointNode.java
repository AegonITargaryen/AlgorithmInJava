package com.wjzyx;

public class DisjointNode {
    public DisjointNode parent;

    public DisjointNode(){
        this.parent=this;
    }

    public DisjointNode findSet(){
        if(parent!=this)
            parent=parent.findSet();
        return parent;
    }

    public void union(DisjointNode willBeJoint){
        link(this.findSet(),willBeJoint.findSet());
    }

    private void link(DisjointNode set1,DisjointNode set2){
        set2.parent=set1;
    }
}
