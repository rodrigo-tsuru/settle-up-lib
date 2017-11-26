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
    public void testApp()
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
}
