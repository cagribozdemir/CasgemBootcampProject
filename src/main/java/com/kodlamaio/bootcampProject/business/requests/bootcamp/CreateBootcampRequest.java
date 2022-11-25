package com.kodlamaio.bootcampProject.business.requests.bootcamp;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBootcampRequest {
	private String name;
	private LocalDate dateStart;
	private LocalDate dateEnd;
	private int state;
	private int instructorId;
}


