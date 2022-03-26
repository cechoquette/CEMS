package CEMS.src.application;

public enum ExpenditureCategory {
	
		//TODO LONG LIST
		
		PETTY_CASH("Petty Cash");
	
		private String category;
		
		ExpenditureCategory(String category){
			this.category = category;
		}
		@Override
		public String toString() {
			return category;
		}


}
