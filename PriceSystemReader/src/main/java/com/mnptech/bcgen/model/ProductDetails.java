package com.mnptech.bcgen.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="proddetailsmaster")
public class ProductDetails {
	
	@Id
	private String id;
	
	private String prodcatid;
	
	private String productName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProdcatid() {
		return prodcatid;
	}

	public void setProdcatid(String prodcatid) {
		this.prodcatid = prodcatid;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String toString(){
		return prodcatid + "==="+productName;
	}

}
