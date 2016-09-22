package zxyilian.myapplication.tree.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by TANG on 2016/4/12.
 */
public class MessageByTime implements Serializable {

    private String title;
    private String time;
    private ArrayList<MessageDetaile> messageItems;
    private boolean isCollected;
    private boolean isNewMessage;

}
