package ch04;

import java.util.ArrayList;

public interface IEmployees {

	// 직원과 월급 조회
	ArrayList<SalaryDto> searchSalary();

	// 고용날짜에 입사한 직원 출력
	ArrayList<EmployeesDto> joinCompanyDate(String hire_date);
	
	// 부서별 최고 연장자 출력
	ArrayList<EmployeesDto> printOldestEmployee();
	
	// 부서별 최고 선임 출력
	ArrayList<EmployeesDto> printSenior();
	
	// 부서 별 동기들 출력
	ArrayList<ColleagueDto> printColleague(String title);
	
}
