package deals.dao;

import java.io.Serializable;
import java.sql.Timestamp;

import deals.model.Deal;
import deals.util.HibernateUtil;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.*;

public class DealDao {
	
	public int saveDeal(Deal deal) {
		int pError = 0;
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			
			if(deal.getDealDate().before(new Timestamp(System.currentTimeMillis())))
			{
				transaction.rollback();
				pError = -1;
				return pError;
			}
			
			// operation 1
			Object object = session.save(deal);
			
			// operation 2
			session.get(Deal.class, (Serializable) object);
			
			// commit transaction
			transaction.commit();
			pError = 1;
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				pError = 0;
			}
			e.printStackTrace();
		}
		
		return pError;
	}
	
	
	public boolean getDeal(int fromCurrencyID, int toCurrencyID, Timestamp dealDate, double dealAmount) {

		Transaction transaction = null;
		boolean isExist = false;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			String statement = " Select Deal FROM Deal D WHERE"
					+ " D.FromCurrencyID = :fromCurrencyID "
					+ " and D.ToCurrencyID = :toCurrencyID"
					+ " and D.DealDate = :dealDate"
					+ " and D.DealAmount = :dealAmount";
			Query query = (Query) session.createQuery(statement);
			query.setParameter("fromCurrencyID", fromCurrencyID);
			query.setParameter("toCurrencyID", toCurrencyID);
			query.setParameter("dealDate", dealDate);
			query.setParameter("dealAmount", dealAmount);
			List<Deal> results = query.getResultList();
			
			if (results != null && !results.isEmpty()) {
				isExist = true;
			}			
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return isExist;
	}
	
	

}
