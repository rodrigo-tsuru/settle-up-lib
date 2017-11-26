package cz.destil.settleup;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import cz.destil.settleup.data.model.Member;
import cz.destil.settleup.data.model.Payment;
import cz.destil.settleup.util.DebtCalculator;
import cz.destil.settleup.util.DebtCalculator.Debt;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Test mutual same amount payment
     */
    public void testMutualPayments()
    {
    	String currency = "BRL";
    	
    	List<Member> members = new ArrayList<Member>();
    	members.add(new Member(1L,"Rodrigo","a@bc.com",1L,"Bank Account"));
    	members.add(new Member(2L,"Priscilla","b@bc.com",1L,"Bank Account"));
    	
    	List<Payment> payments = new ArrayList<Payment>();
    	payments.add(new Payment("1","2","Pagamento","1","1",Calendar.getInstance().getTimeInMillis(),"BRL",false,1L,""));
    	
    	payments.add(new Payment("1","1","Pagamento","2","1",Calendar.getInstance().getTimeInMillis(),"BRL",false,1L,""));
    	
    	DebtCalculator.updateBalances(members, payments, currency);	
    	
    	BigDecimal tolerance = BigDecimal.valueOf(0);    	
    	
    	List<Debt> results = DebtCalculator.calculate(members, tolerance, currency);
    	
    	for (Debt debt : results) {
			System.out.println("Debt: " + debt);
		}
    	
        assertTrue( results.isEmpty() );
    }
    
    /**
     * Test mutual same amount payment
     */
    public void testApp()
    {
    	String currency = "BRL";
    	
    	List<Member> members = new ArrayList<Member>();
    	members.add(new Member(1L,"Marcela","a@bc.com",1L,"Bank Account"));
    	members.add(new Member(2L,"Shoiti","b@bc.com",1L,"Bank Account"));
    	members.add(new Member(3L,"Miyuki","b@bc.com",1L,"Bank Account"));
    	members.add(new Member(4L,"Sato","b@bc.com",1L,"Bank Account"));
    	members.add(new Member(5L,"Celene","b@bc.com",1L,"Bank Account"));
    	members.add(new Member(6L,"Yanai","b@bc.com",1L,"Bank Account"));
    	members.add(new Member(7L,"Hidemi","b@bc.com",1L,"Bank Account"));
    	members.add(new Member(8L,"Paula","b@bc.com",1L,"Bank Account"));
    	members.add(new Member(9L,"Wlad","b@bc.com",1L,"Bank Account"));
    	members.add(new Member(10L,"Shigueo","b@bc.com",1L,"Bank Account"));
    	members.add(new Member(11L,"Mirian","b@bc.com",1L,"Bank Account"));
    	members.add(new Member(12L,"Takae","b@bc.com",1L,"Bank Account"));
    	members.add(new Member(13L,"Hanashiro","b@bc.com",1L,"Bank Account"));
    	members.add(new Member(14L,"Tsuru","b@bc.com",1L,"Bank Account"));
    	members.add(new Member(15L,"Priscilla","b@bc.com",1L,"Bank Account"));
    	
    	List<Payment> payments = new ArrayList<Payment>();
    	payments.add(new Payment("59.8","1 2 3 4 5 6 7 8 9 10 11 12 13 14 15","Pagamento","1","1",Calendar.getInstance().getTimeInMillis(),"BRL",false,1L,""));
    	
    	payments.add(new Payment("216.76","1 2 3 4 5 6 7 8 9 10 11 12 13 14 15","Pagamento","2","1",Calendar.getInstance().getTimeInMillis(),"BRL",false,1L,""));
    	
    	payments.add(new Payment("338","1 2 3 4 5 6 7 8 9 10 11 12 13 14 15","Pagamento","4","1",Calendar.getInstance().getTimeInMillis(),"BRL",false,1L,""));
    	
    	payments.add(new Payment("277.73","1 2 3 4 5 6 7 8 9 10 11 12 13 14 15","Pagamento","6","1",Calendar.getInstance().getTimeInMillis(),"BRL",false,1L,""));
    	
    	payments.add(new Payment("263","1 2 3 4 5 6 7 8 9 10 11 12 13 14 15","Pagamento","8","1",Calendar.getInstance().getTimeInMillis(),"BRL",false,1L,""));
    	
    	DebtCalculator.updateBalances(members, payments, currency);	
    	
    	BigDecimal tolerance = BigDecimal.valueOf(0);    	
    	
    	List<Debt> results = DebtCalculator.calculate(members, tolerance, currency);
    	
    	for (Debt debt : results) {
			System.out.println("Debt: " + debt);
		}
    	
        assertTrue( results.isEmpty() );
    }
}
