package deals.app;

import java.sql.Timestamp;

import deals.dao.DealDao;
import deals.model.Deal;

public class App {
	
	public static void main(String[] args) {
		
		
		DealDao dealDao = new DealDao();
		Deal deal = new Deal(1,1,2,new Timestamp(System.currentTimeMillis()),5000,1,new Timestamp(System.currentTimeMillis()),
				new Integer(null).intValue(),null);
		int pError = dealDao.saveDeal(deal);
		if(pError == -1)
		{
			System.out.print("Deal Date is not valid");
		}
		
		if(dealDao.getDeal(deal.getFromCurrencyID(), deal.getToCurrencyID(), deal.getDealDate(), deal.getDealAmount()))
		{
			System.out.print("Request is duplicated");
		}
		
	}
	
	

}
