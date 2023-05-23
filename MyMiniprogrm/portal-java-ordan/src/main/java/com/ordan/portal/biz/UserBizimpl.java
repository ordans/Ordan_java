package com.ordan.portal.biz;

import com.ordan.portal.dao.IUserDao;
import com.ordan.portal.entity.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBizimpl implements IUserBiz{
    @Autowired
    private IUserDao userDao;

    @Override
    public boolean add(Userinfo user) {
        int count = userDao.add(user);
        return count > 0;
    }
}
