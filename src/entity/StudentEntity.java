package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;

public class StudentEntity {
        private String studentId;
        private String name;
        private LocalDate DOB;
        private String phoneNumber;
        private String email;
        private List<String> programOfStudy;
        
        public StudentEntity(String studentId, String name, LocalDate dOB, String phoneNumber, String email,
        List<String> programOfStudy) {
            this.studentId = studentId;
            this.name = name;
            this.DOB = dOB;
            this.phoneNumber = phoneNumber;
            this.email = email;
            this.programOfStudy = programOfStudy;
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

    public void setName(String Name) {
        this.name = Name;
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

    public List<String> getProgramOfStudy() {
        return programOfStudy;
    }

    public void setProgramOfStudy(List<String> programOfStudy) {
        this.programOfStudy = programOfStudy;
    }

    @Override
    public String toString() {
        return "StudentEntity [studentId=" + studentId + ", Name=" + name + ", DOB=" + DOB + ", phoneNumber="
                + phoneNumber + ", email=" + email + ", programOfStudy=" + programOfStudy + "]";
    }

        
}
