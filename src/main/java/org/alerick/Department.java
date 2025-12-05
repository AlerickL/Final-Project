package org.alerick;

public class Department {
    private String departmentId;
    private String departmentName;
    private static int nextId = 1;

    public Department(String departmentName) {
        if (isDepartmentNameValid(departmentName)){
            this.departmentName = Util.toTitleCase(departmentName);
            this.departmentId = String.format("D%02d", nextId++);
        } else {
            this.departmentId = null;
            this.departmentName = null;
        }
    }

    /**
     * checks if a department name is valid (contains only letters and spaces)
     * @param departmentName the department name
     * @return if the department name is valid
     */
    private static boolean isDepartmentNameValid(String departmentName) {
        if (departmentName == null || departmentName.isBlank()) {
            return false;
        }
        char[] chars = departmentName.toCharArray();

        for (char c : chars) {
            if (Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

}
