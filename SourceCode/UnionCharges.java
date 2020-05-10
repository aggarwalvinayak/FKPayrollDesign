import java.time.LocalDate;  

public class UnionCharges implements Comparable<UnionCharges>
{
	static int lastbill=0;
	int billno;
	int empId;
	LocalDate date;
	String chargeDesc;
	Double amount;

	public UnionCharges(int empId,LocalDate date,String desc, Double amount)
	{
		billno=lastbill+1;
		lastbill=billno;
		this.empId=empId;
		this.date=date;
		this.amount=amount;
		this.chargeDesc=desc;
	}

	@Override
    public int compareTo(UnionCharges card) {
        int dateOrder = date.compareTo(card.date);
	    if (dateOrder != 0) return dateOrder;
	    int idOrder = billno-card.billno;
	    if (idOrder != 0) return idOrder;
	    return 0;
    }
}