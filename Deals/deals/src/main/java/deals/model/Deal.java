package deals.model;

import java.sql.Timestamp;
import javax.persistence.*;

@Entity
@Table(name = "deal")
public class Deal {
	
	@Column(name = "DealID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int DealID;
	
	@Column(name = "FromCurrencyID")
	private int FromCurrencyID;
	
	@Column(name = "ToCurrencyID")
	private int ToCurrencyID;
	
	@Column(name = "DealDate")
	private Timestamp DealDate;
	
	@Column(name = "DealAmount")
	private double DealAmount;
	
	@Column(name = "CreatedBy")
	private int CreatedBy;
	
	@Column(name = "CreationDate")
	private Timestamp CreationDate;
	
	@Column(name = "ModifiedBy")
	private int ModifiedBy;
	
	@Column(name = "ModificationDate")
	private Timestamp ModificationDate;
	
	public Deal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Deal(int dealID, int fromCurrencyID, int toCurrencyID, Timestamp dealDate, double dealAmount, int createdBy,
			Timestamp creationDate, int modifiedBy , Timestamp modificationDate) {
		super();
		DealID = dealID;
		FromCurrencyID = fromCurrencyID;
		ToCurrencyID = toCurrencyID;
		DealDate = dealDate;
		DealAmount = dealAmount;
		CreatedBy = createdBy;
		CreationDate = creationDate;
		ModifiedBy = modifiedBy;
		ModificationDate = modificationDate;
	}
	public int getDealID() {
		return DealID;
	}
	public void setDealID(int dealID) {
		DealID = dealID;
	}
	public int getFromCurrencyID() {
		return FromCurrencyID;
	}
	public void setFromCurrencyID(int fromCurrencyID) {
		FromCurrencyID = fromCurrencyID;
	}
	public int getToCurrencyID() {
		return ToCurrencyID;
	}
	public void setToCurrencyID(int toCurrencyID) {
		ToCurrencyID = toCurrencyID;
	}
	public Timestamp getDealDate() {
		return DealDate;
	}
	public void setDealDate(Timestamp dealDate) {
		DealDate = dealDate;
	}
	public double getDealAmount() {
		return DealAmount;
	}
	public void setDealAmount(double dealAmount) {
		DealAmount = dealAmount;
	}
	public int getCreatedBy() {
		return CreatedBy;
	}
	public void setCreatedBy(int createdBy) {
		CreatedBy = createdBy;
	}
	public Timestamp getCreationDate() {
		return CreationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		CreationDate = creationDate;
	}
	public int getModifiedBy() {
		return ModifiedBy;
	}
	public void setModifiedBy(int modifiedBy) {
		ModifiedBy = modifiedBy;
	}
	public Timestamp getModificationDate() {
		return ModificationDate;
	}
	public void setModificationDate(Timestamp modificationDate) {
		ModificationDate = modificationDate;
	}

	
	
	
	

}
