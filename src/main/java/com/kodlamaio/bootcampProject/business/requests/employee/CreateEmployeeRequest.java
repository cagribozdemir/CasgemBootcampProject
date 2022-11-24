package com.kodlamaio.bootcampProject.business.requests.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeRequest {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String position;
}
