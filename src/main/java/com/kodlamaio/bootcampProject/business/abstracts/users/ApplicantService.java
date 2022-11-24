package com.kodlamaio.bootcampProject.business.abstracts.users;

import java.util.List;

import com.kodlamaio.bootcampProject.business.requests.applicant.CreateApplicantRequest;
import com.kodlamaio.bootcampProject.business.requests.applicant.UpdateApplicantRequest;
import com.kodlamaio.bootcampProject.business.responses.applicant.CreateApplicantResponse;
import com.kodlamaio.bootcampProject.business.responses.applicant.GetAllApplicantsResponse;
import com.kodlamaio.bootcampProject.business.responses.applicant.GetApplicantResponse;
import com.kodlamaio.bootcampProject.business.responses.applicant.UpdateApplicantResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

public interface ApplicantService {
	DataResult<List<GetAllApplicantsResponse>> getAll();

	DataResult<GetApplicantResponse> getById(int id);

	DataResult<CreateApplicantResponse> add(CreateApplicantRequest createApplicantRequest);

	Result delete(int id);

	DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest updateApplicantRequest);
}
