import java.time.LocalDate;  


public interface EmployeeInterface
{
	boolean isPayDay(LocalDate date);
	double getPay();
	void deductUnionWeek();
	void creditPay(double pay);
	void addDeductions(double deduct);

}