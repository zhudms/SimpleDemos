package zxyilian.mytreelistdemo.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by TANG on 2016/4/12.
 */
public class MessageByTime implements Serializable {

    private String title;
    private String time;
    private int type;//不同的消息类型加载不同界面（这里考虑复用）
    private ArrayList<MessageDetaile> messageItems;
    private boolean isCollected;
    private boolean isNewMessage;
    private boolean isShown;//这个八成用不到

}
