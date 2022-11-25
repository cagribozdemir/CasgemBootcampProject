package com.kodlamaio.bootcampProject.business.requests.application;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateApplicationRequest {
	private int applicantId;
	@Min(2)
	private int bootcampId;
	@Min(2)
	private int state;
}

