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

import com.kodlamaio.bootcampProject.business.abstracts.users.InstructorService;
import com.kodlamaio.bootcampProject.business.requests.instructor.CreateInstructorRequest;
import com.kodlamaio.bootcampProject.business.requests.instructor.UpdateInstructorRequest;
import com.kodlamaio.bootcampProject.business.responses.instructor.CreateInstructorResponse;
import com.kodlamaio.bootcampProject.business.responses.instructor.GetAllInstructorResponse;
import com.kodlamaio.bootcampProject.business.responses.instructor.GetInstructorResponse;
import com.kodlamaio.bootcampProject.business.responses.instructor.UpdateInstructorResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/instructors")
@AllArgsConstructor
public class InstructorsController {
	private InstructorService instructorService;

	@GetMapping("/getall")
	public DataResult<List<GetAllInstructorResponse>> getAll() {
		return instructorService.getAll();
	}

	@GetMapping("/{id}")
	public DataResult<GetInstructorResponse> getById(@PathVariable int id) {
		return instructorService.getById(id);
	}

	@PostMapping("/add")
	public DataResult<CreateInstructorResponse> add(@Valid @RequestBody CreateInstructorRequest createInstructorRequest) {
		return instructorService.add(createInstructorRequest);
	}

	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return instructorService.delete(id);
	}

	@PutMapping()
	public DataResult<UpdateInstructorResponse> update(@Valid @RequestBody UpdateInstructorRequest updateInstructorRequest) {
		return instructorService.update(updateInstructorRequest);
	}

}
