import java.time.LocalDate;  

public abstract class Employee implements EmployeeInterface
{
	static int lastID=0;
	int empID;
	String name;
	String address;
	int isUnion; //0 means no union.. Other integers specify union number
	double unionWeeklyCharge;
	double pay;
	double deductions;
	int methodOfPayment;
	LocalDate payDay;
	int payCycle;
	double rate;
	double salary;
	Employee(String name,String address,int union,double unionWeeklyCharge,int methodOfPayment, LocalDate date,int cycle,double rate,double salary)
	{
		empID=lastID+1;
		lastID+=1;
		this.name=name;
		this.address=address;
		isUnion=union;
		this.unionWeeklyCharge=unionWeeklyCharge;
		pay=0;
		deductions=0;
		this.methodOfPayment=methodOfPayment;
		payDay=date;
		payCycle=cycle;
		this.rate=rate;	
		this.salary=salary;
	}

	public boolean isPayDay(LocalDate date)
	{
		return payDay==date;
	}
	public double getPay()
	{
		this.payDay=(this.payDay).plusDays(this.payCycle);
		return pay-deductions;
	}
	public void deductUnionWeek()
	{
		deductions+=unionWeeklyCharge;
	}
	public void creditPay(double pay)
	{
		this.pay+=pay;
	}
	public void addDeductions(double deductions)
	{
		this.deductions+=deductions;
	}

}