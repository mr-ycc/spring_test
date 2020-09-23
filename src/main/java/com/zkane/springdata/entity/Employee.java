package com.zkane.springdata.entity;

import java.io.Serializable;

/**
 * 员工实体类
 *
 * @author yuancc
 * @Date 2020-09-17 15:49
 * @Version V1.0
 */
public class Employee implements Serializable {

    static final long serialVersionUID = 42L;
    /**
     * 员工编号
     */
    private Integer id;

    /**
     * 员工姓名
     */
    private String lastName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 所属部门编号
     */
    private Integer d_id;

    /**
     * 获取id属性值
     *
     * @return id (Integer)
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id属性值
     *
     * @param id (java.lang.Integer)
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取lastName属性值
     *
     * @return lastName (String)
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 设置lastName属性值
     *
     * @param lastName (java.lang.String)
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * 获取email属性值
     *
     * @return email (String)
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置email属性值
     *
     * @param email (java.lang.String)
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取gender属性值
     *
     * @return gender (Integer)
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置gender属性值
     *
     * @param gender (java.lang.Integer)
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取d_id属性值
     *
     * @return d_id (Integer)
     */
    public Integer getD_id() {
        return d_id;
    }

    /**
     * 设置d_id属性值
     *
     * @param d_id (java.lang.Integer)
     */
    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }

    public Employee() {
    }

    public Employee(String lastName, Integer gender) {
        this.lastName = lastName;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", d_id=" + d_id +
                '}';
    }
}
