package com.kodlamaio.bootcampProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootcampProject.business.abstracts.BootcampService;
import com.kodlamaio.bootcampProject.business.constants.BusinessMessages;
import com.kodlamaio.bootcampProject.business.constants.Messages;
import com.kodlamaio.bootcampProject.business.requests.bootcamp.CreateBootcampRequest;
import com.kodlamaio.bootcampProject.business.requests.bootcamp.UpdateBootcampRequest;
import com.kodlamaio.bootcampProject.business.responses.bootcamp.CreateBootcampResponse;
import com.kodlamaio.bootcampProject.business.responses.bootcamp.GetAllBootcampsResponse;
import com.kodlamaio.bootcampProject.business.responses.bootcamp.GetBootcampResponse;
import com.kodlamaio.bootcampProject.business.responses.bootcamp.UpdateBootcampResponse;
import com.kodlamaio.bootcampProject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcampProject.dataAccess.abstracts.BootcampRepository;
import com.kodlamaio.bootcampProject.entities.Bootcamp;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BootcampManager implements BootcampService {
	private BootcampRepository bootcampRepository;
	private ModelMapperService modelMapperService;

	@Override
	public DataResult<List<GetAllBootcampsResponse>> getAll() {
		List<Bootcamp> bootcamps = bootcampRepository.findAll();
		List<GetAllBootcampsResponse> bootcampsResponse = bootcamps.stream()
				.map(bootcamp -> this.modelMapperService.forResponse().map(bootcamp, GetAllBootcampsResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllBootcampsResponse>>(bootcampsResponse);
	}

	@Override
	public DataResult<GetBootcampResponse> getById(int id) {
		checkIfBootcampExistsById(id);
		Bootcamp bootcamp = bootcampRepository.findById(id).get();
		GetBootcampResponse bootcampResponse = modelMapperService.forResponse().map(bootcamp,
				GetBootcampResponse.class);

		return new SuccessDataResult<GetBootcampResponse>(bootcampResponse);
	}

	@Override
	public DataResult<CreateBootcampResponse> add(CreateBootcampRequest createBootcampRequest) {
		Bootcamp bootcamp = modelMapperService.forRequest().map(createBootcampRequest, Bootcamp.class);
		bootcamp.setId(0);
		bootcampRepository.save(bootcamp);
		CreateBootcampResponse createBootcampResponse = modelMapperService.forResponse().map(bootcamp,
				CreateBootcampResponse.class);
		return new SuccessDataResult<CreateBootcampResponse>(createBootcampResponse, Messages.BootcampCreated);
	}

	@Override
	public Result delete(int id) {
		checkIfBootcampExistsById(id);
		bootcampRepository.deleteById(id);
		return new SuccessResult(Messages.BootcampDeleted);
	}

	@Override
	public DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest updateBootcampRequest) {
		checkIfBootcampExistsById(updateBootcampRequest.getId());
		Bootcamp bootcamp = modelMapperService.forRequest().map(updateBootcampRequest, Bootcamp.class);
		bootcampRepository.save(bootcamp);
		UpdateBootcampResponse updateBootcampResponse = modelMapperService.forResponse().map(bootcamp,
				UpdateBootcampResponse.class);

		return new SuccessDataResult<UpdateBootcampResponse>(updateBootcampResponse, Messages.BootcampUpdated);
	}

	private void checkIfBootcampExistsById(int id) {
		Bootcamp bootcamp = bootcampRepository.findById(id).orElse(null);
		if (bootcamp == null) {
			throw new BusinessException(BusinessMessages.BootcampNoExists);
		}
	}

}
