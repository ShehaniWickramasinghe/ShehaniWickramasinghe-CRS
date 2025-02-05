package entity;

import java.util.List;

public class CourseEntity {
         private String courseId;
        private String name;
        private String creditHour;
        private String prerequisites;
        private Integer maximumCapacity;
        private List<String> department;

    public CourseEntity(String courseId, String name,String creditHour, Integer maximumCapacity, String prerequisites, List<String> department) {
        this.courseId = courseId;
        this.name = name;
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

    public List<String> getDepartment() {
        return department;
    }

    public void setDepartment(List<String> department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "CourseEntity [courseId=" + courseId + ", name=" + name 
                + ", creditHour=" + creditHour + ", prerequisites=" + prerequisites + ", maximumCapacity="
                + maximumCapacity + ", department=" + department + "]";
    }

    


}
