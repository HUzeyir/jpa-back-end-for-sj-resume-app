package com.mycompany.daoInter;

import com.mycompany.entity.UserDetail;
import java.util.List;

public interface UserDetailDaoInter {

    List<UserDetail> getAllUserDetail();

    UserDetail addUserDetail(UserDetail udetail);

    UserDetail findUserDetail(Integer id);

    UserDetail updateUserDetail(UserDetail udetail);

    UserDetail removeUserDetail(UserDetail udetail);

}
