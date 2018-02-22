package com.wjzyx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Function {

    //16.1-1   begin
    public static ArrayList<Activity> activitySelect(ArrayList<Activity> activities){

        Collections.sort(activities, new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                return o1.endTime.compareTo(o2.endTime);
            }
        });

        activities.add(0,new Activity("begin",0.0,0.0));
        Activity end=activities.get(activities.size()-1);
        activities.add(
                new Activity("end",end.endTime+1,end.endTime+1));

        Integer[][] maxActivityNum=
                new Integer[activities.size()][activities.size()];
        for(int i=0;i!=maxActivityNum.length;++i)
            for (int j=0;j!=maxActivityNum[i].length;++j){
                maxActivityNum[i][j]=0;
            }
        Integer[][] choice=
                new Integer[activities.size()][activities.size()];
        for(int i=0;i!=choice.length;++i)
            for (int j=0;j!=choice[i].length;++j){
                choice[i][j]=-1;
            }

        for(int pace=2;pace!=activities.size();++pace){
            for(int begin=0;begin+pace!=activities.size();++begin){
                for(int tmpIndex=begin+1;tmpIndex!=begin+pace;++tmpIndex){
                    if(activities.get(tmpIndex).beginTime>=activities.get(begin).endTime&&
                            activities.get(tmpIndex).endTime<=activities.get(begin+pace).beginTime&&
                            maxActivityNum[begin][tmpIndex]+maxActivityNum[tmpIndex][begin+pace]+1 >maxActivityNum[begin][begin+pace]){
                        maxActivityNum[begin][begin+pace]=
                                maxActivityNum[begin][tmpIndex]+maxActivityNum[tmpIndex][begin+pace]+1;
                        choice[begin][begin+pace]=tmpIndex;
                    }
                }
            }
        }

        ArrayList<Activity> result=new ArrayList<Activity>();
        createResult(activities,choice,result,0,activities.size()-1);
        return result;
    }
    private static void createResult(ArrayList<Activity> activities,Integer[][] choice,ArrayList<Activity> result,int begin,int end){
        if(choice[begin][end]!=-1){
            result.add(activities.get(choice[begin][end]));
            createResult(activities,choice,result,begin,choice[begin][end]);
            createResult(activities,choice,result,choice[begin][end],end);
        }
        return;
    }
    //16.1-1   end

    //16.1-2   begin
    public static ArrayList<Activity> activitySelect_latestStart(ArrayList<Activity> activities){
        ArrayList<Activity> result=new ArrayList<Activity>();
        Collections.sort(activities, new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                return o1.beginTime.compareTo(o2.beginTime)*(-1);
            }
        });
        Activity tmp=activities.get(0);
        result.add(tmp);
        for(int index=1;index!=activities.size();++index){
            if(((Activity)activities.get(index)).endTime<=tmp.beginTime){
                result.add(activities.get(index));
                tmp=activities.get(index);
            }
        }
        return result;
    }
    //16.1-2   end

    //16.1-5   begin
    public static ArrayList<ValueActivity> valueActivitySelect(ArrayList<ValueActivity> activities){

        Collections.sort(activities, new Comparator<ValueActivity>() {
            @Override
            public int compare(ValueActivity o1, ValueActivity o2) {
                return o1.endTime.compareTo(o2.endTime);
            }
        });

        activities.add(0,new ValueActivity("begin",0.0,0.0,0.0));
        ValueActivity end=activities.get(activities.size()-1);
        activities.add(
                new ValueActivity("end",end.endTime+1,end.endTime+1,0.0));

        Double[][] maxValueSum=
                new Double[activities.size()][activities.size()];
        for(int i=0;i!=maxValueSum.length;++i)
            for (int j=0;j!=maxValueSum[i].length;++j){
                maxValueSum[i][j]=0.0;
            }

        Integer[][] choice=
                new Integer[activities.size()][activities.size()];
        for(int i=0;i!=choice.length;++i)
            for (int j=0;j!=choice[i].length;++j){
                choice[i][j]=-1;
            }

        for(int pace=2;pace!=activities.size();++pace){
            for(int begin=0;begin+pace!=activities.size();++begin){
                for(int tmpIndex=begin+1;tmpIndex!=begin+pace;++tmpIndex){
                    if(activities.get(tmpIndex).beginTime>=activities.get(begin).endTime&&
                            activities.get(tmpIndex).endTime<=activities.get(begin+pace).beginTime&&
                            maxValueSum[begin][tmpIndex]+maxValueSum[tmpIndex][begin+pace]+activities.get(tmpIndex).value >maxValueSum[begin][begin+pace]){
                        maxValueSum[begin][begin+pace]=
                                maxValueSum[begin][tmpIndex]+maxValueSum[tmpIndex][begin+pace]+activities.get(tmpIndex).value;
                        choice[begin][begin+pace]=tmpIndex;
                    }
                }
            }
        }

        ArrayList<ValueActivity> result=new ArrayList<ValueActivity>();
        createValueActivityResult(activities,choice,result,0,activities.size()-1);
        return result;
    }

    private static void createValueActivityResult(ArrayList<ValueActivity> activities,
                                                  Integer[][] choice,
                                                  ArrayList<ValueActivity> result,
                                                  int begin,int end){
        if(choice[begin][end]!=-1){
            result.add(activities.get(choice[begin][end]));
            createValueActivityResult(activities,choice,result,begin,choice[begin][end]);
            createValueActivityResult(activities,choice,result,choice[begin][end],end);
        }
        return;
    }
    //16.1-5   end

    //16.2-2   begin
    public static ArrayList<Commodity> packsackQuestion(Integer bagCapacity,ArrayList<Commodity> allCommodities) {
        //
        Integer[][] maxValue=new Integer[allCommodities.size()+1][bagCapacity+1];
        for(int i=0;i!=allCommodities.size()+1;++i)
            for(int j=0;j!=bagCapacity+1;++j)
                maxValue[i][j]=0;

        for(int commodityNum=1;commodityNum!=allCommodities.size()+1;++commodityNum){
            Commodity tmpCommodity=allCommodities.get(commodityNum-1);
            for(int tmpCapacity=0;tmpCapacity!=bagCapacity+1;++tmpCapacity){
                if(tmpCommodity.weight>tmpCapacity){
                    maxValue[commodityNum][tmpCapacity]=maxValue[commodityNum-1][tmpCapacity];
                }
                else{
                    maxValue[commodityNum][tmpCapacity]=Integer.max(
                            maxValue[commodityNum-1][tmpCapacity],
                            maxValue[commodityNum-1][tmpCapacity-tmpCommodity.weight]+tmpCommodity.value
                    );
                }
            }
        }

        ArrayList<Commodity> result=new ArrayList<Commodity>();
        for(int tmpCapacity=bagCapacity,commodityNum=allCommodities.size();commodityNum!=0;){
            if(maxValue[commodityNum][tmpCapacity]>maxValue[commodityNum-1][tmpCapacity]){
                result.add(allCommodities.get(commodityNum-1));
                tmpCapacity-=allCommodities.get(commodityNum-1).weight;
            }
            --commodityNum;
        }
        return result;
    }

    //16.2-2   end
}

