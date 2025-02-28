package com.example.saso.entity;

import java.io.Serializable;

public class Permission implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.id
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.permission_code
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    private String permissionCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column permission.permission_name
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    private String permissionName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table permission
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.id
     *
     * @return the value of permission.id
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.id
     *
     * @param id the value for permission.id
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.permission_code
     *
     * @return the value of permission.permission_code
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    public String getPermissionCode() {
        return permissionCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.permission_code
     *
     * @param permissionCode the value for permission.permission_code
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.permission_name
     *
     * @return the value of permission.permission_name
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    public String getPermissionName() {
        return permissionName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.permission_name
     *
     * @param permissionName the value for permission.permission_name
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", permissionCode=").append(permissionCode);
        sb.append(", permissionName=").append(permissionName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}