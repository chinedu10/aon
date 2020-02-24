package com.aon.certificate.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Certificate {

	private long i_cert_id;
	private String i_named_insured_id;
	private String v_named_insured_name;
	private String i_address_id;
	private String i_set_id;
	private String v_set_description;
	private String activeCertSetYN;
	private String v_description;
	private String v_sort_name;
	private String v_special_conditions;
	private String v_job_loc_proj;
	private String i_override_named_insured_id;
	private String i_cert_holder_id;
	private String v_cert_holder_name;
	private String hol_addr1;
	private String hol_addr2;
	private String hol_addr3;
	private String hol_addr4;
	private String hol_city;
	private String hol_country;
	private String ACORD_Form_Name;
	private String ni_addr1;
	private String ni_addr2;
	private String ni_addr3;
	private String ni_addr4; 
	private String ni_city;
	private String ni_country;
	private Date d_last_print_date;
	private String i_form_id;

	public Certificate(long int1, String string1, String string2, String string3, String string4, String string5, String string6,
			String string7, String string8, String string9, String string10, String string11, String string12,
			String string13, String string14, String string15, String string16, String string17, String string18,
			String string19, String string20, String string21, String string22, String string23, String string24,
			String string25, String string26, Date date, String string27) {
		
		i_cert_id = int1;
		i_named_insured_id = string1;
		v_named_insured_name = string2;
		i_address_id = string3;
		i_set_id = string4;
		v_set_description = string5;
		activeCertSetYN = string6;
		v_description = string7;
		v_sort_name = string8;
		v_special_conditions = string9;
		v_job_loc_proj = string10;
		i_override_named_insured_id = string11;
		i_cert_holder_id = string12;
		v_cert_holder_name = string13;
		hol_addr1 = string14;
		hol_addr2 = string15;
		hol_addr3 = string16;
		hol_addr4 = string17;
		hol_city = string18;
		hol_country = string19;
		ACORD_Form_Name = string20;
		ni_addr1 = string21;
		ni_addr2 = string22;
		ni_addr3 = string23;
		ni_addr4 = string24;
		ni_city = string25;
		ni_country = string26;
		d_last_print_date = date;
		i_form_id = string27;
	}

	public long getI_cert_id() {
		return i_cert_id;
	}

	public void setI_cert_id(long i_cert_id) {
		this.i_cert_id = i_cert_id;
	}

	public String getI_named_insured_id() {
		return i_named_insured_id;
	}

	public void setI_named_insured_id(String i_named_insured_id) {
		this.i_named_insured_id = i_named_insured_id;
	}

	public String getV_named_insured_name() {
		return v_named_insured_name;
	}

	public void setV_named_insured_name(String v_named_insured_name) {
		this.v_named_insured_name = v_named_insured_name;
	}

	public String getI_address_id() {
		return i_address_id;
	}

	public void setI_address_id(String i_address_id) {
		this.i_address_id = i_address_id;
	}

	public String getI_set_id() {
		return i_set_id;
	}

	public void setI_set_id(String i_set_id) {
		this.i_set_id = i_set_id;
	}

	public String getV_set_description() {
		return v_set_description;
	}

	public void setV_set_description(String v_set_description) {
		this.v_set_description = v_set_description;
	}

	public String getActiveCertSetYN() {
		return activeCertSetYN;
	}

	public void setActiveCertSetYN(String activeCertSetYN) {
		this.activeCertSetYN = activeCertSetYN;
	}

	public String getV_description() {
		return v_description;
	}

	public void setV_description(String v_description) {
		this.v_description = v_description;
	}

	public String getV_sort_name() {
		return v_sort_name;
	}

	public void setV_sort_name(String v_sort_name) {
		this.v_sort_name = v_sort_name;
	}

	public String getV_special_conditions() {
		return v_special_conditions;
	}

	public void setV_special_conditions(String v_special_conditions) {
		this.v_special_conditions = v_special_conditions;
	}

	public String getV_job_loc_proj() {
		return v_job_loc_proj;
	}

	public void setV_job_loc_proj(String v_job_loc_proj) {
		this.v_job_loc_proj = v_job_loc_proj;
	}

	public String getI_override_named_insured_id() {
		return i_override_named_insured_id;
	}

	public void setI_override_named_insured_id(String i_override_named_insured_id) {
		this.i_override_named_insured_id = i_override_named_insured_id;
	}

	public String getI_cert_holder_id() {
		return i_cert_holder_id;
	}

	public void setI_cert_holder_id(String i_cert_holder_id) {
		this.i_cert_holder_id = i_cert_holder_id;
	}

	public String getV_cert_holder_name() {
		return v_cert_holder_name;
	}

	public void setV_cert_holder_name(String v_cert_holder_name) {
		this.v_cert_holder_name = v_cert_holder_name;
	}

	public String getHol_addr1() {
		return hol_addr1;
	}

	public void setHol_addr1(String hol_addr1) {
		this.hol_addr1 = hol_addr1;
	}

	public String getHol_addr2() {
		return hol_addr2;
	}

	public void setHol_addr2(String hol_addr2) {
		this.hol_addr2 = hol_addr2;
	}

	public String getHol_addr3() {
		return hol_addr3;
	}

	public void setHol_addr3(String hol_addr3) {
		this.hol_addr3 = hol_addr3;
	}

	public String getHol_addr4() {
		return hol_addr4;
	}

	public void setHol_addr4(String hol_addr4) {
		this.hol_addr4 = hol_addr4;
	}

	public String getHol_city() {
		return hol_city;
	}

	public void setHol_city(String hol_city) {
		this.hol_city = hol_city;
	}

	public String getHol_country() {
		return hol_country;
	}

	public void setHol_country(String hol_country) {
		this.hol_country = hol_country;
	}

	public String getACORD_Form_Name() {
		return ACORD_Form_Name;
	}

	public void setACORD_Form_Name(String aCORD_Form_Name) {
		ACORD_Form_Name = aCORD_Form_Name;
	}

	public String getNi_addr1() {
		return ni_addr1;
	}

	public void setNi_addr1(String ni_addr1) {
		this.ni_addr1 = ni_addr1;
	}

	public String getNi_addr2() {
		return ni_addr2;
	}

	public void setNi_addr2(String ni_addr2) {
		this.ni_addr2 = ni_addr2;
	}

	public String getNi_addr3() {
		return ni_addr3;
	}

	public void setNi_addr3(String ni_addr3) {
		this.ni_addr3 = ni_addr3;
	}

	public String getNi_addr4() {
		return ni_addr4;
	}

	public void setNi_addr4(String ni_addr4) {
		this.ni_addr4 = ni_addr4;
	}

	public String getNi_city() {
		return ni_city;
	}

	public void setNi_city(String ni_city) {
		this.ni_city = ni_city;
	}

	public String getNi_country() {
		return ni_country;
	}

	public void setNi_country(String ni_country) {
		this.ni_country = ni_country;
	}

	public Date getD_last_print_date() {
		return d_last_print_date;
	}

	public void setD_last_print_date(Date d_last_print_date) {
		this.d_last_print_date = d_last_print_date;
	}

	public String getI_form_id() {
		return i_form_id;
	}

	public void setI_form_id(String i_form_id) {
		this.i_form_id = i_form_id;
	}
	
	@Override
	public String toString() {
		return "Certificate [i_cert_id=" + i_cert_id + ", i_named_insured_id=" + i_named_insured_id + ", v_named_insured_name="
				+ v_named_insured_name + ", i_address_id=" + i_address_id + ", i_set_id=" + i_set_id
				+ ", v_set_description=" + v_set_description + ", activeCertSetYN=" + activeCertSetYN
				+ ", v_description=" + v_description + ", v_sort_name=" + v_sort_name + ", v_special_conditions="
				+ v_special_conditions + ", v_job_loc_proj=" + v_job_loc_proj + ", i_override_named_insured_id="
				+ i_override_named_insured_id + ", i_cert_holder_id=" + i_cert_holder_id + ", v_cert_holder_name="
				+ v_cert_holder_name + ", hol_addr1=" + hol_addr1 + ", hol_addr2=" + hol_addr2 + ", hol_addr3="
				+ hol_addr3 + ", hol_addr4=" + hol_addr4 + ", hol_city=" + hol_city + ", hol_country=" + hol_country
				+ ", ACORD_Form_Name=" + ACORD_Form_Name + ", ni_addr1=" + ni_addr1 + ", ni_addr2=" + ni_addr2
				+ ", ni_addr3=" + ni_addr3 + ", ni_addr4=" + ni_addr4 + ", ni_city=" + ni_city + ", ni_country="
				+ ni_country + ", d_last_print_date=" + d_last_print_date + ", i_form_id=" + i_form_id + "]";
	}
}
