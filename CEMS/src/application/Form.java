package application;
import java.util.HashMap;
import java.util.Map;

public abstract class Form {
	
	/*form children include: 
	 * ExpenditureForm
	 * EventBudgetForm
	 * ClubBudgetForm
	 * UserForm
	 * ClubForm
	 * EmailForm
	 * EventForm
	 * LoginForm
	 * ForgotPasswordForm
	 */
	
	
	protected static int COUNT_FOR_IDS = 0;
	
	public abstract void addField(HashMap<Object, Object> requestData);
	
	public abstract Object getField(Object Key);
	public abstract void setField(HashMap<Object, Object> requestData);
	
	protected abstract boolean delete(HashMap<Object, Object> requestData);
	
	
}
