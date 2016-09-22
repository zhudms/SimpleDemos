package zxyilian.myretrofitdemo.Events;

/**
 * Created by TANG on 2016/3/4.
 */
public class PatientsMessageE {

    private String message;
    private Object messageObj;

    public PatientsMessageE(String message) {
        this.message = message;
        messageObj = null;
    }

    public PatientsMessageE(Object obj) {
        this.message = null;
        this.messageObj = obj;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getMessageObj() {
        return messageObj;
    }

    public void setMessageObj(Object messageObj) {
        this.messageObj = messageObj;
    }
}

