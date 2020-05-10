import java.time.LocalDate;  

public class SalariedEmployee extends Employee implements EmployeeInterface
{

	SalariedEmployee(String name,String address,int union,double unionWeeklyCharge,int methodOfPayment, LocalDate date,int cycle,double salary)
	{
		super(name,address,union, unionWeeklyCharge,methodOfPayment,date,cycle,0,salary);
	}
	SalariedEmployee(String name,String address,int union,double unionWeeklyCharge,int methodOfPayment, LocalDate date,int cycle,double salary,double commission)
	{
		super(name,address,union, unionWeeklyCharge,methodOfPayment,date,cycle, commission, salary);
	}

	public void postCard(double sales)
	{
		creditPay(rate*sales);
	}
	public void paySalary()
	{
		creditPay(this.salary);
	}
	
}