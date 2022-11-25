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

import com.kodlamaio.bootcampProject.business.abstracts.BootcampService;
import com.kodlamaio.bootcampProject.business.requests.bootcamp.CreateBootcampRequest;
import com.kodlamaio.bootcampProject.business.requests.bootcamp.UpdateBootcampRequest;
import com.kodlamaio.bootcampProject.business.responses.bootcamp.CreateBootcampResponse;
import com.kodlamaio.bootcampProject.business.responses.bootcamp.GetAllBootcampsResponse;
import com.kodlamaio.bootcampProject.business.responses.bootcamp.GetBootcampResponse;
import com.kodlamaio.bootcampProject.business.responses.bootcamp.UpdateBootcampResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/bootcamps")
@AllArgsConstructor
public class BootcampsController {
	private BootcampService bootcampService;
	
	@GetMapping("/getall")
	public DataResult<List<GetAllBootcampsResponse>> getAll() {
		return bootcampService.getAll();
	}
	
	@GetMapping("/{id}")
	public DataResult<GetBootcampResponse> getById(@PathVariable int id) {
		return bootcampService.getById(id);
	}
	
	@PostMapping("/add")
	public DataResult<CreateBootcampResponse> add(@RequestBody CreateBootcampRequest createBootcampRequest) {
		return bootcampService.add(createBootcampRequest);
	}
	
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return bootcampService.delete(id);
	}
	
	@PutMapping()
	public DataResult<UpdateBootcampResponse> update(@RequestBody UpdateBootcampRequest updateBootcampRequest) {
		return bootcampService.update(updateBootcampRequest);
	}
}
