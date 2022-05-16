package ch05;

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
	public ArrayList<EmployeesDto> retiredEmployeesData() {
		
		ArrayList<EmployeesDto> employees = new ArrayList<EmployeesDto>();
		
		try {
			String query = "select a.emp_no, a.first_name, a.last_name, b.to_Date\r\n"
					+ "from employees as a, (select *\r\n"
					+ "                        from dept_emp\r\n"
					+ "                        where to_date <> '9999-01-01') as b\r\n"
					+ "where a.emp_no = b.emp_no\r\n"
					+ "limit 10;";
			
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			resultSet = preparedStatement.executeQuery();
		
			while(resultSet.next()) {
				
				EmployeesDto dto = new EmployeesDto();
				
				dto.setEmp_no(resultSet.getInt("emp_no"));
				dto.setFirst_name(resultSet.getString("first_name"));
				dto.setLast_name(resultSet.getString("last_name"));
				dto.setTo_date(resultSet.getString("to_Date"));
				
				employees.add(dto);
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return employees;
		
	}

	@Override
	public ArrayList<EmployeesDto> getEmployeesTitleByEmp_no(int emp_no) {
		
		ArrayList<EmployeesDto> employees = new ArrayList<EmployeesDto>();
		
		try {
			String query = "select *\r\n"
					+ "from titles as t\r\n"
					+ "where t.emp_no = (select emp_no\r\n"
					+ "from employees as e\r\n"
					+ "where emp_no = ?);";

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, emp_no);
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				
				EmployeesDto dto = new EmployeesDto();
				
				dto.setEmp_no(resultSet.getInt("emp_no"));
				dto.setTitle(resultSet.getString("title"));
				
				employees.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return employees;
	}

	@Override
	public ArrayList<EmployeesDto> getEmployeesInfoByTitles(String title) {

		ArrayList<EmployeesDto> employees = new ArrayList<EmployeesDto>();
		
		
		try {
			String query = "select *\r\n"
					+ "from employees as a\r\n"
					+ "where a.emp_no in (select emp_no from titles where title = ?)\r\n"
					+ "limit 10; ";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, title);
		
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				EmployeesDto dto = new EmployeesDto();
				
				dto.setEmp_no(resultSet.getInt("emp_no"));
				dto.setBirth_date(resultSet.getString("birth_date"));
				dto.setHire_date(resultSet.getString("hire_date"));
				
				employees.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return employees;
	}

	
	@Override
	public ArrayList<EmployeesDto> getEmployeesHire_date() {
		
		ArrayList<EmployeesDto> employees = new ArrayList<EmployeesDto>();
		
		try {
			String query = "select e.emp_no, (select t.to_date\r\n"
					+ "from titles as t \r\n"
					+ "where t.emp_no = e.emp_no\r\n"
					+ "and t.to_date <> '9999-01-01'\r\n"
					+ "group by emp_no\r\n"
					+ ") as '퇴사일'\r\n"
					+ "from employees as e\r\n"
					+ "limit 10;\r\n"
					+ "";

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				
				EmployeesDto dto = new EmployeesDto();
				
				dto.setEmp_no(resultSet.getInt("emp_no"));
				
				employees.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return employees;
	}

	@Override
	public ArrayList<SalaryDto> getEmp_noAndSalary() {
		
		ArrayList<SalaryDto> salary = new ArrayList<SalaryDto>();
		
		try {
			String query = "select e.emp_no,(select s.salary\r\n"
					+ "from salaries as s\r\n"
					+ "where e.emp_no = s.emp_no\r\n"
					+ "and to_date = '9999-01-01'\r\n"
					+ "group by emp_no) as 'salary'\r\n"
					+ "from employees as e\r\n"
					+ "limit 10;";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				SalaryDto dto = new SalaryDto();
				
				dto.setEmp_no(resultSet.getInt("emp_no"));
				dto.setSalary(resultSet.getInt("salary"));
				
				salary.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return salary;
	}
	
	
	
	
	
	
	
	
	
}
