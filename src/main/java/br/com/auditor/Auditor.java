package br.com.auditor;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Class responsible by execute the comparation.
 * 
 * @author francislei
 */
public final class Auditor implements Serializable {

	private static final long serialVersionUID = -1168828801800939994L;

	/**
	 * Compare the attribute value between two instances of the
	 * {@link Auditable}.
	 * 
	 * @param object1
	 * @param object2
	 * @return {@link Set} containing {@link PropertiesChanged}
	 * @throws IntrospectionException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static List<PropertiesChanged> compare(Auditable instance1,
			Auditable instance2) throws IntrospectionException,
			IllegalAccessException, InvocationTargetException {

		validateParameters(instance1, instance2);
		
		List<PropertiesChanged> attributesChanged = new ArrayList<>();
		BeanInfo beanInfo = Introspector.getBeanInfo(instance1.getClass());

		Object firstValue, secondValue;
		PropertiesChanged propertiesChanged;
		String nameOfAttribute, valueBeforeChange, valueAfterChange, nickNameAttribute = "";
		Description description;

		for (PropertyDescriptor prop : beanInfo.getPropertyDescriptors()) {
			Method getter = prop.getReadMethod();
			firstValue = getter.invoke(instance1);
			secondValue = getter.invoke(instance2);

			if ( !valueAreEquals(firstValue, secondValue)) {
				nameOfAttribute = prop.getName();
				valueBeforeChange = firstValue.toString();
				valueAfterChange = secondValue.toString();
				
				if( getter.isAnnotationPresent(Description.class) ){
					description = getter.getAnnotation(Description.class);
					nickNameAttribute = description.name();
				}
				
				propertiesChanged = new PropertiesChanged(nameOfAttribute, valueBeforeChange, valueAfterChange, nickNameAttribute);
				attributesChanged.add(propertiesChanged);
			}
		}

		return attributesChanged;
	}

	/**
	 * Verify whether two value are equals.
	 * @param firstValue
	 * @param secondValue
	 * @return true - case values are equals.
	 * 	   <br>false - otherwise.
	 */
	private static boolean valueAreEquals(Object firstValue, Object secondValue) {
		
		if( firstValue == secondValue )
			return true;
		
		return false;
	}

	/**
	 * Valid whether one of the two instances of {@link Auditable} is null.
	 * 
	 * @param object1
	 * @param object2
	 * @throws IllegalArgumentException - If one of the instances is null.
	 */
	private static void validateParameters(final Auditable object1,
			final Auditable object2) throws IllegalArgumentException{
		if (null == object1)
			throw new IllegalArgumentException("First instance is null.");

		if (null == object2)
			throw new IllegalArgumentException("Second instance is null.");
	}

}