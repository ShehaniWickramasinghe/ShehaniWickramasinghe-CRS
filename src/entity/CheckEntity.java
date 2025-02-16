package entity;

public class CheckEntity {
        private String name;
        private String prerequisites;
        public CheckEntity(String name, String prerequisites) {
            this.name = name;
            this.prerequisites = prerequisites;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getPrerequisites() {
            return prerequisites;
        }
        public void setPrerequisites(String prerequisites) {
            this.prerequisites = prerequisites;
        }
        @Override
        public String toString() {
            return "CheckEntity [name=" + name + ", prerequisites=" + prerequisites + "]";
        }

        

        
}
