package application;
import java.util.HashMap;
import java.util.Map;

public abstract class Form {
	
	/*form children include: 
	 * ExpenditureForm
	 * BudgetForm
	 * UserForm
	 * ClubForm
	 * EmailForm
	 * EventForm
	 * LoginForm
	 * ForgotPasswordForm
	 */
	
	
	protected static int COUNT_FOR_IDS = 0;
	
	public abstract void addField(FormField<Object, Object> formfield);
	
	public abstract Object getField(Object Key);
	public abstract void setField(FormField<Object, Object> formfield);
	
	
}
