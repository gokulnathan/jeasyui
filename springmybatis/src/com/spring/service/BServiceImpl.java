package com.spring.service;

import org.springframework.stereotype.Service;

/**
 *   Service¿‡B
 */
@Service
public class BServiceImpl {

    public void barB(String _msg, int _type) {
        System.out.println("BServiceImpl.barB(msg:"+_msg+" type:"+_type+")");
        if(_type == 1)
            throw new IllegalArgumentException("≤‚ ‘“Ï≥£");
    }

    public void fooB() {
        System.out.println("BServiceImpl.fooB()");
    }

}