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
    public int add(Userinfo user) {
        //先检查此用户信息中的手机号码是否被使用
        int rows = userDao.findByMobile(user.getMobile());
        if( rows > 0 ){
            return 10001;
        }
        int count = 0;

        try {
             count = userDao.add(user);
        }catch (Exception e){
            return 30001;
        }
        return count > 0 ? 0 : 30001;
    }


}
