package com.example.saso.mapper;

import com.example.saso.entity.Permission;
import com.example.saso.entity.PermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    long countByExample(PermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    int deleteByExample(PermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    int insert(Permission row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    int insertSelective(Permission row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    List<Permission> selectByExample(PermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    Permission selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    int updateByExampleSelective(@Param("row") Permission row, @Param("example") PermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    int updateByExample(@Param("row") Permission row, @Param("example") PermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    int updateByPrimaryKeySelective(Permission row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table permission
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    int updateByPrimaryKey(Permission row);
}