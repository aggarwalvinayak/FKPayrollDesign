import java.time.LocalDate;  

public class TimeCard implements Comparable<TimeCard>{
	static int lastid=0;
	int cardId;
	int empId;
	LocalDate date;
	double hours;

	public TimeCard(int empId,LocalDate date, Double hours)
	{
		cardId=lastid+1;
		lastid+=cardId;
		this.empId=empId;
		this.date=date;
		this.hours=hours;
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