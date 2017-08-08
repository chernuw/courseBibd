package com.chernuw.service.interfaces;


import com.chernuw.model.Color;
import com.chernuw.model.Provider;

import java.util.List;


public interface ProviderService {

    Provider getProviderById(int id);
    List<Provider> getAllProviders();

}
