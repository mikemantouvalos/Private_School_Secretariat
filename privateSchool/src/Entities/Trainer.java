
package Entities;

public class Trainer {
    int code;
    String name;
    String lastName;
    String subject;

    public Trainer() {
        
    }

    public Trainer(String name, String lastName, String Subject) {
        this.name = name;
        this.lastName = lastName;
        this.subject = Subject;
       
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String Subject) {
        this.subject = Subject;
    }

    @Override
    public String toString() {
        return "Trainer{" + "code=" + code + ", name=" + name + ", lastName=" + lastName + ", subject=" + subject + '}';
    }

   
    
    
    
    

}
