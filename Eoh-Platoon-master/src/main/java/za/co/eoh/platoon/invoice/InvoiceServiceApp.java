/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.eoh.platoon.invoice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import za.co.eoh.platoon.invoice.dao.InvoiceDao;
import za.co.eoh.platoon.invoice.entity.Invoice;

/**
 *
 * @author ABMC684
 */
@SpringBootApplication
@ComponentScan(basePackages = {"za.co.eoh.platoon"})
public class InvoiceServiceApp implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private InvoiceDao invoiceDao;

    public static void main(String... args) {
        SpringApplication.run(InvoiceServiceApp.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        logger.info("---------------------Some minor testing------------------");
        Invoice invoice = invoiceDao.findById(10001L);
        logger.info("Invoice findById 10001 -> {}", invoice.getId());
        logger.info("Invoice Client name -> {}", invoice.getClient());
        logger.info("---------------------Some minor testing end------------------");

    }

}
