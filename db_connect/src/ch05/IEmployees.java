package ch05;

import java.util.ArrayList;

public interface IEmployees {

	// 퇴사한 직원 출력
	ArrayList<EmployeesDto> retiredEmployeesData();
	
	// 사원 번호를 입력받고 title의 정보를 출력
	ArrayList<EmployeesDto> getEmployeesTitleByEmp_no(int emp_no);
	
	// title을 입력받고 직원 정보 출력
	ArrayList<EmployeesDto> getEmployeesInfoByTitles(String title);
	
	
	// 퇴사한 직원들의 퇴사일을 출력
	ArrayList<EmployeesDto> getEmployeesHire_date();
	
	// 직원의 사번과 연봉 출력
	ArrayList<SalaryDto> getEmp_noAndSalary();
	
	
}
