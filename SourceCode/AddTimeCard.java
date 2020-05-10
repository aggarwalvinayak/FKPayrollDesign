import java.time.LocalDate;  

public class AddTimeCard
{
	static void add(int empId,LocalDate date, Double hours)
	{
		TimeCard card = new TimeCard(empId,date,hours);
		Database.addCard(card);
	}
}