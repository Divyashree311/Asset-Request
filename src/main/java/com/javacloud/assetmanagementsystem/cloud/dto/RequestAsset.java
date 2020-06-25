package com.javacloud.assetmanagementsystem.cloud.dto;

import java.io.Serializable;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonBackReference;

@SuppressWarnings("serial")
@Entity
@Table(name = "request")
public class RequestAsset implements Serializable {

	@Id
	@Column(name = "request_id")
	private int requestId;

	@Pattern(regexp = "[0-9]*", message = "field accepts only numbers")
	@Column(name = "user_id")
	@NotNull(message = "field is mandatory")
	private String userId;

	@Pattern(regexp = "[0-9]*", message = "field accepts only numbers")
	@Column(name = "asset_id")
	@NotNull(message = "field is mandatory")
	private String assetId;

	@Column
	private String status;

	@Column(name = "quantity")
	@Pattern(regexp = "[0-9]*", message = "field accepts only numbers")
	@NotNull(message = "field is mandatory")
	private String quantity;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	@JsonBackReference
	private UserBean userBean;

	@Column(name = "ref_id")
	private Integer refId;

	public RequestAsset() {
		
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public Integer getRefId() {
		return refId;
	}

	public void setRefId(Integer refId) {
		this.refId = refId;
	}

	public RequestAsset(int requestId, String userId, String assetId, String status, String quantity, UserBean userBean,
			Integer refId) {
		this.requestId = requestId;
		this.userId = userId;
		this.assetId = assetId;
		this.status = status;
		this.quantity = quantity;
		this.userBean = userBean;
		this.refId = refId;
	}

	@Override
	public String toString() {
		return "RequestAsset [requestId=" + requestId + ", userId=" + userId + ", assetId=" + assetId + ", status="
				+ status + ", quantity=" + quantity + ", userBean=" + userBean + ", refId=" + refId + "]";
	}

}