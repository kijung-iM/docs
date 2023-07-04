package whatap.agent.api.weaving;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ java.lang.annotation.ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Weaving {
	String match() default "class";
	String name() default "";
	String prefix() default "";
}
