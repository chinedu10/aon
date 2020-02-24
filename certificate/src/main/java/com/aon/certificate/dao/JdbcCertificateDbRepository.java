package com.aon.certificate.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.aon.certificate.model.CertQuery;
import com.aon.certificate.model.Certificate;

@Repository
public class JdbcCertificateDbRepository implements CertificateDbRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<CertQuery> findCertificateQuery(long client_account_id) {
    	
        List<CertQuery> result = jdbcTemplate.query(
        		"SELECT"
        		+ "    certst.i_cert_id,"
        		+ "    certst.i_set_id,"
        		+ "    crtset.v_set_description,"
        		+ "    crtset.v_aiflag certsetactiveYN,"
        		+ "    crtset.i_client_account_id,"
        		+ "    namins.v_named_insured_name,"
        		+ "    certst.i_form_id,"
        		+ "    niaddmst.v_city,"
        		+ "    crtsch.v_sort_name,"
        		+ "    crtsch.v_job_loc_proj,"
        		+ "    certst.d_print_date"
        		+ "FROM"
        		+ "    certst,"
        		+ "    crtset,"
        		+ "    crtsch,"
        		+ "    namins,"
        		+ "    addmst niaddmst"
        		+ "WHERE"
        		+ "    crtset.i_set_id = certst.i_set_id"
        		+ "    AND certst.i_override_id = crtsch.i_override_id"
        		+ "    AND nvl(certst.i_override_named_insured_id, crtset.i_named_insured_id) = namins.i_named_insured_id -- Handled for override NI"
        		+ "    AND namins.i_address_id = niaddmst.i_address_id"
        		+ "    AND crtset.i_client_account_id = ?"
        		+ "    AND trunc(certst.d_print_date) BETWEEN TO_DATE('01/07/2019', 'DD/MM/YYYY') AND TO_DATE('31/01/2020', 'DD/MM/YYYY')"
        		+ "    AND ROWNUM <= 50"
        		+ "    AND (CASE WHEN (SELECT MOD(DBMS_RANDOM.RANDOM(), (crtset.i_set_id/crtset.i_set_id)+1) FROM DUAL) = 0 THEN 'Y' ELSE 'N' END) = 'Y';",
                new Object[]{client_account_id},
                (rs, rowNum) -> new CertQuery(
                		rs.getLong("i_cert_id"), rs.getLong("i_set_id"), rs.getString("v_set_description"),
                		rs.getLong("i_client_account_id"), rs.getString("v_named_insured_name"), rs.getString("i_form_id"), 
                		rs.getString("v_city"), rs.getString("v_sort_name"), rs.getString("v_job_loc_proj"), rs.getDate("d_print_date"))
        );

        return result;
    }
    
	// custom RowMapper
    public List<Certificate> findCertificateAll(CertQuery certQuery) {
    		  
        List<Certificate> result = jdbcTemplate.query(
            "SELECT * FROM ("
        		+ "SELECT  "
            	+ "      certst.i_cert_id, namins.i_named_insured_id, namins.v_named_insured_name,"
            	+ "      namins.i_address_id, crtset.i_set_id, crtset.v_set_description, crtset.v_aiflag activeCertSetYN,"
            	+ "      crtsch.v_description, crtsch.v_sort_name, crtsch.v_special_conditions, crtsch.v_job_loc_proj,"
            	+ "      certst.i_override_named_insured_id, certst.i_cert_holder_id, crthol.v_cert_holder_name,"
            	+ "      crthol.v_address_line_1 hol_addr1, crthol.v_address_line_2 hol_addr2, crthol.v_address_line_3 hol_addr3, "
            	+ "      crthol.v_address_line_4 hol_addr4, crthol.v_city hol_city, crthol.v_country_code hol_country,"
            	+ "      frmtyp.v_short_description ACORD_Form_Name, niaddmst.v_address_line_1 ni_addr1, niaddmst.v_address_line_2 ni_addr2, "
            	+ "      niaddmst.v_address_line_3 ni_addr3, niaddmst.v_address_line_4 ni_addr4, niaddmst.v_city ni_city, "
            	+ "      niaddmst.v_country_code ni_country, certst.d_last_print_date, certst.i_form_id "
            	+ "FROM "
            	+ "      certst, crtsch, " //--Override table
                + "		 crtset, crthol, "
                + "		 namins, addmst niaddmst, frmtyp "
                + "WHERE "
                + "		 certst.i_set_id = crtset.i_set_id"
                + "      AND certst.i_cert_holder_id = crthol.i_cert_holder_id "
                + "      AND certst.i_override_id = crtsch.i_override_id"
                + "      AND NVL(certst.i_override_named_insured_id, crtset.i_named_insured_id) = namins.i_named_insured_id" // -- Handled for override NI"
                + "      AND namins.i_address_id = niaddmst.i_address_id"
                + "      AND certst.i_form_id = frmtyp.i_form_id"
                + "      AND crtset.i_client_account_id = ? "  // integer
                + "      AND namins.v_named_insured_name = ? "  // v single quote string
                + "      AND certst.i_form_id = ? "				// integer
                + "      AND niaddmst.v_city = NVL(?, niaddmst.v_city) "	// varchar single quote
                + "      AND crtsch.v_sort_name = NVL(?,  crtsch.v_sort_name) " 	// varchar single quote
                + "      AND crtsch.v_job_loc_proj = NVL(?, crtsch.v_job_loc_proj)"   // varchar single quote
                + " 	 AND certst.d_last_print_date >= SYSDATE-365 "
//                + " 	 AND ROWNUM < 6 "
                + " 	 ORDER BY D_LAST_PRINT_DATE DESC) " 
             + " WHERE ROWNUM < 6",
                new Object[]{certQuery.getClient_account_id(), certQuery.getNamed_insured_name(), certQuery.getForm_id(), certQuery.getCity(), certQuery.getSort_name(), certQuery.getJob_loc_proj()},
                (rs, rowNum) -> new Certificate(
                		rs.getLong("i_cert_id"), rs.getString("i_named_insured_id"), rs.getString("v_named_insured_name"),
                		rs.getString("i_address_id"), rs.getString("i_set_id"), rs.getString("v_set_description"), rs.getString("activeCertSetYN"),
                		rs.getString("v_description"), rs.getString("v_sort_name"), rs.getString("v_special_conditions"), rs.getString("v_job_loc_proj"),
                		rs.getString("i_override_named_insured_id"), rs.getString("i_cert_holder_id"), rs.getString("v_cert_holder_name"),
                		rs.getString("hol_addr1"), rs.getString("hol_addr2"), rs.getString("hol_addr3"),
                    	rs.getString("hol_addr4"), rs.getString("hol_city"), rs.getString("hol_country"),
                    	rs.getString("ACORD_Form_Name"), rs.getString("ni_addr1"), rs.getString("ni_addr2"),
                    	rs.getString("ni_addr3"), rs.getString("ni_addr4"), rs.getString("ni_city"),
                    	rs.getString("ni_country"), rs.getDate("d_last_print_date"), rs.getString("i_form_id")
                		)
        );

        return result;

    }
    

}