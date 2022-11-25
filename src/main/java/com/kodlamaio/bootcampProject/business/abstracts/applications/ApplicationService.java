package com.kodlamaio.bootcampProject.business.abstracts.applications;

import java.util.List;

import com.kodlamaio.bootcampProject.business.requests.application.CreateApplicationRequest;
import com.kodlamaio.bootcampProject.business.requests.application.UpdateApplicationRequest;
import com.kodlamaio.bootcampProject.business.responses.application.CreateApplicationResponse;
import com.kodlamaio.bootcampProject.business.responses.application.GetAllApplicationsResponse;
import com.kodlamaio.bootcampProject.business.responses.application.GetApplicationResponse;
import com.kodlamaio.bootcampProject.business.responses.application.UpdateApplicationResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

public interface ApplicationService {
	DataResult<List<GetAllApplicationsResponse>> getAll();

	DataResult<GetApplicationResponse> getById(int id);

	DataResult<CreateApplicationResponse> add(CreateApplicationRequest createApplicationRequest);

	Result delete(int id);

	DataResult<UpdateApplicationResponse> update(UpdateApplicationRequest updateApplicationRequest);
}
