package com.kodlamaio.bootcampProject.business.abstracts;

import java.util.List;

import com.kodlamaio.bootcampProject.business.requests.blackList.CreateBlackListRequest;
import com.kodlamaio.bootcampProject.business.requests.blackList.UpdateBlackListRequest;
import com.kodlamaio.bootcampProject.business.responses.blackList.CreateBlackListResponse;
import com.kodlamaio.bootcampProject.business.responses.blackList.GetAllBlackListsResponse;
import com.kodlamaio.bootcampProject.business.responses.blackList.GetBlackListResponse;
import com.kodlamaio.bootcampProject.business.responses.blackList.UpdateBlackListResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

public interface BlackListService {
	DataResult<List<GetAllBlackListsResponse>> getAll();

	DataResult<GetBlackListResponse> getById(int id);

	DataResult<CreateBlackListResponse> add(CreateBlackListRequest createBlackListRequest);

	Result delete(int id);

	DataResult<UpdateBlackListResponse> update(UpdateBlackListRequest updateBlackListRequest);
	
	DataResult<GetBlackListResponse> getByApplicantId(int applicantId);
}
