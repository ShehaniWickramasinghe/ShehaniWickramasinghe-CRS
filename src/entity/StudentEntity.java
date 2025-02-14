package entity;

import java.time.LocalDate;
import java.util.List;


public class StudentEntity {
    private String studentId;
    private String name;
    private LocalDate DOB;
    private String phoneNumber;
    private String email;
    private List<String> semester1;
    private List<String> semester2;

    public StudentEntity(String studentId, String name, LocalDate dOB, String phoneNumber, String email,
    List<String> semester1,List<String> semester2) {
        this.studentId = studentId;
        this.name = name;
        this.DOB = dOB;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.semester1 = semester1;
        this.semester2 = semester2;
    }

public String getStudentId() {
    return studentId;
}

public void setStudentId(String studentId) {
    this.studentId = studentId;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public LocalDate getDOB() {
    return DOB;
}

public void setDOB(LocalDate DOB) {
    this.DOB = DOB;
}

public String getPhoneNumber() {
    return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public List<String> getSemester1() {
    return semester1;
}

public void setSemester1(List<String> semester1) {
    this.semester1 = semester1;
}

public List<String> getSemester2() {
    return semester2;
}

public void setSemester2(List<String> semester2) {
    this.semester2 = semester2;
}

@Override
public String toString() {
    return "StudentEntity [studentId=" + studentId + ", name=" + name + ", DOB=" + DOB + ", phoneNumber=" + phoneNumber
            + ", email=" + email + ", semester1=" + semester1 + ", semester2=" + semester2 + "]";
}

        
}
