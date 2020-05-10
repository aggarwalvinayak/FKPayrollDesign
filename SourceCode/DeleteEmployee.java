public class DeleteEmployee
{
	static void delete(int empID)
	{
		Database.deleteEmployee(empID);
	}
	static void delete(Employee emp)
	{
		Database.deleteEmployee(emp.empID);
	}
}