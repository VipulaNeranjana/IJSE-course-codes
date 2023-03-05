package lk.ijse.dep10.shared;

import java.io.Serializable;

public class Dep10Message implements Serializable {
    private Dep10Header header;
    private Object body;

    public Dep10Message(Dep10Header header, Object body) {
        this.header = header;
        this.body = body;
    }

    public Dep10Message() {
    }

    public Dep10Header getHeader() {
        return header;
    }

    public void setHeader(Dep10Header header) {
        this.header = header;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
