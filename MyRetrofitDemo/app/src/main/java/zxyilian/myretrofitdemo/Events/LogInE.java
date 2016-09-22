package zxyilian.myretrofitdemo.Events;

/**
 * Created by TANG on 2016/3/4.
 */
public class LogInE {

    private String message;
    private Object messageObj;

    public LogInE(String message) {
        this.message = message;
        messageObj = null;
    }

    public LogInE(Object obj) {
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

