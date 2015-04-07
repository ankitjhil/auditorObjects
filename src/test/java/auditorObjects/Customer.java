package auditorObjects;

import br.com.auditor.Auditable;
import br.com.auditor.Description;

public class Customer implements Auditable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private int age;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Description(name="Customer Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
