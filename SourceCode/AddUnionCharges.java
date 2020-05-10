import java.time.LocalDate;  

public class AddUnionCharges
{
	static void add(int empId,LocalDate date,String desc, Double amount)
	{
		UnionCharges charge = new UnionCharges(empId, date, desc, amount);
		Database.addCharges(charge);
	}
}