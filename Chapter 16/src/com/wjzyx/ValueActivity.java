package com.wjzyx;

public class ValueActivity {
    public Double beginTime;
    public Double endTime;
    public String name;
    public Double value;

    public ValueActivity(String name,Double beginTime,Double endTime,Double value){
        this.name=name;
        this.beginTime=beginTime;
        this.endTime=endTime;
        this.value=value;
    }
}
