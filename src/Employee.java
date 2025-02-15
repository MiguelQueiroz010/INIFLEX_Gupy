import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee extends Person {
	
	BigDecimal payment;
	String role;
	
	static Employee EmployeeAdd(String name, LocalDate born, BigDecimal paym, String role)
	{
		var emp = new Employee();
		
		emp.Nome = name;
		emp.BornDate = born;
		emp.payment = paym;
		emp.role = role;
		return emp;
	}
}
