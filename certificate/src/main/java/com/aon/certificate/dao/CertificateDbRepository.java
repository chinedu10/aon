package com.aon.certificate.dao;

import java.util.List;

import com.aon.certificate.model.CertQuery;
import com.aon.certificate.model.Certificate;

public interface CertificateDbRepository {
    public List<CertQuery> findCertificateQuery(long client_account_id);
	public List<Certificate> findCertificateAll(CertQuery cert);
}
