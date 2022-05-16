package ch04;

public class MainTest {

	public static void main(String[] args) {

		EmployeesDao dao = new EmployeesDao();
		
//		System.out.println(dao.searchSalary());
//		System.out.println(dao.joinCompanyDate("1991-01-01"));
//		System.out.println(dao.printOldestEmployee());
//		System.out.println(dao.printSenior());
		System.out.println(dao.printColleague("staff"));
		
	}

}
