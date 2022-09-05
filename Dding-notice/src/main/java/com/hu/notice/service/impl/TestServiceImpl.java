package com.hu.notice.service.impl;

import com.hu.notice.common.RetData;
import com.hu.notice.service.ITestService;
import com.hu.notice.vo.LoginVo;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements ITestService {


    @Override
    public RetData login(String username, String password) {
        String a[] = new String[]{"a","b"};
        String bb = a[3];
        return new RetData().ok(bb);
    }

    @Override
    public RetData login(LoginVo loginVo) {
        int i = 1/0;
        return new RetData().ok();
    }
}
