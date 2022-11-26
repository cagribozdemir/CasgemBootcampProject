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

import com.kodlamaio.bootcampProject.business.abstracts.BlackListService;
import com.kodlamaio.bootcampProject.business.requests.blackList.CreateBlackListRequest;
import com.kodlamaio.bootcampProject.business.requests.blackList.UpdateBlackListRequest;
import com.kodlamaio.bootcampProject.business.responses.blackList.CreateBlackListResponse;
import com.kodlamaio.bootcampProject.business.responses.blackList.GetAllBlackListsResponse;
import com.kodlamaio.bootcampProject.business.responses.blackList.GetBlackListResponse;
import com.kodlamaio.bootcampProject.business.responses.blackList.UpdateBlackListResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/blacklists")
@AllArgsConstructor
public class BlackListsController {
	private BlackListService blackListService;

	@GetMapping("/getall")
	public DataResult<List<GetAllBlackListsResponse>> getAll() {
		return blackListService.getAll();
	}

	@GetMapping("/{id}")
	public DataResult<GetBlackListResponse> getById(@PathVariable int id) {
		return blackListService.getById(id);
	}

	@PostMapping("/add")
	public DataResult<CreateBlackListResponse> add(@Valid @RequestBody CreateBlackListRequest createBlackListRequest) {
		return blackListService.add(createBlackListRequest);
	}

	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return blackListService.delete(id);
	}

	@PutMapping()
	public DataResult<UpdateBlackListResponse> update(@Valid @RequestBody UpdateBlackListRequest updateBlackListRequest) {
		return blackListService.update(updateBlackListRequest);
	}
}
