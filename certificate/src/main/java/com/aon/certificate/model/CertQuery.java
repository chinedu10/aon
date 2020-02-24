package com.aon.certificate.model;

import java.sql.Date;

import lombok.Data;

@Data
public class CertQuery {

	private long cert_id;
	private long set_id;
	private String set_description;
	private long client_account_id;
	private String named_insured_name;
	private String form_id;
	private String city;
	private String sort_name;
	private String job_loc_proj;
	private Date print_date;
	
	public CertQuery(
			long cert_id, long set_id, String set_description,
			long client_account_id, String named_insured_name, String form_id, String city, String sort_name,
			String job_loc_proj, Date d_print_date) {
		super();
		this.cert_id = cert_id;
		this.set_id = set_id;
		this.set_description = set_description;
		this.client_account_id = client_account_id;
		this.named_insured_name = named_insured_name;
		this.form_id = form_id;
		this.city = city;
		this.sort_name = sort_name;
		this.job_loc_proj = job_loc_proj;
		this.print_date = d_print_date;
	}
	
	public long getCert_id() {
		return cert_id;
	}
	public void setCert_id(long cert_id) {
		this.cert_id = cert_id;
	}
	public long getSet_id() {
		return set_id;
	}
	public void setSet_id(long set_id) {
		this.set_id = set_id;
	}
	public String getSet_description() {
		return set_description;
	}
	public void setSet_description(String set_description) {
		this.set_description = set_description;
	}
	public long getClient_account_id() {
		return client_account_id;
	}
	public void setClient_account_id(long client_account_id) {
		this.client_account_id = client_account_id;
	}
	public String getNamed_insured_name() {
		return named_insured_name;
	}
	public void setNamed_insured_name(String named_insured_name) {
		this.named_insured_name = named_insured_name;
	}
	public String getForm_id() {
		return form_id;
	}
	public void setForm_id(String form_id) {
		this.form_id = form_id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSort_name() {
		return sort_name;
	}
	public void setSort_name(String sort_name) {
		this.sort_name = sort_name;
	}
	public String getJob_loc_proj() {
		return job_loc_proj;
	}
	public void setJob_loc_proj(String job_loc_proj) {
		this.job_loc_proj = job_loc_proj;
	}
	public Date getPrint_date() {
		return print_date;
	}
	public void setPrint_date(Date print_date) {
		this.print_date = print_date;
	}

	@Override
	public String toString() {
		return "CertQuery [client_account_id=" + client_account_id + ", named_insured_name=" + named_insured_name
				+ ", form_id=" + form_id + ", city=" + city + ", sort_name=" + sort_name + ", job_loc_proj="
				+ job_loc_proj + ", print_date=" + print_date + "]";
	}
}
