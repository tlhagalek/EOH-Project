/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.eoh.platoon.invoice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import za.co.eoh.platoon.invoice.entity.Invoice;

/**
 *
 * @author ABMC684
 */
@Repository("invoiceDao")
public class InvoiceDaoImpl implements InvoiceDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Invoice save(Invoice invoice) {
        jdbcTemplate.update("insert into invoice (id, client, vatrate,invoicedate) " + "values(?,  ?, ?,?)",
                new Object[]{invoice.getId(), invoice.getClient(), invoice.getVatRate(), invoice.getInvoiceDate()});

        return invoice;
    }

    @Override
    public List<Invoice> findAll() {
        return jdbcTemplate.query("select * from invoice", new InvoiceRowMapper());
    }

    @Override
    public Invoice findById(long id) {
        return jdbcTemplate.queryForObject("select * from invoice where id=?", new Object[]{id},
                new BeanPropertyRowMapper<Invoice>(Invoice.class));
    }

    class InvoiceRowMapper implements RowMapper<Invoice> {

        @Override
        public Invoice mapRow(ResultSet rs, int rowNum) throws SQLException {
            Invoice invoice = new Invoice();
            invoice.setId(rs.getLong("id"));
            invoice.setClient(rs.getString("client"));
            invoice.setVatRate(rs.getLong("vatrate"));
            invoice.setInvoiceDate(rs.getDate("invoiceDate"));
            return invoice;
        }
    }
}
