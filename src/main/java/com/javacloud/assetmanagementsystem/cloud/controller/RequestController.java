package com.javacloud.assetmanagementsystem.cloud.controller;

import java.util.List;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacloud.assetmanagementsystem.cloud.dto.RequestAsset;
import com.javacloud.assetmanagementsystem.cloud.response.Response;
import com.javacloud.assetmanagementsystem.cloud.services.RequestService;



@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class RequestController {

	private RequestService requestService;

	@Autowired
	public RequestController(RequestService requestService) {
		this.requestService = requestService;
	}

	@GetMapping("/request")
	public Response<List<RequestAsset>> getAllAssets() {
		List<RequestAsset> list = requestService.getAllRequest();
		return new Response<>(false, "Request retrived", list);

	}

	@GetMapping("/request/getrequest/{request_id}")
	public Response<RequestAsset> getRequestById(@PathVariable int request_id) {
		RequestAsset requestAsset = requestService.getRequestById(request_id);

		if (requestAsset != null) {
			return new Response<RequestAsset>(false, "request retrived", requestAsset);

		} else {
			throw new RuntimeException("Request id not found");
		}
	}

//	@DeleteMapping("/request/deleterequest/{request_id}")
//	public Response<RequestAsset> deleteRequest(@PathVariable int request_id) {
//		RequestAsset requestAsset = requestService.getRequestById(request_id);
//
//		if (requestAsset != null) {
//			requestService.deleteRequest(request_id);
//			return new Response<RequestAsset>(false, "Request deleted", requestAsset);
//		} else {
//			return new Response<RequestAsset>(true, "Request not deleted", null);
//		}
//
//	}

	@PutMapping("/request/updaterequest")
	public Response<RequestAsset> UpdateRequest(  @RequestBody RequestAsset requestAsset) {
		RequestAsset requestAsset2 = requestService.saveAsset(requestAsset);

		if (requestAsset2 != null) {
			return new Response<RequestAsset>(false, "Updated saved successfully", requestAsset2);
		} else {
			return new Response<RequestAsset>(true, "Update failed", null);

		}

	}
	

	@PutMapping("/request/updaterequest/{id}")
	public Response<RequestAsset> UpdateRequest( @PathVariable int id, @RequestBody RequestAsset requestAsset) {
		RequestAsset requestAsset2 = requestService.addRequest(id,requestAsset);

		if (requestAsset2 != null) {
			return new Response<RequestAsset>(false, "Updated saved successfully", requestAsset2);
		} else {
			return new Response<RequestAsset>(true, "Update failed", null);

		}

	}

	@PostMapping("/request/addrequest")
	public Response<RequestAsset> addRequest(@Valid @RequestBody RequestAsset requestAsset) {
		RequestAsset requestAsset2 = requestService.saveAsset(requestAsset);

		if (requestAsset2 != null) {
			return new Response<RequestAsset>(false, "request saved successfully", requestAsset2);
		} else {
			return new Response<RequestAsset>(true, "request failed", null);

		}
	}
	
	@PostMapping("/request/addrequest/{id}")
	public Response<RequestAsset> addRequest(@PathVariable int id,@RequestBody RequestAsset requestAsset) {
		requestAsset.setRequestId(0);
		RequestAsset requestAsset2 = requestService.addRequest(id,requestAsset);
		
		if (requestAsset2 != null) {
			return new Response<RequestAsset>(false, "request saved successfully", requestAsset2);
		} else {
			return new Response<RequestAsset>(true, "request failed", null);

		}
	}
//	
//	@PutMapping("/request/allocateRequest/{id}")
//	public Response<RequestAsset> allocateRequest(@PathVariable int id) {
//		RequestAsset requestAsset = requestService.setAccept(id);
//		
//		if(requestAsset != null) {
//			return new Response<RequestAsset>(false, "request allocated successfully", requestAsset);
//
//		}else {
//			return new Response<RequestAsset>(true, "review request failed", null);
//		}
//	}
//
//
//	
//	
//	@PutMapping("/request/unallocateRequest/{id}")
//	public Response<RequestAsset> unallocateRequest(@PathVariable int id) {
//		RequestAsset requestAsset = requestService.setReject(id);   
//		
//		if(requestAsset != null) {
//			return new Response<RequestAsset>(false, "request unallocated successfully", requestAsset);
//
//		}else {
//			return new Response<RequestAsset>(true, "review request failed", null);
//		}
//	}

	
	
	
	@GetMapping("/request/get/{status}")
	public List<RequestAsset> generateReport(@PathVariable String status) {
		return requestService.generateReport(status);
	}

	@GetMapping("/request/{pageNo}/{requestPerPage}")
	public Page<RequestAsset> getRequests(@PathVariable int pageNo, @PathVariable int requestPerPage) {
		return requestService.getRequests(pageNo, requestPerPage);
	
	}

	@GetMapping("/request/{pageNo}/{requestPerPage}/{requestFieldName}")
	public Page<RequestAsset> getSortedRequests(@PathVariable int pageNo, @PathVariable int requestPerPage,@PathVariable String requestFieldName){
		return requestService.getSortedRequests(pageNo, requestPerPage, requestFieldName);
	}
	
	@GetMapping("/request/getrequestAllocated/{pageNo}/{itemsPerPage}")
	public Page<RequestAsset> allocatedRequests(@PathVariable int pageNo, @PathVariable int itemsPerPage) {

		return requestService.allocatedRequests(pageNo, itemsPerPage);
	}

	@GetMapping("/request/getrequestAllocated/{pageNo}/{itemsPerPage}/{fieldName}")
	public Page<RequestAsset> allocatedRequests(@PathVariable int pageNo, @PathVariable int itemsPerPage,
			@PathVariable String fieldName) {

		return requestService.allocatedRequests(pageNo, itemsPerPage, fieldName);
	}


	@GetMapping("/request/getrequestPending/{pageNo}/{itemsPerPage}")
	public Page<RequestAsset> pendingRequests(@PathVariable int pageNo, @PathVariable int itemsPerPage) {

		return requestService.pendingRequests(pageNo, itemsPerPage);
	}

	@GetMapping("/request/getrequestPending/{pageNo}/{itemsPerPage}/{fieldName}")
	public Page<RequestAsset> pendingRequests(@PathVariable int pageNo, @PathVariable int itemsPerPage,
			@PathVariable String fieldName) {

		return requestService.pendingRequests(pageNo, itemsPerPage, fieldName);

	}



	@GetMapping("/request/getrequestRejected/{pageNo}/{itemsPerPage}")
	public Page<RequestAsset> rejectedRequests(@PathVariable int pageNo, @PathVariable int itemsPerPage) {

		return requestService.rejectedRequests(pageNo, itemsPerPage);
	}

	@GetMapping("/request/getrequestRejected/{pageNo}/{itemsPerPage}/{fieldName}")
	public Page<RequestAsset> rejectedRequests(@PathVariable int pageNo, @PathVariable int itemsPerPage,
			@PathVariable String fieldName) {

		return requestService.rejectedRequests(pageNo, itemsPerPage, fieldName);

	}

	
	
	
}
