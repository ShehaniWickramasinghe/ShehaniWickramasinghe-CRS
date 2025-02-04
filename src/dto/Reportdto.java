package dto;

public class Reportdto {
        private String studentId;
        private String studentName;
        private String department;
        private String course;
        private String grade;
        public Reportdto(String studentId, String studentName, String department, String course, String grade) {
            this.studentId = studentId;
            this.studentName = studentName;
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
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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
        return "Reportdto [studentId=" + studentId + ", studentName=" + studentName + ", department=" + department
                + ", course=" + course + ", grade=" + grade + "]";
    }

        
}
