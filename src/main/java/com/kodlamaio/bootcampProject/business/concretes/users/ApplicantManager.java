package com.kodlamaio.bootcampProject.business.concretes.users;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootcampProject.business.abstracts.users.ApplicantService;
import com.kodlamaio.bootcampProject.business.constants.Messages;
import com.kodlamaio.bootcampProject.business.requests.applicant.CreateApplicantRequest;
import com.kodlamaio.bootcampProject.business.requests.applicant.UpdateApplicantRequest;
import com.kodlamaio.bootcampProject.business.responses.applicant.CreateApplicantResponse;
import com.kodlamaio.bootcampProject.business.responses.applicant.GetAllApplicantsResponse;
import com.kodlamaio.bootcampProject.business.responses.applicant.GetApplicantResponse;
import com.kodlamaio.bootcampProject.business.responses.applicant.UpdateApplicantResponse;
import com.kodlamaio.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcampProject.dataAccess.abstracts.users.ApplicantRepository;
import com.kodlamaio.bootcampProject.entities.users.Applicant;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApplicantManager implements ApplicantService {
	private ApplicantRepository applicantRepository;
	private ModelMapperService modelMapperService;

	@Override
	public DataResult<List<GetAllApplicantsResponse>> getAll() {
		List<Applicant> applicants = applicantRepository.findAll();
		List<GetAllApplicantsResponse> applicantsResponse = applicants.stream()
				.map(applicant -> this.modelMapperService.forResponse().map(applicant, GetAllApplicantsResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllApplicantsResponse>>(applicantsResponse, Messages.ApplicantListed);
	}

	@Override
	public DataResult<CreateApplicantResponse> add(CreateApplicantRequest createApplicantRequest) {
		Applicant applicant = modelMapperService.forRequest().map(createApplicantRequest, Applicant.class);
		applicantRepository.save(applicant);
		CreateApplicantResponse createApplicantResponse = modelMapperService.forResponse().map(applicant,
				CreateApplicantResponse.class);
		return new SuccessDataResult<CreateApplicantResponse>(createApplicantResponse, Messages.ApplicantCreated);
	}

	@Override
	public Result delete(int id) {
		Applicant applicant = applicantRepository.findById(id).get();
		applicantRepository.delete(applicant);
		return new SuccessResult(Messages.ApplicantDeleted);
	}

	@Override
	public DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest updateApplicantRequest) {
		Applicant applicant = modelMapperService.forRequest().map(updateApplicantRequest, Applicant.class);
		applicantRepository.save(applicant);
		UpdateApplicantResponse updateApplicantResponse = modelMapperService.forResponse().map(applicant,
				UpdateApplicantResponse.class);
		return new SuccessDataResult<UpdateApplicantResponse>(updateApplicantResponse, Messages.ApplicantUpdated);
	}

	@Override
	public DataResult<GetApplicantResponse> getById(int id) {
		Applicant applicant = applicantRepository.findById(id).get();
		GetApplicantResponse applicantResponse = modelMapperService.forResponse().map(applicant, GetApplicantResponse.class);
		return new SuccessDataResult<GetApplicantResponse>(applicantResponse); 
	}
}
