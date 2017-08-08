package com.chernuw.service.interfaces;


import com.chernuw.model.Color;
import com.chernuw.model.Material;

import java.util.List;


public interface MaterialService {

    Material getMaterialById(int id);
    List<Material> getAllMaterials();

}
