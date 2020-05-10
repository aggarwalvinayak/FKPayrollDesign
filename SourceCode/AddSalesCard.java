import java.time.LocalDate;  

public class AddSalesCard
{
	static void add(int empId,LocalDate date, Double amount)
	{
		SalesCard card = new SalesCard(empId,date,amount);
		Database.addReceipt(card);
	}
}