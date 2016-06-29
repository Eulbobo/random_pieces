package fr.eulbobo.chrono;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ExecTimeTest {

    @Test
    public void should_get_correct_message_when_0_millis_have_passed(){
        ExecTime batch = new ExecTime(0);

        String message = batch.toString();

        assertEquals("0 Heures| 0 Minutes| 0 Secondes| 0 Milisecondes", message);
    }

    @Test
    public void should_get_correct_message_when_2_hours_35_minuts_25second_and_525_millis_have_passed(){
        ExecTime batch = new ExecTime(
                2 * 60 * 60 * 1000l +
                35 * 60 * 1000l +
                25 * 1000l +
                525l);

        String message = batch.toString();

        assertEquals("2 Heures| 35 Minutes| 25 Secondes| 525 Milisecondes", message);
    }

    @Test
    public void should_get_correct_message_when_5_minuts_and_45second_have_passed(){
        ExecTime batch = new ExecTime(5 * 60 * 1000l + 45 * 1000l);

        String message = batch.toString();

        assertEquals("0 Heures| 5 Minutes| 45 Secondes| 0 Milisecondes", message);
    }

    @Test
    public void should_get_correct_message_when_3_minuts_have_passed(){
        ExecTime batch = new ExecTime(3 * 60 * 1000l);

        String message = batch.toString();

        assertEquals("0 Heures| 3 Minutes| 0 Secondes| 0 Milisecondes", message);
    }

    @Test
    public void should_get_correct_message_when_1000_millis_have_passed(){
        ExecTime batch = new ExecTime(1000l);

        String message = batch.toString();

        assertEquals("0 Heures| 0 Minutes| 1 Secondes| 0 Milisecondes", message);
    }

    @Test
    public void should_get_correct_message_when_100_millis_have_passed(){
        ExecTime batch = new ExecTime(100l);

        String message = batch.toString();

        assertEquals("0 Heures| 0 Minutes| 0 Secondes| 100 Milisecondes", message);
    }

    @Test
    public void should_get_correct_message_when_1_millis_have_passed(){
        ExecTime batch = new ExecTime(1l);

        String message = batch.toString();

        assertEquals("0 Heures| 0 Minutes| 0 Secondes| 1 Milisecondes", message);
    }
}
