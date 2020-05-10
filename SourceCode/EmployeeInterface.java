import java.time.LocalDate;  


public interface EmployeeInterface
{
	boolean isPayDay(LocalDate date);
	double getPay();
	void deductUnionWeek();
	void creditPay(double pay);
	void addDeductions(double deduct);
	void postCard(double hours);
	default void paySalary(){this.creditPay(0);}
	
}