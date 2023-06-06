package com.ordan.portal.biz;


import com.ordan.portal.entity.Banjiinfo;

import java.util.List;

public interface IBanjiBiz {

    List<Banjiinfo> findBySid(int sid);

}
