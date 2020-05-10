import java.util.*;
import java.io.IOException;
import java.io.FileWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Database{

	private static HashMap<Integer,Employee> employees = new HashMap<Integer,Employee>();
	static void writeEmployee()
	{
		Gson gson = new Gson();
        String json = gson.toJson(employees);
        try
        {
            FileWriter file = new FileWriter("EmployeData.json");
            file.write(json);
            file.close();
        }
        catch (IOException e) 
        {
             e.printStackTrace();
        }
	}

	static void addEmployee(Employee emp)
	{
		employees.put(emp.empID, emp);
        writeEmployee();
	}

	static Employee getEmployee(int empID){return employees.get(empID);}

	static void deleteEmployee(int empID)
	{
		employees.remove(empID);
		writeEmployee();        
	}

	static PriorityQueue<TimeCard> cardsSorted = new PriorityQueue<TimeCard>(100);

	static void writeTimeCards()
	{
		Gson gson = new Gson();
        String json = gson.toJson(cardsSorted);
        try
        {
            FileWriter file = new FileWriter("TimeCards.json");
            file.write(json);
            file.close();
        }
        catch (IOException e) 
        {
             e.printStackTrace();
        }
	}

	static void addCard(TimeCard card)
	{
		cardsSorted.add(card);
		writeTimeCards();
	}

	static PriorityQueue<SalesCard> salesSorted = new PriorityQueue<SalesCard>(100);

	static void writeSalesCards()
	{
		Gson gson = new Gson();
        String json = gson.toJson(salesSorted);
        try
        {
            FileWriter file = new FileWriter("SalesReceipt.json");
            file.write(json);
            file.close();
        }
        catch (IOException e) 
        {
             e.printStackTrace();
        }
	}

	static void addReceipt(SalesCard receipt)
	{
		salesSorted.add(receipt);
		writeSalesCards();
	}



}