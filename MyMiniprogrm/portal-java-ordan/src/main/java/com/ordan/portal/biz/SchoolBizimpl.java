package com.ordan.portal.biz;

import com.ordan.portal.dao.ISchoolDao;
import com.ordan.portal.entity.Schoolinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolBizimpl implements ISchoolBiz{

    @Autowired
    private ISchoolDao schoolDao;


    @Override
    public List<Schoolinfo> finfAll() {
        return schoolDao.findAll();
    }
}
