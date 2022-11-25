package com.kodlamaio.bootcampProject.business.requests.blackList;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBlackListRequest {
	private int id;
	private LocalDate date;
	private String reason;
	private int applicantId;

}
