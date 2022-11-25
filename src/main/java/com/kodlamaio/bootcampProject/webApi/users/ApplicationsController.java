package com.kodlamaio.bootcampProject.webApi.users;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.bootcampProject.business.abstracts.applications.ApplicationService;
import com.kodlamaio.bootcampProject.business.requests.application.CreateApplicationRequest;
import com.kodlamaio.bootcampProject.business.requests.application.UpdateApplicationRequest;
import com.kodlamaio.bootcampProject.business.responses.application.CreateApplicationResponse;
import com.kodlamaio.bootcampProject.business.responses.application.GetAllApplicationsResponse;
import com.kodlamaio.bootcampProject.business.responses.application.GetApplicationResponse;
import com.kodlamaio.bootcampProject.business.responses.application.UpdateApplicationResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/applications")
public class ApplicationsController {
	private ApplicationService applicationService;
	
	@GetMapping("/getall")
	public DataResult<List<GetAllApplicationsResponse>> getAll() {
		return applicationService.getAll();
	}
	
	@GetMapping("/{id}")
	public DataResult<GetApplicationResponse> getById(@PathVariable int id) {
		return applicationService.getById(id);
	}
	
	@PostMapping("/add")
	public DataResult<CreateApplicationResponse> add(@Valid @RequestBody CreateApplicationRequest createBootcampRequest) {
		return applicationService.add(createBootcampRequest);
	}
	
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return applicationService.delete(id);
	}
	
	@PutMapping()
	public DataResult<UpdateApplicationResponse> update(@RequestBody UpdateApplicationRequest updateBootcampRequest) {
		return applicationService.update(updateBootcampRequest);
	}
}
