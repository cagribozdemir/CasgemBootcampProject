package com.kodlamaio.bootcampProject.business.requests.blackList;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBlackListRequest {
	@NotNull
	@NotEmpty
	@Min(0)
	private int id;
	@NotNull
	@NotEmpty
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate date;
	@NotNull
	@NotEmpty
	private String reason;
	@NotNull
	@NotEmpty
	@Min(0)
	private int applicantId;

}
