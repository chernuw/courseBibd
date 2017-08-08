package com.chernuw.service.interfaces;


import com.chernuw.model.FootwearType;

import java.util.List;


public interface FootwearTypeService {

    FootwearType getFootwearTypeById(int id);
    List<FootwearType> getAllFootwearTypes();

}
