package com.ArthurBrandino.PayTracker.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ArthurBrandino.PayTracker.model.Bill;
import com.ArthurBrandino.PayTracker.model.BillStatus;
import com.ArthurBrandino.PayTracker.repository.BillRepository;

@Service
public class BillService {

    private Logger logger = Logger.getLogger(BillService.class.getName());

    @Autowired
    private BillRepository repository;

    //--------------- GETS -----------------------
    public List<Bill> findById(Long id){
        logger.info("Finding Bill By Id");

        return repository.findById(id).orElseThrow(() -> ResouceNotFoundException("No record found for this ID"));
    }

    //Procura com base nos filtros: descrição, categoria e status, caso todos sejam falso retorna todas contas
    public List<Bill> findBills(String description, String category, BillStatus status){
        logger.info("Finding Bills");
        return repository.findByFilters(description, category, status);
        
    }

    // -------------- POST ----------------
    public Bill create(Bill bill){
        logger.info("Creating a Bill");
        return repository.save(bill);
    }

    // --------------PUT--------------------
    public Bill update(Bill bill){
        logger.info("Updating a Bill");
    //Arrumar Aqui!


        return repository.save(bill);
    }
}
