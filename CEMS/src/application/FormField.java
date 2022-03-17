package application;
public class FormField<K, V> {
	
	private K key;
	private V value;
	private boolean isMandatory = false;
	

	FormField(K key, V value, boolean mandatory){
		this.key = key;
		this.value = value;
		this.isMandatory = mandatory;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
}
