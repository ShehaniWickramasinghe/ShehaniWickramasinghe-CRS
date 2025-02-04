package entity;

public class ReportEntity {
        private String studentId;
        private String StudentName;
        private String department;
        private String course;
        private String grade;

    public ReportEntity(String studentId,String StudentName,String department, String course,  String grade ) {
        this.studentId = studentId;
        this.StudentName = StudentName;
        this.department = department;
        this.course = course;
        this.grade = grade;
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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
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
                + ", course=" + course + ", grade=" + grade + "]";
    }

    
}
