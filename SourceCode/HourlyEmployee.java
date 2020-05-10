import java.time.LocalDate;  


public class HourlyEmployee extends Employee implements EmployeeInterface
{
	double hourRate;
	HourlyEmployee(int id,String name,String address,int union,double unionWeeklyCharge,int methodOfPayment, LocalDate date,int cycle,double rate)
	{
		super(id,name,address,union, unionWeeklyCharge,methodOfPayment,date,cycle);
		this.hourRate=rate;
	}

	void postTimeCard(Timecard card)
	{
		creditPay(card.hours*hourRate);
		if(card.hours>8)
			this.creditPay((card.hours-8)*0.5*hourRate);
	}
}