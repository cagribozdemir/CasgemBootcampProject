package com.kodlamaio.bootcampProject.business.requests.instructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInstructorRequest {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String companyName;
}