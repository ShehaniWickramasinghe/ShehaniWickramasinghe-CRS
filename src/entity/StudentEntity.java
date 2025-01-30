package entity;

import java.time.LocalDate;
import java.util.ArrayList;

public class StudentEntity {
        private String studentId;
        private String Name;
        private LocalDate DOB;
        private String phoneNumber;
        private String email;
        private ArrayList<String> programOfStudy;
        
        public StudentEntity(String studentId, String name, LocalDate dOB, String phoneNumber, String email,
                ArrayList<String> programOfStudy) {
            this.studentId = studentId;
            Name = name;
            DOB = dOB;
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
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
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

    public ArrayList<String> getProgramOfStudy() {
        return programOfStudy;
    }

    public void setProgramOfStudy(ArrayList<String> programOfStudy) {
        this.programOfStudy = programOfStudy;
    }

    @Override
    public String toString() {
        return "StudentEntity [studentId=" + studentId + ", Name=" + Name + ", DOB=" + DOB + ", phoneNumber="
                + phoneNumber + ", email=" + email + ", programOfStudy=" + programOfStudy + "]";
    }

        
}
