package com.ordan.portal.dao;

import com.ordan.portal.entity.Userinfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 数据访问组件:用户信息读或写操作
 * author:ordan
 * data:2023-05-23
 */
@Repository
public interface IUserDao {

    /**
     * 用户报名的业务数据存储
     * @param user
     * @return
     */
    @Insert("INSERT INTO tbl_javab_user(realname,mobile,sex,school,banji,course) " +
            "VALUES(#{realname},#{mobile},#{sex},#{school},#{banji},#{course})")
    int add(Userinfo user);

    /**
     * 根据手机号码查询用户表
     * @param mobile 匹配的手机号
     * @return int 找到的记录行数
     */
    @Select("SELECT COUNT(*) FROM tbl_javab_user WHERE mobile = #{mobile}")
    int findByMobile(String mobile);
}
