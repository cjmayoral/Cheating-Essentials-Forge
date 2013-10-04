package common.kodehawa.ce.event;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;

@SupportedSourceVersion(SourceVersion.RELEASE_5)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

public @interface Listener {

	/*
	 * What event to load now?
	 */
	Class<? extends Object> eventToLoad();
	
}
