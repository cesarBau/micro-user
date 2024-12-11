package com.example.demo.service;

import com.example.demo.entity.One;

public interface IOneService {

    One getOnesById(Integer id);
    One createOne(One one);

}
