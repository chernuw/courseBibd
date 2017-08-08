package com.chernuw.service.interfaces;


import com.chernuw.model.Color;
import com.chernuw.model.Fixation;

import java.util.List;


public interface FixationService {

    Fixation getFixationById(int id);
    List<Fixation> getAllFixations();

}
