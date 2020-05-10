import java.time.LocalDate;  

public class SalesCard implements Comparable<TimeCard>{
	static int lastid=0;
	int cardId;
	int empId;
	LocalDate date;
	double saleAmount;

	public TimeCard(int empId,LocalDate date, Double amount)
	{
		cardId=lastid+1;
		lastid+=cardId;
		this.empId=empId;
		this.date=date;
		this.saleAmount=amount;
	}

	@Override
    public int compareTo(TimeCard card) {
        int dateOrder = date.compareTo(card.date);
	    if (dateOrder != 0) return dateOrder;
	    int idOrder = cardId-card.cardId;
	    if (idOrder != 0) return idOrder;
	    return 0;
    }

}