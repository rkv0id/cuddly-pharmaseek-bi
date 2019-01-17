package com.dminers.pharmabi.external.services;

import com.dminers.pharmabi.external.domain.Drug;

import java.util.List;

public interface DrugService {

    List<Drug> listAll();
    Drug getByid(Long id);
    void delete(Long ig);

}
