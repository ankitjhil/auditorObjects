package br.com.auditor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used to naming a attribute.
 * @author francislei
 *
 */
@Target(ElementType.METHOD)
@Retention(value=RetentionPolicy.RUNTIME)
public @interface Description {
	String name();
}