/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.eoh.eoh.invoice.dao;

import java.util.List;
import za.co.eoh.eoh.entity.Invoice;


/**
 *
 * @author ABKT209
 */
public interface InvoiceDao {

    Invoice save(Invoice invoice);

    List<Invoice> findAll();

    Invoice findById(long id);
}
