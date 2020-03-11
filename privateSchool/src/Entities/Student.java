
package Entities;

import java.time.LocalDate;

public class Student {
    private int code;
    private String name;
    private String lastName;
    private LocalDate dateOfBirth;
    private int tuitionFees;

    public Student() {
        
    }
    
    

    public Student(String name, String lastName, LocalDate dateOfBirth, int tuitionFees) {
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.tuitionFees = tuitionFees;
        
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(int tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    @Override
    public String toString() {
        return "Student{" + "code=" + code + ", name=" + name + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", tuitionFees=" + tuitionFees + '}';
    }

  
    
    
    
    
    
   
    

}
