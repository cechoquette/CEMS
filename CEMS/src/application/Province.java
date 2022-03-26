package CEMS.src.application;

import java.util.ArrayList;

public enum Province {

	ALBERTA("Alberta", 0.00),
	BRITISH_COLUMBIA("British-Columbia", 0.07),
	MANITOBA("Manitoba", 0.07),
	NEW_BRUNSWICK("New-Brunswick", 0.10),
	NEWFOUNDLAND_LABRADOR("Newfoundland and Labrador", 0.10),
	NORTHWEST_TERRITORIES("Northwest Territories", 0.00),
	NOVA_SCOTIA("Nova-Scotia", 0.10),
	NUNAVUT("Nunavut", 0.00),
	ONTARIO("Ontario", 0.08),
	PRINCE_EDWARD_ISLAND("Prince Edward Island", 0.10),
	QUEBEC("Quebec", 0.0975),
	SASKATCHEWAN("Saskatchewan", 0.06),
	YUKON("Yukon", 0.00);
	
	private String province;
	private Double taxRate;
	
	Province(String province, Double taxRate){
		this.province = province;
		this.taxRate = taxRate;
	}
	
	public String getProvince() {
		return province;
	}

	public Double getTaxRate() {
		return taxRate;
	}

	@Override
	public String toString() {
		return province;
	}
	
}


