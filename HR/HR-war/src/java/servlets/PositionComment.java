package servlets;

import java.io.Serializable;

public class PositionComment implements Serializable {

    private int id;
    private String comment;

    PositionComment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
