package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Two;

public interface ITwoService {

    Two createTwo(Two insert);
    Two getTwoById(Integer id);
    List<Two> getAllTwo();
    List<Two> getAllByName(String name);

}
