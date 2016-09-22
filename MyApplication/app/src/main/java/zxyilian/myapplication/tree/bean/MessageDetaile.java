package zxyilian.myapplication.tree.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by TANG on 2016/4/12.
 */
public class MessageDetaile implements Serializable {

    public String level;//层级
    public String title;//
    @TreeNodeLabel
    public String message;
    public String isCollected;
    public String isNewMessage;
    public String uri;
    public String childNumb;
    public String time;
    public String type;//区分图标应该显示什么
    public ArrayList<MessageDetaile> childLists;
    @TreeNodePid
    public int parentID;//父目录
    @TreeNodeId
    public int id;//messageId

    public boolean isExpand() {
        return expand;
    }

    public void setExpand(boolean expand) {
        this.expand = expand;
    }

    private boolean expand;
    public MessageDetaile(int id, int parentID, String message) {
        this.id = id;
        this.parentID =parentID;
        this.message = message;
    }
}
