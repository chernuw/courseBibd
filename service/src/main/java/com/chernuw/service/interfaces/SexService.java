package com.chernuw.service.interfaces;


import com.chernuw.model.Color;
import com.chernuw.model.Sex;

import java.util.List;


public interface SexService {

    Sex getSexById(int id);
    List<Sex> getAllSexs();

}
