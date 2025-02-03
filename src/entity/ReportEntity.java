package entity;

public class ReportEntity {
        private String studentId;
        private String StudentName;
        private String department;
        private String courseName;
        private String grade;

    public ReportEntity(String StudentName, String courseName, String department, String grade, String studentId) {
        this.StudentName = StudentName;
        this.courseName = courseName;
        this.department = department;
        this.grade = grade;
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "reportEntity [studentId=" + studentId + ", StudentName=" + StudentName + ", department=" + department
                + ", courseName=" + courseName + ", grade=" + grade + "]";
    }

    
}
