package zxyilian.myexpanabledemo;

import java.io.Serializable;

/**
 * Created by TANG on 2016/4/7.
 */
public class RetrofitB implements Serializable{

//    public static final String REQUEST_SUCCESS="1";
//    public static final String REQUEST_FAIL="0";

    private String MESSAGE;
    private int FLAG;
    private String TYPE;

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public int getFLAG() {
        return FLAG;
    }

    public void setFLAG(int FLAG) {
        this.FLAG = FLAG;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

}
