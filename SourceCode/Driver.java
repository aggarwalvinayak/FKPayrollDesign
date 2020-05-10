import java.time.*; 
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.time.format.DateTimeFormatter;

import java.io.IOException;
import java.io.FileWriter;
public class Driver
{
	public static void main(String args[])
	{
		System.out.println("Welcome to FKPayroll System. Read Below options:");
		while(true)
		{
			System.out.println("Press 1 to Add employee");
			System.out.println("Press 2 to Delete employee");
			System.out.println("Press 3 to Post TimeCard");
			System.out.println("Press 4 to Post Sales receipt");
			System.out.println("Press 5 to Post Union Charges");
			System.out.println("Press 6 to Change Employee Details");
			System.out.println("Press 7 to Run Payroll till any Particular Date");
			System.out.println("Press anything else to exit");
			
			int choice;
			Scanner sc=new Scanner(System.in);
			choice=sc.nextInt();
			switch(choice)
			{
				case 1:System.out.println("Enter Name ,address,payment method(int)");
					   String name=sc.next();
					   String address=sc.next();
					   int paymentMethod=sc.nextInt();
					   System.out.println("Enter Union number. Press 0 if doesnt belong to union");
					   int union=sc.nextInt();
					   double unionrate=0;
					   if(union!=0)
					   {
						System.out.println("Enter Union Weekly Rate");
						unionrate=sc.nextDouble();
					   }
					   System.out.println("Enter 1 for hourly salaried and 2 for Salaried 3 if Salaried can be commissioned");
					   int ch=sc.nextInt();
					   Employee e;
					   if(ch==1)
					   {
							System.out.println("Enter hourly rate");
							double rate=sc.nextDouble();
							e = AddEmployee.addHourlyEmployee(name,address, union,unionrate,paymentMethod, (LocalDate.now()).with(TemporalAdjusters.next(DayOfWeek.FRIDAY)), rate);
						}
					   else if(ch==2)
					   {
							System.out.println("Enter monthly salary");
							double salary=sc.nextDouble();
							e = AddEmployee.addSalaryEmployee(name,address, union,unionrate,paymentMethod, (LocalDate.now()).with(TemporalAdjusters.next(DayOfWeek.FRIDAY)), salary);
					   }
					   else
					   {
							System.out.println("Enter monthly salary");
							double salary=sc.nextDouble();
							System.out.println("Enter commision in fraction");
							double commission=sc.nextDouble();
							e = AddEmployee.addCommissionedEmployee(name,address, union,unionrate,paymentMethod, (LocalDate.now()).with(TemporalAdjusters.next(DayOfWeek.FRIDAY)), salary,commission);
					   }
					   System.out.println("Employee record Added with EMPLOYEE ID: " + e.empID);
					   break;
				case 2:System.out.println("Enter employee id to delete");
					   int empid=sc.nextInt();
					   DeleteEmployee.delete(empid);
					   System.out.println("Employee record deleted\n");
					   break;
				case 3:System.out.println("Enter employee id and Number of Hours");
					   empid=sc.nextInt();
					   double hours=sc.nextDouble();
					   AddTimeCard.add(empid,LocalDate.now(),hours);
					   System.out.println("Time Card Added");
					   break;
				case 4:System.out.println("Enter Employee id and Amount of Sale");
					   empid=sc.nextInt();
					   double sale=sc.nextDouble();
					   AddSalesCard.add(empid,LocalDate.now(),sale);
					   System.out.println("Sales Receipt Added");
					   break;
				case 5:System.out.println("Enter employee id and reason of deduction and amount of deductions");
					   empid=sc.nextInt();
					   String desc=sc.next();
					   double amount=sc.nextDouble();
					   AddUnionCharges.add(empid,LocalDate.now(), desc, amount);
					   System.out.println("Union Charges for "+ desc+ "added for deductions");
					   break;
				case 6:	System.out.println("Press 1 to change name");
						System.out.println("Press 2 to change address");
						System.out.println("Press 3 to change union");
						System.out.println("Press 4 to change union charges");
						System.out.println("Press 5 to change hour rate");
						System.out.println("Press 6 to change commission rate");
						System.out.println("Press 7 to change dues rate");
						int cch=sc.nextInt();
						switch(cch)
						{
							case 1:System.out.println("Enter id and new name");
								   int eid=sc.nextInt();
								   String newName=sc.next();
								   ChangeEmployee.changeName(eid,newName);
								   System.out.println("Name Changed");
								   break;
							
							case 2:System.out.println("Enter id and new address");
								   eid=sc.nextInt();
								   String newAddr=sc.next();
								   ChangeEmployee.changeAddress(eid,newAddr);
								   System.out.println("Address Changed");
								   break;
							case 3:System.out.println("Enter id and new union");
								   eid=sc.nextInt();
								   int newunion=sc.nextInt();
								   ChangeEmployee.changeUnionStatus(eid,newunion);
								   System.out.println("Union Changed");
								   break;
							case 4:System.out.println("Enter id and new union charges");
								   eid=sc.nextInt();
								   double unionc=sc.nextDouble();
								   ChangeEmployee.changeUnionCharges(eid,unionc);
								   System.out.println("Union Charges Changed");
								   break;
							case 5:System.out.println("Enter id and new hour rate");
								   eid=sc.nextInt();
								   double newRate=sc.nextDouble();
								   ChangeEmployee.changeHourRate(eid,newRate);
								   System.out.println("Hour Rate Changed");
								   break;
							case 6:System.out.println("Enter id and new commission rate");
								   eid=sc.nextInt();
								   newRate=sc.nextDouble();
								   ChangeEmployee.changeHourRate(eid,newRate);
								   System.out.println("Commission Rate Changed");
								   break;
							case 7:System.out.println("Enter id and new Method Payment");
								   eid=sc.nextInt();
								   int nweMethod=sc.nextInt();
								   ChangeEmployee.methodOfPayment(eid,nweMethod);
								   System.out.println("Mode Of Payment Changed");
								   break;
							default:System.out.println("Wrong Choice");
									break;
						}
						break;
				case 7:System.out.println("Enter the Date till which you want to run in dd/MM/yyyy");
					String date=sc.next();
					DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate dateinp = LocalDate.parse(date, dateFormat);
					// PayRoll.run(LocalDate.now());
					PayRoll.run(dateinp);

	                break;
				default:System.exit(0);
			}

		}
	}
}