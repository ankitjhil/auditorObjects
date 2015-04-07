package auditorObjects;

import static org.junit.Assert.*;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.junit.Test;

import br.com.auditor.Auditor;
import br.com.auditor.PropertiesChanged;

/**
 * Class tester to class {@link Auditor}
 * @author francislei
 *
 */
public class AuditorTest {

	@Test
	public void testCompareBeans() throws IllegalAccessException, InvocationTargetException, IntrospectionException{
		Customer customer1 = new Customer();
		customer1.setAge(10);
		customer1.setName("Fulano");
		
		Customer customer2 = new Customer();
		customer2.setAge(20);
		customer2.setName("Beltrano");
		
		List<PropertiesChanged> changes = Auditor.compare(customer1, customer2);
		
		assertFalse(changes.isEmpty());
		
		final String firstResult = "[attribute: age | before: 10 | after: 20 | nickNameAttribute: ]";
		assertEquals(firstResult, changes.get(0).toString());
		
		final String secondResult = "[attribute: name | before: Fulano | after: Beltrano | nickNameAttribute: Customer Name]";
		assertEquals(secondResult, changes.get(1).toString());
	}
}