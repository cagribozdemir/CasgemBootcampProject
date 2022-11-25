package com.kodlamaio.bootcampProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootcampProject.business.abstracts.BlackListService;
import com.kodlamaio.bootcampProject.business.constants.BusinessMessages;
import com.kodlamaio.bootcampProject.business.constants.Messages;
import com.kodlamaio.bootcampProject.business.requests.blackList.CreateBlackListRequest;
import com.kodlamaio.bootcampProject.business.requests.blackList.UpdateBlackListRequest;
import com.kodlamaio.bootcampProject.business.responses.blackList.CreateBlackListResponse;
import com.kodlamaio.bootcampProject.business.responses.blackList.GetAllBlackListsResponse;
import com.kodlamaio.bootcampProject.business.responses.blackList.GetBlackListResponse;
import com.kodlamaio.bootcampProject.business.responses.blackList.UpdateBlackListResponse;
import com.kodlamaio.bootcampProject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcampProject.dataAccess.abstracts.BlackListRepository;
import com.kodlamaio.bootcampProject.entities.BlackList;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BlackListManager implements BlackListService {
	private BlackListRepository blackListRepository;
	private ModelMapperService modelMapperService;

	@Override
	public DataResult<List<GetAllBlackListsResponse>> getAll() {
		List<BlackList> blackLists = blackListRepository.findAll();
		List<GetAllBlackListsResponse> allBlackListsResponses = blackLists.stream()
				.map(blackList -> this.modelMapperService.forResponse().map(blackList, GetAllBlackListsResponse.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<GetAllBlackListsResponse>>(allBlackListsResponses, Messages.BlackListListed);
	}

	@Override
	public DataResult<GetBlackListResponse> getById(int id) {
		checkIfBlackListExistsById(id);
		BlackList blackList = blackListRepository.findById(id).get();
		GetBlackListResponse getBlackListResponse = modelMapperService.forResponse().map(blackList,
				GetBlackListResponse.class);
		return new SuccessDataResult<GetBlackListResponse>(getBlackListResponse);
	}

	@Override
	public DataResult<CreateBlackListResponse> add(CreateBlackListRequest createBlackListRequest) {
		BlackList blackList = modelMapperService.forRequest().map(createBlackListRequest, BlackList.class);
		blackListRepository.save(blackList);
		CreateBlackListResponse createBlackListResponse = modelMapperService.forResponse().map(blackList,
				CreateBlackListResponse.class);
		return new SuccessDataResult<CreateBlackListResponse>(createBlackListResponse, Messages.BlackListCreated);
	}

	@Override
	public Result delete(int id) {
		checkIfBlackListExistsById(id);
		blackListRepository.deleteById(id);
		return new SuccessResult(Messages.BlackListDeleted);
	}

	@Override
	public DataResult<UpdateBlackListResponse> update(UpdateBlackListRequest updateBlackListRequest) {
		checkIfBlackListExistsById(updateBlackListRequest.getId());
		BlackList blackList = modelMapperService.forRequest().map(updateBlackListRequest, BlackList.class);
		blackListRepository.save(blackList);
		UpdateBlackListResponse updateBlackListResponse = modelMapperService.forResponse().map(blackList,
				UpdateBlackListResponse.class);

		return new SuccessDataResult<UpdateBlackListResponse>(updateBlackListResponse, Messages.BlackListUpdated);
	}
	
	@Override
	public DataResult<GetBlackListResponse> getByApplicantId(int Applicantid) {
		BlackList blackList = blackListRepository.getByApplicantId(Applicantid);
		GetBlackListResponse blackListResponse = modelMapperService.forResponse().map(blackList, GetBlackListResponse.class);
		return new SuccessDataResult<GetBlackListResponse>(blackListResponse);
	}
	
	private void checkIfBlackListExistsById(int id) {
		BlackList blackList = blackListRepository.findById(id).orElse(null);
		if (blackList == null) {
			throw new BusinessException(BusinessMessages.BlackListNoExists);
		}
	}

	

}
