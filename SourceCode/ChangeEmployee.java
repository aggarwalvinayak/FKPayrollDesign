public class ChangeEmployee
{
	static void changeName(int empID,String newName)
	{
		Employee e = Database.getEmployee(empID);
		e.name=newName;
	}
	static void changeAddress(int empID,String newAddress)
	{
		Employee e = Database.getEmployee(empID);
		e.address=newAddress;
	}

	static void changeUnionStatus(int empID,int newStatus)
	{
		Employee e = Database.getEmployee(empID);
		e.isUnion=newStatus;
	}

	static void changeUnionCharges(int empID,double newWeeklyCharge)
	{
		Employee e = Database.getEmployee(empID);
		e.unionWeeklyCharge=newWeeklyCharge;
	}
	static void changeHourRate(int empID,double newRate)
	{
		Employee e = Database.getEmployee(empID);
		e.rate=newRate;
	}

	static void changeCommissionRate(int empID,double newRate)
	{
		Employee e = Database.getEmployee(empID);
		e.rate=newRate;
	}

	static void methodOfPayment(int empID,int newMethodOfPayment)
	{
		Employee e = Database.getEmployee(empID);
		e.methodOfPayment=newMethodOfPayment;
	}

}