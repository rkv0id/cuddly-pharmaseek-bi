package com.dminers.pharmabi.external.services.impl;

import com.dminers.pharmabi.external.domain.Drug;
import com.dminers.pharmabi.external.repositories.DrugRepository;
import com.dminers.pharmabi.external.services.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DrugServiceImpl implements DrugService {

    private DrugRepository drugRepository;

    @Autowired
    public DrugServiceImpl(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }

    @Override
    public List<Drug> listAll() {
        List<Drug> drugs = new ArrayList<>();
        drugRepository.findAll().forEach(drugs::add);
        return drugs;
    }

    @Override
    public Drug getByid(Long id) {
        Optional<Drug> opt_drug = drugRepository.findFirstById(id);
        return opt_drug.orElse(null);
    }

    @Override
    public void delete(Long ig) {
        drugRepository.deleteById(ig);
    }

}
