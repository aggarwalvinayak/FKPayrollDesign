import java.time.LocalDate;  

public class HourlyEmployee extends Employee implements EmployeeInterface
{
	HourlyEmployee(String name,String address,int union,double unionWeeklyCharge,int methodOfPayment, LocalDate date,int cycle,double rate)
	{
		super(name,address,union, unionWeeklyCharge,methodOfPayment,date,cycle,rate,0);
	}

	public void postCard(double hours)
	{
		creditPay(hours*rate);
		if(hours>8)
			this.creditPay((hours-8)*0.5*rate);
	}
}