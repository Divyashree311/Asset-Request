package com.javacloud.assetmanagementsystem.cloud.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;




@SuppressWarnings("serial")
@Table(name = "assets")
@Entity
public class Assets implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "asset_id")
	private int assetId;

	
	@NotNull(message = "field is mandatory")
	@Column(name = "asset_name")
	@Size(min = 2, max = 30, message = "Asset name should be greater than 2 and should be less than 30")
	@Pattern(regexp = "[A-Z a-z]*")
	private String assetName;

	@Column
	@NotNull(message = "field is mandatory")
	@Size(min = 2, max = 30, message = "category should be greater than 2 and should be less than 30")
	@Pattern(regexp = "[A-Z a-z]*")
	private String category;

	@Column
	@NotNull(message = "field is mandatory")
	@Pattern(regexp = "[0-9]*", message = "field accepts only numbers")
	private String price;

	@Column
	@NotNull(message = "field is mandatory")
	@Pattern(regexp = "[0-9]*", message = "field accepts only numbers")
	private String quantity;

	@Column
	@NotNull(message = "field is mandatory")
	@Size(min = 10, message = "Details should consists of minimum 10 characters")
	private String details;

	public Assets() {
	}

	public Assets(int assetId, String assetName, String category, String price, String quantity, String details) {
		this.assetId = assetId;
		this.assetName = assetName;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.details = details;
	}

	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Assets [assetId=" + assetId + ", assetName=" + assetName + ", category=" + category + ", price=" + price
				+ ", quantity=" + quantity + ", details=" + details + "]";
	}

}
