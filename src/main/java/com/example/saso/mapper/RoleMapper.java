package com.example.saso.mapper;

import com.example.saso.entity.Role;
import com.example.saso.entity.RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    long countByExample(RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    int deleteByExample(RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    int insert(Role row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    int insertSelective(Role row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    List<Role> selectByExample(RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    Role selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    int updateByExampleSelective(@Param("row") Role row, @Param("example") RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    int updateByExample(@Param("row") Role row, @Param("example") RoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    int updateByPrimaryKeySelective(Role row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    int updateByPrimaryKey(Role row);
}