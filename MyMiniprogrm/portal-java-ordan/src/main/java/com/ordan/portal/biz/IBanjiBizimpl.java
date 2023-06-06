package com.ordan.portal.biz;

import com.ordan.portal.dao.IBanjiDao;
import com.ordan.portal.entity.Banjiinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IBanjiBizimpl implements IBanjiBiz{

   @Autowired
   private IBanjiDao banjiDao;

    @Override
    public List<Banjiinfo> findBySid(int sid) {
        return banjiDao.findBySid(sid);
    }
}
