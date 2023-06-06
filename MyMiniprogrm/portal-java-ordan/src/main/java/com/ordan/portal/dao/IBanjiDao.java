package com.ordan.portal.dao;

import com.ordan.portal.entity.Banjiinfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBanjiDao {

    @Select("SELECT * FROM tbl_javab_banji WHERE sid=#{sid}")
    List<Banjiinfo> findBySid(int sid);
}
