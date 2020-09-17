package com.zkane.springdata.entity;

/**
 * @author 29204
 * @Date 2020-09-17 10:48
 */
public class Department {

    /**
     * 部门编号
     */
    private Integer id;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * Gets the value of id
     *
     * @return the value of id (Integer)
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id
     * <p>You can use getId() to get the value of id</p>
     *
     * @param id (java.lang.Integer)
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Sets the departmentName
     * <p>You can use getDepartmentName() to get the value of departmentName</p>
     *
     * @param departmentName (java.lang.String)
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * Gets the value of departmentName
     *
     * @return the value of departmentName (String)
     */
    public String getDepartmentName() {
        return departmentName;
    }

    public Department() {
    }

    public Department(Integer id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }

}
