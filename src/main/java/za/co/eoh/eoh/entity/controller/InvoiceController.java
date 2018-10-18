/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.eoh.eoh.entity.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import za.co.eoh.eoh.entity.Invoice;
import za.co.eoh.eoh.invoice.dao.InvoiceDao;


/**
 *
 * @author ABKT209
 */
@RestController
public class InvoiceController {

    @Autowired
    private InvoiceDao invoiceDao;

    @PostMapping("/invoices")
    Invoice addInvoice(@RequestBody Invoice invoice) {
        return invoiceDao.save(invoice);
    }

    @GetMapping("/invoices")
    List<Invoice> viewAllInvoices() {
        return invoiceDao.findAll();
    }

    @GetMapping("/invoices/{id}")
    Invoice viewInvoice(@PathVariable Long id) {
        return invoiceDao.findById(id);
    }

}
