package dto;

public class CourseReportdto {
        private String name;
        private int enrolledStudent;
        private int completedStudent;
        private String performance;
        private int rate;
        
        public CourseReportdto(String name, int enrolledStudent, int completedStudent, String performance,
                int rate) {
            this.name = name;
            this.enrolledStudent = enrolledStudent;
            this.completedStudent = completedStudent;
            this.performance = performance;
            this.rate = rate;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getEnrolledStudent() {
            return enrolledStudent;
        }

        public void setEnrolledStudent(int enrolledStudent) {
            this.enrolledStudent = enrolledStudent;
        }

        public int getCompletedStudent() {
            return completedStudent;
        }

        public void setCompletedStudent(int completedStudent) {
            this.completedStudent = completedStudent;
        }

        public String getPerformance() {
            return performance;
        }

        public void setPerformance(String performance) {
            this.performance = performance;
        }

        public int getRate() {
            return rate;
        }

        public void setRate(int rate) {
            this.rate = rate;
        }

        @Override
        public String toString() {
            return "CourseReportdto [name=" + name + ", enrolledStudent=" + enrolledStudent + ", completedStudent="
                    + completedStudent + ", performance=" + performance + ", rate=" + rate + "]";
        }

        
}
