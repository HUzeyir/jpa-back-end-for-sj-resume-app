package com.mycompany.serviceImpl;

import com.mycompany.daoImpl.UserDetailDaoImple;
import com.mycompany.daoInter.UserDetailDaoInter;
import com.mycompany.entity.UserDetail;
import com.mycompany.service.UserDetailService;
import java.util.List;

public class UserDetailServiceImpl implements UserDetailService {

    private UserDetailDaoInter uddi = new UserDetailDaoImple();

    @Override
    public List<UserDetail> getAllUserDetail() {
        return uddi.getAllUserDetail();
    }

    @Override
    public UserDetail addUserDetail(UserDetail udetail) {
        return uddi.addUserDetail(udetail);
    }

    @Override
    public UserDetail findUserDetail(Integer id) {
        return uddi.findUserDetail(id);
    }

    @Override
    public UserDetail updateUserDetail(UserDetail udetail) {
        return uddi.updateUserDetail(udetail);
    }

    @Override
    public UserDetail removeUserDetail(UserDetail udetail) {
        return uddi.removeUserDetail(udetail);
    }

}
