package servlets;

import java.io.Serializable;

public class CurriculumVitae implements Serializable {

    private int id;
    private String title;

    CurriculumVitae() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
