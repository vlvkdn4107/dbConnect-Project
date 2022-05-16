package ch04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeesDao implements IEmployees {

	DBClient client = DBClient.getInstance();
	Connection connection = client.getConnection();
	ResultSet resultSet = null;

	@Override
	public ArrayList<SalaryDto> searchSalary() {
		
		ArrayList<SalaryDto> salary = new ArrayList<SalaryDto>();
		
		try {
			String query = "select e.emp_no, s.salary\r\n" + "from employees as e\r\n" + "inner join salaries as s\r\n"
					+ "on e.emp_no = s.emp_no\r\n" + "group by e.emp_no\r\n" + "limit 10;";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				SalaryDto dto = new SalaryDto();

				dto.setEmp_no(resultSet.getInt("emp_no"));
				dto.setSalary(resultSet.getInt("salary"));

				salary.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return salary;

	}

	
	@Override
	public ArrayList<EmployeesDto> joinCompanyDate(String hire_date) {
		
		ArrayList<EmployeesDto> employees = new ArrayList<EmployeesDto>();
		
		try {
			String query = "SELECT s.emp_no, e.first_name, e.last_name, e.hire_date \r\n" + "FROM salaries AS s \r\n"
					+ "JOIN employees AS e \r\n" + "ON s.emp_no = e.emp_no \r\n" + "GROUP BY s.emp_no \r\n"
					+ "HAVING e.hire_date = ?\r\n" + "limit 10;";

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, hire_date);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				EmployeesDto dto = new EmployeesDto();

				dto.setEmp_no(resultSet.getInt("emp_no"));
				dto.setFirst_name(resultSet.getString("first_name"));
				dto.setLast_name(resultSet.getString("last_name"));
				dto.setHire_date(resultSet.getString("hire_date"));

				employees.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return employees;

	}


	@Override
	public ArrayList<EmployeesDto> printOldestEmployee() {
		ArrayList<EmployeesDto> employees = new ArrayList<EmployeesDto>();
		
		try {
			String query = "select e.emp_no, d.dept_no, e.birth_date\r\n"
					+ "from employees e\r\n"
					+ "inner join dept_emp d\r\n"
					+ "on e.emp_no = d.emp_no\r\n"
					+ "group by d.dept_no\r\n"
					+ "having min(e.birth_date);";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				EmployeesDto dto = new EmployeesDto();

				dto.setEmp_no(resultSet.getInt("emp_no"));
				dto.setDept_no(resultSet.getString("dept_no"));
				dto.setBirth_date(resultSet.getString("birth_date"));

				employees.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return employees;
	}


	@Override
	public ArrayList<EmployeesDto> printSenior() {
		ArrayList<EmployeesDto> employees = new ArrayList<EmployeesDto>();
		
		try {
			String query = "select a.emp_no, b.dept_no, a.hire_date\r\n"
					+ "from employees a\r\n"
					+ "inner join dept_emp b\r\n"
					+ "on a.emp_no = b.emp_no\r\n"
					+ "group by b.dept_no\r\n"
					+ "having min(a.hire_date);";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				EmployeesDto dto = new EmployeesDto();

				dto.setEmp_no(resultSet.getInt("emp_no"));
				dto.setDept_no(resultSet.getString("dept_no"));
				dto.setHire_date(resultSet.getString("hire_date"));

				employees.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return employees;
	}
	
	
	
	@Override
	public ArrayList<ColleagueDto> printColleague(String title) {
		ArrayList<ColleagueDto> colleague = new ArrayList<ColleagueDto>();
		
		try {
			String query = "select t.title, count(e.emp_no) as 'colleague'\r\n"
					+ "from employees as e\r\n"
					+ "inner join titles as t\r\n"
					+ "on e.emp_no = t.emp_no\r\n"
					+ "where t.title = ?\r\n"
					+ "group by t.title;";

			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, title);
			
			
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				ColleagueDto dto = new ColleagueDto();

				dto.setTitle(resultSet.getString("title"));
				dto.setColleague(resultSet.getString("colleague"));

				colleague.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return colleague;
	}
	
	
	
	
	
	
	

}
