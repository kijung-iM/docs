package org.apache.log4j.spi;

import org.apache.log4j.Level;

import org.apache.log4j.Priority;
import whatap.agent.api.weaving.Weaving;

@Weaving
public class LoggingEvent {

    // 하나의 LoggingEvent 만 수행
    public boolean weaveEvented;

    /**
     * Level of logging event. Level cannot be serializable because it
     * is a flyweight.  Due to its special seralization it cannot be
     * declared final either.
     *
     * <p> This field should not be accessed directly. You shoud use the
     * {@link #getLevel} method instead.
     *
     * @deprecated This field will be marked as private in future
     * releases. Please do not access it directly. Use the {@link
     * #getLevel} method instead.
     * */
    transient public Priority level;

    /**
     * Return the level of this event. Use this form instead of directly
     * accessing the <code>level</code> field.  */
    public Level getLevel() {
        return (Level) level;
    }
}
