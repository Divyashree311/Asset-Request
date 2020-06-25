package com.javacloud.assetmanagementsystem.cloud.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.javacloud.assetmanagementsystem.cloud.dto.RequestAsset;

public interface RequestService {
	
	public List<RequestAsset> getAllRequest();
	
	public RequestAsset getRequestById(int request_id);
	
	public void deleteRequest(int request_id);
	
	public RequestAsset saveAsset(RequestAsset  requestAsset);
	
	public Page<RequestAsset> getRequests(int pageNo, int requestsPerPage);
	
	public Page<RequestAsset> getSortedRequests(int pageNo, int requestsPerPage,String requestFieldName);

	public RequestAsset addRequest(int id,RequestAsset request);
	
	List<RequestAsset> generateReport(String status);


public Page<RequestAsset> allocatedRequests(int pageNo, int itemsPerPage);
	
	public Page<RequestAsset> allocatedRequests(int pageNo, int itemsPerPage, String fieldName);

    public Page<RequestAsset> rejectedRequests(int pageNo, int itemsPerPage);
	
	public Page<RequestAsset> rejectedRequests(int pageNo, int itemsPerPage, String fieldName);
	

public Page<RequestAsset> pendingRequests(int pageNo, int itemsPerPage);
	
	public Page<RequestAsset> pendingRequests(int pageNo, int itemsPerPage, String fieldName);
	
	
}
