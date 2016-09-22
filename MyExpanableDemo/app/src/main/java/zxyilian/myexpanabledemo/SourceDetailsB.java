package zxyilian.myexpanabledemo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 資源詳情(通过目录ID直接返回资源列表，包含资源具体内容）
 * Created by TANG on 2016/3/14.
 */
public class SourceDetailsB implements Serializable {

    public static final String SOURCE_DETAILS_PARENTID="source_parent_id";
    public static final String SOURCE_DETAILS_TITLE="source_title";
    public static final String SOURCE_DETAILS_PARENTTITLE="source_parent_title";
    public static final String SOURCE_DETAILS_MESSAGE="source_parent_message";

public static  final int source_title=1;

    public String GUID;//资源ID

    public String SHOW_TYPE;//二级分类
    public String MODEL_NAME;//模板名称

    public String getTYPE_ID() {
        return TYPE_ID;
    }

    public void setTYPE_ID(String TYPE_ID) {
        this.TYPE_ID = TYPE_ID;
    }

    public String TYPE_ID;//PID

    public String RES_CONTENT;//msg_tip
    public String TITLE;//
    public String RES_HTMLCONTENT;//网页的具体内容







    public boolean isParent=false;
    public ArrayList<SourceDetailsB> childLists;

    public boolean isParent() {
        return isParent;
    }

    public void setIsParent(boolean isParent) {
        this.isParent = isParent;
    }

    public ArrayList<SourceDetailsB> getChildLists() {
        return childLists;
    }

    public void setChildLists(ArrayList<SourceDetailsB> childLists) {
        this.childLists = childLists;
    }

    public SourceDetailsB(String name) {
        MODEL_NAME = name;
        childLists = new ArrayList<SourceDetailsB>();
        isParent=true;
    }


    public void addChild(SourceDetailsB source){
        childLists.add(source);
    }
//
//    public static String getSourceDetailsParentid() {
//        return SOURCE_DETAILS_PARENTID;
//    }
//
//    public static String getSourceDetailsTitle() {
//        return SOURCE_DETAILS_TITLE;
//    }
//
//    public static String getSourceDetailsParenttitle() {
//        return SOURCE_DETAILS_PARENTTITLE;
//    }
//
//    public static String getSourceDetailsMessage() {
//        return SOURCE_DETAILS_MESSAGE;
//    }

    public String getSHOW_TYPE() {
        return SHOW_TYPE;
    }

    public void setSHOW_TYPE(String SHOW_TYPE) {
        this.SHOW_TYPE = SHOW_TYPE;
    }

    public String getRES_CONTENT() {
        return RES_CONTENT;
    }

    public void setRES_CONTENT(String RES_CONTENT) {
        this.RES_CONTENT = RES_CONTENT;
    }

    public String getRES_HTMLCONTENT() {
        return RES_HTMLCONTENT;
    }

    public void setRES_HTMLCONTENT(String RES_HTMLCONTENT) {
        this.RES_HTMLCONTENT = RES_HTMLCONTENT;
    }


//    public String CREATE_TIME;
//    public String UPDATE_TIME;

//    public String STATUS;//这是什么字段？
//    public String COLLECTED;//当前用户是否收藏了
//    public String CREATER;//
//    public String ORG_CODE;//
//    public String UPDATE_USER;//


//    public String WARD_CODE;//


//    public String VIDEO_PATH;//影像路径，空值代表没有影像**
//    public String IS_COLLECT;//是否收藏;1，是;0，不是



    public String getGUID() {
        return GUID;
    }

    public void setGUID(String GUID) {
        this.GUID = GUID;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }


    public String getMODEL_NAME() {
        return MODEL_NAME;
    }

    public void setMODEL_NAME(String MODEL_NAME) {
        this.MODEL_NAME = MODEL_NAME;
    }
}
