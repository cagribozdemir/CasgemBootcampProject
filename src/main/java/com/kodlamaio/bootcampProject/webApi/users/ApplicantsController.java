package com.kodlamaio.bootcampProject.webApi.users;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.bootcampProject.business.abstracts.users.ApplicantService;
import com.kodlamaio.bootcampProject.business.requests.applicant.CreateApplicantRequest;
import com.kodlamaio.bootcampProject.business.requests.applicant.UpdateApplicantRequest;
import com.kodlamaio.bootcampProject.business.responses.applicant.CreateApplicantResponse;
import com.kodlamaio.bootcampProject.business.responses.applicant.GetAllApplicantsResponse;
import com.kodlamaio.bootcampProject.business.responses.applicant.GetApplicantResponse;
import com.kodlamaio.bootcampProject.business.responses.applicant.UpdateApplicantResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/applicants")
@AllArgsConstructor
public class ApplicantsController {
	private ApplicantService applicantService;
	
	@GetMapping("/getall")
	public DataResult<List<GetAllApplicantsResponse>> getAll() {
		return applicantService.getAll();
	}
	
	@GetMapping("/{id}")
	public DataResult<GetApplicantResponse> getById(@PathVariable int id) {
		return applicantService.getById(id);
	} 
	
	@PostMapping("/add")
	public DataResult<CreateApplicantResponse> add(@RequestBody CreateApplicantRequest createApplicantRequest) {
		return applicantService.add(createApplicantRequest);
	}
	
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return applicantService.delete(id);
	}
	
	@PutMapping()
	public DataResult<UpdateApplicantResponse> update(@RequestBody UpdateApplicantRequest updateApplicantRequest) {
		return applicantService.update(updateApplicantRequest);
	}
}
