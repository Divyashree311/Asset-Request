package com.javacloud.assetmanagementsystem.cloud.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javacloud.assetmanagementsystem.cloud.dto.RequestAsset;

@Repository
public interface RequestRepository extends JpaRepository<RequestAsset, Integer>{
	
	@Query("from RequestAsset where status=?1")
	List<RequestAsset> generateReport(String status);
	
	@Query("select c from RequestAsset c where status='Allocated'")
	Page<RequestAsset> allocatedRequests(Pageable pageable);
	
	@Query("select c from RequestAsset c where status='Rejected'")
	Page<RequestAsset> rejectedRequests(Pageable pageable);
	
	
	@Query("select c from RequestAsset c where status='pending'")
	Page<RequestAsset> pendingRequests(Pageable pageable);




}
