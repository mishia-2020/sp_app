package core.infrastructure.model.mrs;

/**
 * Table: mrs.employee
 */
public class Employee {
    /**
     * Column: tenant_id
     */
    private String tenantId;

    /**
     * Column: employee_id
     */
    private String employeeId;

    /**
     * Column: first_name
     */
    private String firstName;

    /**
     * Column: last_name
     */
    private String lastName;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId == null ? null : employeeId.trim();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? null : firstName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
    }
}