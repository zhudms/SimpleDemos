package zxyilian.mytreelistdemo.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by TANG on 2016/4/12.
 */
public class MessageDetaile {
    public static final int TYPE_FLODER = 0;
    public static final int TYPE_FILE = 1;
    public int level;//控制缩进多少
    public String title;

    public boolean isCollected;
    public boolean isNewMessage;
    public String uri;
    private int childNumb;//还未知能不能直接获取到
    public String time;
    public int type;//区分图标应该显示什么
    public ArrayList<MessageDetaile> childLists = new ArrayList<MessageDetaile>();
    public boolean isExpand;
    public boolean isParentShown;
    public boolean isLeaf = true;//不能用childlist。size判断，有可能是空文件夹


    @TreeNodeLabel
    public String message;//消息界面某条下面的说明
    @TreeNodeId
    public int id;
    @TreeNodePid
    public int pId;
    @TreeNodeBean
    public MessageDetaile ditail;

    public MessageDetaile(int id,int pid,String name,MessageDetaile detaile){
        this.id=id;
        this.pId=pid;
        this.message=name;
        this.ditail=detaile;
    }

    public  MessageDetaile(){

    }
    public void addItems(MessageDetaile detaile) {
        isLeaf = false;
        childLists.add(detaile);
    }


    public void addChildren(ArrayList<MessageDetaile> childLists) {

        isLeaf = false;
        childLists.addAll(childLists);
    }


    public boolean isLeaf() {
        return isLeaf;
    }

    public void showChildren() {
        isExpand = !isExpand;
    }

    public int getChildNumb() {

        return childLists.size();
    }
}
