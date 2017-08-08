package com.chernuw.service.interfaces;


import com.chernuw.model.Footwear;
import org.springframework.ui.Model;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface FootwearService {

    Footwear getFootwearById(int id);
    List<Footwear> getAllFootwear(int numberOfPage, int amountOnPage);
    List<Footwear> getAllFootwear();
    List<Footwear> getFootwearsByFootwearType(int idOfFootwearType);
    List<Footwear> getFootwearsByFootwearType(int idOfFootwearType, int numberOfPage, int amountOnPage);
    List<Footwear> getFootwearsByManufacturer(int idOfManufacturer);
    List<Footwear> getFootwearsByManufacturer(int idOfManufacturer, int numberOfPage, int amountOnPage);
    List<Footwear> getFootwearsBySearch(String searchString);
    List<Footwear> getFootwearsBySearch(String searchString, int numberOfPage, int amountOnPage);
    void updateFootwear(Footwear footwear);
    void deleteFootwear(Footwear footwear);
    int saveFootwear(Footwear footwear);

}
