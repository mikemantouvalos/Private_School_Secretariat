
package Entities;

import java.time.LocalDate;

public class Course {
    int code; 
    String title;
    String stream;
    String type;
    LocalDate startDate;
    LocalDate emdDate;

    public Course() {
        
    }

    public Course(String title, String stream, String type, LocalDate startDate, LocalDate emdDate) {
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.startDate = startDate;
        this.emdDate = emdDate;
        
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
    
    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEmdDate() {
        return emdDate;
    }

    public void setEmdDate(LocalDate emdDate) {
        this.emdDate = emdDate;
    }

    @Override
    public String toString() {
        return "Course{" + "code=" + code + ", title=" + title + ", stream=" + stream + ", type=" + type + ", startDate=" + startDate + ", emdDate=" + emdDate + '}';
    }

 

}
