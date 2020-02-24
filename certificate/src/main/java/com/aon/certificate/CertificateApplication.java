package com.aon.certificate;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aon.certificate.dao.CertificateDbRepository;
import com.aon.certificate.model.CertQuery;
import com.aon.certificate.model.Certificate;

import static java.lang.System.exit;

@SpringBootApplication
public class CertificateApplication implements CommandLineRunner {

    @Autowired
    DataSource dataSource;
    
    @Autowired
    CertificateDbRepository repository;
    
	public static void main(String[] args) throws Exception {
		SpringApplication.run(CertificateApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

        System.out.println("DATASOURCE = " + dataSource);
        
		for (String l : args) {
	        for (CertQuery cq : repository.findCertificateQuery(Long.valueOf(l))) {
	        	
	            System.out.println("Display certs query ...\n" + cq);
	    			
		        List<Certificate> list = repository.findCertificateAll(cq);
		        
		        System.out.println("No of certs: " + list.size());
		        
		        list.forEach(x -> System.out.println(x + "\n"));

	    	}
		}

        System.out.println("Done!");

        exit(0);
    }
}
