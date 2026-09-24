package com.ArthurBrandino.PayTracker.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Nome: Sabesp - Água
    @Column(name = "description", nullable = false, length = 30)
    private String description;

    //Categoria: Contas Fixas / Compras / Entreterimento
    @Column(name = "category", nullable = false, length = 30)
    private String category;

    // Valor R$:00,00
    @Column(name = "value", nullable = false)
    private Double value;

    //Data de Vencimento
    @Column(name = "dueDate", nullable = false)
    private LocalDate due_date;

    //Data que foi Paga
    @Column(name = "paymentDate")
    private LocalDate payment_date;

    //Código de Barras
    @Column(name = "barcode", nullable = false, length = 100)
    private String barcode;

    //Chave Pix
    @Column(name = "pixKey", length = 100)
    private String pixKey;
    
    //Status: Pago / Pendente / Vencida
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private BillStatus status = BillStatus.PENDING;


    // ------------------------------------- Getters e Setters -----------------------------------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDate getDueDate() {
        return due_date;
    }

    public void setDueDate(LocalDate due_date) {
        this.due_date = due_date;
    }

    public LocalDate getPaymentDate() {
        return payment_date;
    }

    public void setPaymentDate(LocalDate payment_date) {
        this.payment_date = payment_date;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getPixKey() {
        return pixKey;
    }

    public void setPixKey(String pixKey) {
        this.pixKey = pixKey;
    }

    public BillStatus getStatus() {
        return status;
    }

    public void setStatus(BillStatus status) {
        this.status = status;
    }


    // ------------------------ HashCode e Equal do ID --------------------------------------------
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Bill other = (Bill) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
