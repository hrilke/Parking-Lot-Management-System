package Model;

import Model.ENUM.StaffSkill;

public class Staff {
    private static int employeeId;
    private String name;
    private StaffSkill skill;

    public Staff(String name, StaffSkill skill) {
        this.name = name;
        this.skill = skill;
    }

    public static int getEmployeeId() {
        return employeeId;
    }

    public static void setEmployeeId(int employeeId) {
        Staff.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StaffSkill getSkill() {
        return skill;
    }

    public void setSkill(StaffSkill skill) {
        this.skill = skill;
    }
}
