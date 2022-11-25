package com.kodlamaio.bootcampProject.business.responses.blackList;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBlackListResponse {
	private int id;
	private LocalDate date;
	private String reason;
	private int applicantId;

}
