package lesson_04_design_patterns.alarm_radio;

import lombok.experimental.Delegate;

/**
 * @author Greg Adler
 */
public class RadioAlarm implements Alarm, Radio {
    @Delegate
    private Radio radio;
    @Delegate(excludes = AlarmExclusion.class)
    private Alarm alarm;

    @Override
    public void c() {
        
    }
}
