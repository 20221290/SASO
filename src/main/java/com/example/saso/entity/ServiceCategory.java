package com.example.saso.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ServiceCategory implements Serializable {
    private List<ServiceCategory> children;
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column service_category.id
     *
     *
     * -- GETTER --
     *  This method was generated by MyBatis Generator.
     *  This method returns the value of the database column service_category.id
     *
     @mbg.generated Mon Jul 22 15:28:55 CST 2024
      * @return the value of service_category.id
      *
      *
     * -- SETTER --
     *  This method was generated by MyBatis Generator.
     *  This method sets the value of the database column service_category.id
     *
     * @param id the value for service_category.id
     *
     *

     */
    @Setter
    @Getter
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column service_category.parent_id
     *
     *
     * -- GETTER --
     *  This method was generated by MyBatis Generator.
     *  This method returns the value of the database column service_category.parent_id
     *
     @mbg.generated Mon Jul 22 15:28:55 CST 2024
      * @return the value of service_category.parent_id
      *
      *
     * -- SETTER --
     *  This method was generated by MyBatis Generator.
     *  This method sets the value of the database column service_category.parent_id
     *
     * @param parentId the value for service_category.parent_id
     *
     *

     */
    @Setter
    @Getter
    private Integer parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column service_category.name
     *
     *
     * -- SETTER --
     *  This method was generated by MyBatis Generator.
     *  This method sets the value of the database column service_category.name
     *
     @mbg.generated Mon Jul 22 15:28:55 CST 2024
      * @param name the value for service_category.name
      *
      *
     * -- GETTER --
     *  This method was generated by MyBatis Generator.
     *  This method returns the value of the database column service_category.name
     *
     * @return the value of service_category.name
     *
     *

     */
    @Getter
    @Setter
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column service_category.level
     *
     *
     * -- SETTER --
     *  This method was generated by MyBatis Generator.
     *  This method sets the value of the database column service_category.level
     *
     @mbg.generated Mon Jul 22 15:28:55 CST 2024
      * @param level the value for service_category.level
      *
      *
     * -- GETTER --
     *  This method was generated by MyBatis Generator.
     *  This method returns the value of the database column service_category.level
     *
     * @return the value of service_category.level
     *

     */
    @Getter
    @Setter
    private Integer level;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column service_category.create_time
     *
     *
     * -- GETTER --
     *  This method was generated by MyBatis Generator.
     *  This method returns the value of the database column service_category.create_time
     *
     @mbg.generated Mon Jul 22 15:28:55 CST 2024
      * @return the value of service_category.create_time
      *
      *
     * -- SETTER --
     *  This method was generated by MyBatis Generator.
     *  This method sets the value of the database column service_category.create_time
     *
     * @param createTime the value for service_category.create_time
     *
     *

     */
    @Setter
    @Getter
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column service_category.create_user
     *
     *
     * -- GETTER --
     *  This method was generated by MyBatis Generator.
     *  This method returns the value of the database column service_category.create_user
     *
     @mbg.generated Mon Jul 22 15:28:55 CST 2024
      * @return the value of service_category.create_user
      *
      *
     * -- SETTER --
     *  This method was generated by MyBatis Generator.
     *  This method sets the value of the database column service_category.create_user
     *
     * @param createUser the value for service_category.create_user
     *
     *

     */
    @Setter
    @Getter
    private String createUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column service_category.update_time
     *
     *
     * -- GETTER --
     *  This method was generated by MyBatis Generator.
     *  This method returns the value of the database column service_category.update_time
     *
     @mbg.generated Mon Jul 22 15:28:55 CST 2024
      * @return the value of service_category.update_time
      *
      *
     * -- SETTER --
     *  This method was generated by MyBatis Generator.
     *  This method sets the value of the database column service_category.update_time
     *
     * @param updateTime the value for service_category.update_time
     *
     *

     */
    @Setter
    @Getter
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column service_category.update_user
     *
     *
     * -- GETTER --
     *  This method was generated by MyBatis Generator.
     *  This method returns the value of the database column service_category.update_user
     *
     @mbg.generated Mon Jul 22 15:28:55 CST 2024
      * @return the value of service_category.update_user
      *
      *
     * -- SETTER --
     *  This method was generated by MyBatis Generator.
     *  This method sets the value of the database column service_category.update_user
     *
     * @param updateUser the value for service_category.update_user
     *
     *

     */
    @Setter
    @Getter
    private String updateUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table service_category
     *
     * @mbg.generated Mon Jul 22 15:28:55 CST 2024
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table service_category
     *
     * @mbg.generated Mon Jul 22 15:28:55 CST 2024
     */
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(getClass().getSimpleName());
//        sb.append(" [");
//        sb.append("Hash = ").append(hashCode());
//        sb.append(", id=").append(id);
//        sb.append(", parentId=").append(parentId);
//        sb.append(", name=").append(name);
//        sb.append(", level=").append(level);
//        sb.append(", createTime=").append(createTime);
//        sb.append(", createUser=").append(createUser);
//        sb.append(", updateTime=").append(updateTime);
//        sb.append(", updateUser=").append(updateUser);
//        sb.append(", serialVersionUID=").append(serialVersionUID);
//        sb.append("]");
//        return sb.toString();
//    }
}