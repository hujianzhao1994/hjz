package com.hu.notice.service;

import com.hu.notice.common.RetData;
import com.hu.notice.vo.LoginVo;

public interface ITestService {

    RetData login(String username, String password);

    RetData login(LoginVo loginVo);
}
