//package zxyilian.myexpanabledemo;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//
///**
// * Created by TANG on 2016/5/5.
// */
//public class SourceMoudle implements Serializable {
//
//    public String MODEL_NAME;
//    public ArrayList<SourceDetailsB> childLists;
//
//    public SourceMoudle(String name) {
//        MODEL_NAME = name;
//        childLists = new ArrayList<SourceDetailsB>();
//    }
//
//    public void addChild(SourceDetailsB details) {
//        childLists.add(details);
//    }
//
//    public SourceDetailsB getChildAt(int position) {
//        return childLists.get(position);
//    }
//
//    public String getMODEL_NAME() {
//        return MODEL_NAME;
//    }
//
//    public void setMODEL_NAME(String MODEL_NAME) {
//        this.MODEL_NAME = MODEL_NAME;
//    }
//
//    public ArrayList<SourceDetailsB> getChildLists() {
//        return childLists;
//    }
//
//    public void setChildLists(ArrayList<SourceDetailsB> childLists) {
//        this.childLists = childLists;
//    }
//}
