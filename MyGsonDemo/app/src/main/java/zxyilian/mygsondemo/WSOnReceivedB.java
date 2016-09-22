package zxyilian.mygsondemo;

/**
 * WebSocketOnReceivedBean
 * 需要统一格式来初步解析，再根据类型具体解析
 * Created by TANG on 2016/3/22.
 */
public class WSOnReceivedB {


    int type;
    Object Object;
    boolean isSuccess;

    public WSOnReceivedB(String message) {
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public java.lang.Object getObject() {
        return Object;
    }

    public void setObject(java.lang.Object object) {
        Object = object;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
}
