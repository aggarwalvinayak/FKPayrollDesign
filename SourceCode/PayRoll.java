import java.time.LocalDate;  
import java.util.*;

public class PayRoll
{
	static LocalDate lastDate=LocalDate.of(2020, 01, 01);;
	static LocalDate currentRun;
	static void payTimeCards()
	{
		TimeCard card=Database.getTimeCards(currentRun);
		while(card!=null)
		{
			Employee e = Database.getEmployee(card.empId);
			e.postCard(card.hours);
			card=Database.getTimeCards(currentRun);
		}
	}
	static void paySalaryReceipts()
	{
		SalesCard card=Database.getSalesCards(currentRun);
		while(card!=null)
		{
			Employee e = Database.getEmployee(card.empId);
			e.postCard(card.saleAmount);
			card=Database.getSalesCards(currentRun);
		}
	}
	static void unionDeduction()
	{
		UnionCharges card=Database.getUnionCharges(currentRun);
		while(card!=null)
		{
			Employee e = Database.getEmployee(card.empId);
			e.addDeductions(card.amount);
			card=Database.getUnionCharges(currentRun);
		}
	}
	static void pay()
	{
		HashMap<Integer,Employee> employees = Database.getEmployeeDatabase();
		for (Map.Entry<Integer, Employee> employee : employees.entrySet()) 
		{
			if((employee.getValue()).isPayDay(currentRun))
			{
				System.out.println("Employee " + employee.getKey() + " paid Rs." +
					employee.getValue().getPay() + " on " + currentRun);
			}
   		}
	}
	static void run(LocalDate date)
	{

		while(lastDate==null || lastDate.isBefore(date))
		{
			currentRun=lastDate.plusDays(1);
			payTimeCards();
			paySalaryReceipts();
			unionDeduction();
			pay();
			lastDate=currentRun;
		}

	}
}