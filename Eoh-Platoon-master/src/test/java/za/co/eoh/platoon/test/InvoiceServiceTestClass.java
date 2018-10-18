/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.eoh.platoon.test;

import java.sql.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.*;
import org.springframework.boot.test.context.SpringBootTest; 
import za.co.eoh.platoon.invoice.controller.InvoiceController;
import za.co.eoh.platoon.invoice.dao.InvoiceDao;
import za.co.eoh.platoon.invoice.entity.Invoice;

/**
 *
 * @author ABMC684
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = InvoiceController.class, secure = false)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InvoiceServiceTestClass {

    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private Invoice invoice;

    @Test
    public void addInvoice() {

    }

    @Test
    public void getInvoiceById() throws Exception {

        java.util.Date now = new java.util.Date();

        Invoice invoice = new Invoice();
        invoice.setClient("John Mikes");
        invoice.setVatRate(3L);
        invoice.setInvoiceDate(new Date(now.getTime()));
        invoiceDao.save(invoice);

        given(invoiceDao.findById(1L)).willReturn(invoice);
        mvc.perform(get("/invoices/1").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.client", is("John Mikes")))
                .andExpect(jsonPath("$.vatRate", is(3)));

        System.out.println("sssssssssssssssssss");
    }

    @Test
    public void viewAllInvoices() throws Exception {
      

    }

}
