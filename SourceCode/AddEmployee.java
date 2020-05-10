import java.time.LocalDate;  

public class AddEmployee
{
	static Employee addHourlyEmployee(String name,String address,int union,double unionWeeklyCharge,int methodOfPayment, LocalDate date,double rate)
	{
		Employee empCreated = new HourlyEmployee(name, address, union, unionWeeklyCharge, methodOfPayment,  date, rate);
		Database.addEmployee(empCreated);
		return empCreated;
	}
	static Employee addSalaryEmployee(String name,String address,int union,double unionWeeklyCharge,int methodOfPayment, LocalDate date,double salary)
	{
		Employee empCreated = new SalariedEmployee(name, address, union, unionWeeklyCharge, methodOfPayment,  date,  salary);
		Database.addEmployee(empCreated);
		return empCreated;
	}
	static Employee addCommissionedEmployee(String name,String address,int union,double unionWeeklyCharge,int methodOfPayment, LocalDate date,double salary,double commission)
	{
		Employee empCreated = new SalariedEmployee(name, address, union, unionWeeklyCharge, methodOfPayment,  date, salary, commission);
		Database.addEmployee(empCreated);
		return empCreated;
	}
}