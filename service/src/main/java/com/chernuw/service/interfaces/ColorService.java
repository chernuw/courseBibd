package com.chernuw.service.interfaces;


import com.chernuw.model.Color;
import com.chernuw.model.FootwearType;

import java.util.List;


public interface ColorService {

    Color getColorById(int id);
    List<Color> getAllColors();

}
