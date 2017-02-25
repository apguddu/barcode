package com.mnptech.bcgen.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="prodcatmaster")
public class ProductCategory {
   @Id
   private String id;
   
   private String prodcatid;
   
   private String prodcatdesc;

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

	public String getProdcatdesc() {
		return prodcatdesc;
	}

	public void setProdcatdesc(String prodcatdesc) {
		this.prodcatdesc = prodcatdesc;
	}
   
   
}
