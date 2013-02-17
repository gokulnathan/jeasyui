package com.spring.service;

import org.springframework.stereotype.Service;

/**
 *接口A的实现类
 */
@Service
public class AServiceImpl implements AService {

    public void barA() {
        System.out.println("AServiceImpl.barA()");
    }

    public void fooA(String _msg) {
        System.out.println("AServiceImpl.fooA(msg:"+_msg+")");
    }
}