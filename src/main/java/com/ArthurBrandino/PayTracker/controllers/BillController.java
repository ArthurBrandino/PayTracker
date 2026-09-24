package com.ArthurBrandino.PayTracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PatchExchange;

import com.ArthurBrandino.PayTracker.model.Bill;
import com.ArthurBrandino.PayTracker.model.BillStatus;
import com.ArthurBrandino.PayTracker.services.BillService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/bills")
public class BillController {

    @Autowired
    private BillService service;

    //---------------- GETS -------------------------------

    @GetMapping(value = "/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Bill> findById(@PathVariable ("id") Long id){
        return service.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Bill> findBill(
        @RequestParam(required = false) String description,
        @RequestParam(required = false) String category,
        @RequestParam(required = false) BillStatus status){

        return service.findBills(description, category, status);
    }


    /*O Usuario não consegue requisitar o POST e O PUT
    - POST: a Conta será criada quando a api verificar que uma conta foi criada no sistema  (exemplo: Sabesp gerou a conta de agua do mês)
    - PUT: A Api so irá alterar a Data de Pagamento e o Status da conta
    */
    //---------------- POST -------------------

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public Bill create(@RequestBody Bill bill){
        return service.create(bill);
    }

    //---------------- PUT --------------------

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Bill update(@RequestBody Bill bill){
        return service.update(bill);
    }

    //-------------- DELETE -------------------

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
