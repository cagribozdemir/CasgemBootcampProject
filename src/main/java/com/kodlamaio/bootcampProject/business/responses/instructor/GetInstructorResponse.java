package com.kodlamaio.bootcampProject.business.responses.instructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetInstructorResponse {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String companyName;
}
