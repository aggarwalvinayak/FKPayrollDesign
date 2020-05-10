import java.time.LocalDate;  


public class SalariedEmployee extends Employee implements EmployeeInterface
{
	double salary;
	double commissionRate;
	SalariedEmployee(int id,String name,String address,int union,double unionWeeklyCharge,int methodOfPayment, LocalDate date,int cycle,double salary)
	{
		super(id,name,address,union, unionWeeklyCharge,methodOfPayment,date,cycle);
		this.salary=salary;
		this.commissionRate=0;
	}
	SalariedEmployee(int id,String name,String address,int union,double unionWeeklyCharge,int methodOfPayment, LocalDate date,int cycle,double salary,double commission)
	{
		super(id,name,address,union, unionWeeklyCharge,methodOfPayment,date,cycle);
		
		this.salary=salary;
		this.commissionRate=commission;
	}

	void postCommissionCard(Timecard card)
	{
		creditPay(commissionRate*card.sales);
	}
}