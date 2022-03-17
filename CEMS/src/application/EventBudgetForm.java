package application;

import java.util.HashMap;

public class EventBudgetForm extends Form{

	private double subtotal;
	private double taxes;
	private double total;
	
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public double getTaxes() {
		taxes = subtotal * 0.13;
		return taxes;
	}
	public void setTaxes(double taxes) {
		this.taxes = taxes;
	}
	public double getTotal() {
		total = subtotal + taxes;
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public void addField(HashMap<Object, Object> requestData) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Object getField(Object Key) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setField(HashMap<Object, Object> requestData) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected boolean delete(HashMap<Object, Object> requestData) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
