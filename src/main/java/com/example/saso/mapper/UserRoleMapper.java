package com.example.saso.mapper;

import com.example.saso.entity.UserRole;
import com.example.saso.entity.UserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    long countByExample(UserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    int deleteByExample(UserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    int insert(UserRole row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    int insertSelective(UserRole row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    List<UserRole> selectByExample(UserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    UserRole selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    int updateByExampleSelective(@Param("row") UserRole row, @Param("example") UserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    int updateByExample(@Param("row") UserRole row, @Param("example") UserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    int updateByPrimaryKeySelective(UserRole row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_role
     *
     * @mbg.generated Sat Jul 20 21:03:28 CST 2024
     */
    int updateByPrimaryKey(UserRole row);
}