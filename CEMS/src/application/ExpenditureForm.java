package application;
import java.util.HashMap;

public class ExpenditureForm extends Form{

	private HashMap<String, Double> formfields;
//	FormField<String, Double> amount;
	private static int formID;
	private boolean isFilled;
	private Expenditure expenditure;
	
	ExpenditureForm(){
		this.formfields = new HashMap<String, Double>();
		this.formID = ++super.COUNT_FOR_IDS;
		
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void addField(FormField formfield) {
		
		formfields.put((String)formfield.getKey(), (Double)formfield.getValue());
		
	}

	@Override
	public Object getField(Object key) {
		return formfields.get(key);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void setField(FormField formfield) {
		//Check if field already has a value, if it does, replace with new data
		if(formfields.get(formfield.getKey()) != null) {
			formfields.remove(formfield.getKey());
		}
		addField(formfield);
		
	}
	
	public boolean isFilled() {
		//iterate through all of the fields, check if mandatory fields are filled, then return true or false accordingly
		
		
		return isFilled;
	}

}
