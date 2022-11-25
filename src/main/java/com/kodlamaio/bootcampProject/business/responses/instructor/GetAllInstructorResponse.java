package com.kodlamaio.bootcampProject.business.responses.instructor;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllInstructorResponse {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String companyName;
	private String nationalIdentity;
	private LocalDate dateOfBirth;
}
