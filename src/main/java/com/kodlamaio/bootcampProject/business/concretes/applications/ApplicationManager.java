package com.kodlamaio.bootcampProject.business.concretes.applications;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootcampProject.business.abstracts.BlackListService;
import com.kodlamaio.bootcampProject.business.abstracts.applications.ApplicationService;
import com.kodlamaio.bootcampProject.business.constants.BusinessMessages;
import com.kodlamaio.bootcampProject.business.constants.Messages;
import com.kodlamaio.bootcampProject.business.requests.application.CreateApplicationRequest;
import com.kodlamaio.bootcampProject.business.requests.application.UpdateApplicationRequest;
import com.kodlamaio.bootcampProject.business.responses.application.CreateApplicationResponse;
import com.kodlamaio.bootcampProject.business.responses.application.GetAllApplicationsResponse;
import com.kodlamaio.bootcampProject.business.responses.application.GetApplicationResponse;
import com.kodlamaio.bootcampProject.business.responses.application.UpdateApplicationResponse;
import com.kodlamaio.bootcampProject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcampProject.dataAccess.abstracts.applications.ApplicationRepository;
import com.kodlamaio.bootcampProject.entities.applications.Application;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApplicationManager implements ApplicationService {
	private ApplicationRepository applicationRepository;
	private ModelMapperService modelMapperService;
	private BlackListService blackListService;

	@Override
	public DataResult<List<GetAllApplicationsResponse>> getAll() {
		List<Application> applications = applicationRepository.findAll();
		List<GetAllApplicationsResponse> getAllApplicationsResponses = applications.stream().map(
				application -> this.modelMapperService.forResponse().map(application, GetAllApplicationsResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllApplicationsResponse>>(getAllApplicationsResponses, Messages.ApplicationListed);
	}

	@Override
	public DataResult<GetApplicationResponse> getById(int id) {
		checkIfApplicationExistsById(id);
		Application application = applicationRepository.findById(id).get();
		GetApplicationResponse getApplicationResponse = modelMapperService.forResponse().map(application, GetApplicationResponse.class);
		return new SuccessDataResult<GetApplicationResponse>(getApplicationResponse);
	}

	@Override
	public DataResult<CreateApplicationResponse> add(CreateApplicationRequest createApplicationRequest) {
		checkIfApplicationExistsByBlackList(createApplicationRequest.getApplicantId());
		Application application = modelMapperService.forRequest().map(createApplicationRequest, Application.class);
		applicationRepository.save(application);
		CreateApplicationResponse createApplicationResponse = modelMapperService.forResponse().map(application, CreateApplicationResponse.class);
		return new SuccessDataResult<CreateApplicationResponse>(createApplicationResponse, Messages.ApplicationCreated);
	}

	@Override
	public Result delete(int id) {
		checkIfApplicationExistsById(id);
		applicationRepository.deleteById(id);
		return new SuccessResult(Messages.ApplicationDeleted);
	}

	@Override
	public DataResult<UpdateApplicationResponse> update(UpdateApplicationRequest updateApplicationRequest) {
		checkIfApplicationExistsById(updateApplicationRequest.getId());
		Application application = modelMapperService.forRequest().map(updateApplicationRequest, Application.class);
		applicationRepository.save(application);
		UpdateApplicationResponse updateApplicationResponse = modelMapperService.forResponse().map(application, UpdateApplicationResponse.class);
		return new SuccessDataResult<UpdateApplicationResponse>(updateApplicationResponse, Messages.ApplicationUpdated);
	}
	private void checkIfApplicationExistsById(int id) {
		Application application = applicationRepository.findById(id).orElse(null);
		if (application == null) {
			throw new BusinessException(BusinessMessages.ApplicationNoExists);
		}
	}
	
	private void checkIfApplicationExistsByBlackList(int id) {
		var result = blackListService.getByApplicantId(id);
		if (result != null) {
			throw new BusinessException(BusinessMessages.InBlackList);
		}
	}

}
