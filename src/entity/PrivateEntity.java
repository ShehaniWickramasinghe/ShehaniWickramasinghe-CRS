package entity;

public class PrivateEntity {
        private String Id;
        private String name;
        private String department;
        private String attendance;
        private String sem1Grade;
        private String sem2Grade;
        
        public PrivateEntity(String Id, String name, String department, String attendance, String sem1Grade,
                String sem2Grade) {
            this.Id = Id;
            this.name = name;
            this.department = department;
            this.attendance = attendance;
            this.sem1Grade = sem1Grade;
            this.sem2Grade = sem2Grade;
        }

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getAttendance() {
            return attendance;
        }

        public void setAttendance(String attendance) {
            this.attendance = attendance;
        }

        public String getSem1Grade() {
            return sem1Grade;
        }

        public void setSem1Grade(String sem1Grade) {
            this.sem1Grade = sem1Grade;
        }

        public String getSem2Grade() {
            return sem2Grade;
        }

        public void setSem2Grade(String sem2Grade) {
            this.sem2Grade = sem2Grade;
        }

        @Override
        public String toString() {
            return "PrivateEntity [Id=" + Id + ", name=" + name + ", department=" + department + ", attendance="
                    + attendance + ", sem1Grade=" + sem1Grade + ", sem2Grade=" + sem2Grade + "]";
        }

        
}
