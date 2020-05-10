import java.time.LocalDate;  

public class SalariedEmployee extends Employee implements EmployeeInterface
{

	SalariedEmployee(String name,String address,int union,double unionWeeklyCharge,int methodOfPayment, LocalDate date,double salary)
	{
		super(name,address,union, unionWeeklyCharge,methodOfPayment,date,30,0,salary);
	}
	SalariedEmployee(String name,String address,int union,double unionWeeklyCharge,int methodOfPayment, LocalDate date,double salary,double commission)
	{
		super(name,address,union, unionWeeklyCharge,methodOfPayment,date,14, commission, salary);
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