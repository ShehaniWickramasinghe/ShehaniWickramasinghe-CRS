package dto;

import java.util.ArrayList;

public class Coursedto {
        private String courseId;
        private String name;
        private String description;
        private String creditHour;
        private String prerequisites;
        private Integer maximumCapacity;
        private ArrayList<String> department;

        public Coursedto(String courseId, String name, String description, String creditHour, String prerequisites,
                Integer maximumCapacity, ArrayList<String> department) {
            this.courseId = courseId;
            this.name = name;
            this.description = description;
            this.creditHour = creditHour;
            this.prerequisites = prerequisites;
            this.maximumCapacity = maximumCapacity;
            this.department = department;
        }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreditHour() {
        return creditHour;
    }

    public void setCreditHour(String creditHour) {
        this.creditHour = creditHour;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    public Integer getMaximumCapacity() {
        return maximumCapacity;
    }

    public void setMaximumCapacity(Integer maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public ArrayList<String> getDepartment() {
        return department;
    }

    public void setDepartment(ArrayList<String> department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Coursedto [courseId=" + courseId + ", name=" + name + ", description=" + description + ", creditHour="
                + creditHour + ", prerequisites=" + prerequisites + ", maximumCapacity=" + maximumCapacity
                + ", department=" + department + "]";
    }

        
}
