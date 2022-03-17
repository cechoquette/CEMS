package application;
public class BudgetForm {

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
	
	
}
