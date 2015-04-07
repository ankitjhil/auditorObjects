package br.com.auditor;

/**
 * POJO that saves the properties changed of {@link Auditable}.
 * 
 * @author francislei
 *
 */
public class PropertiesChanged {

	private String nameOfAttribute;
	private String valueBeforeChange;
	private String valueAfterChange;
	private String nickNameAttribute;

	public PropertiesChanged(final String nameOfAttribute,
			final String valueBeforeChange, final String valueAfterChange,
			final String nickNameAttribute) {
		super();
		this.nameOfAttribute = nameOfAttribute;
		this.valueBeforeChange = valueBeforeChange;
		this.valueAfterChange = valueAfterChange;
		this.nickNameAttribute = nickNameAttribute;
	}

	public String getNameOfAttribute() {
		return nameOfAttribute;
	}

	public String getValueAfterChange() {
		return valueAfterChange;
	}

	public String getValueBeforeChange() {
		return valueBeforeChange;
	}

	@Override
	public String toString() {
		return "[attribute: " + nameOfAttribute + " | before: "
				+ valueBeforeChange + " | after: " + valueAfterChange + " | nickNameAttribute: " + nickNameAttribute + "]";
	}

	public String getNickNameAttribute() {
		return nickNameAttribute;
	}
}