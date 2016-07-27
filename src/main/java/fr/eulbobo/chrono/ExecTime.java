package fr.eulbobo.chrono;

public class ExecTime {

    /** milli in one second */
    private static final int MILLIS_IN_ONE_SECOND = 1000;

    /** seconds in one minute */
    private static final int SECONDS_IN_ONE_MINUT = 60;

    /** minutes in one hour */
    private static final int MINUTS_IN_ONE_HOUR = 60;

    /** millis in one hour */
    private static final int MILLIS_IN_ONE_MINUT = SECONDS_IN_ONE_MINUT * MILLIS_IN_ONE_SECOND;

    /** millis in one hour */
    private static final int MILLIS_IN_ONE_HOUR = MINUTS_IN_ONE_HOUR * MILLIS_IN_ONE_MINUT;

    /** valeur des secondes */
    private final long elapsedSeconds;

    /** valeur des minutes */
    private final long elapsedMinuts;

    /** valeur des heures */
    private final long elapsedHours;

    /** valeur des millis */
    private final long elapsedMillis;

    /**
     * Default constructor
     *
     * @param elapsedTime elasped time
     */
    public ExecTime(final long elapsedTime) {
        long remainingMillis = elapsedTime;

        elapsedHours = remainingMillis / MILLIS_IN_ONE_HOUR;
        remainingMillis -= elapsedHours * MILLIS_IN_ONE_HOUR;

        elapsedMinuts = remainingMillis / MILLIS_IN_ONE_MINUT;
        remainingMillis -= elapsedMinuts * MILLIS_IN_ONE_MINUT;

        elapsedSeconds = remainingMillis / MILLIS_IN_ONE_SECOND;
        remainingMillis -= elapsedSeconds * MILLIS_IN_ONE_SECOND;

        elapsedMillis = remainingMillis;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return elapsedHours + " Heures| " + elapsedMinuts + " Minutes| " + elapsedSeconds + " Secondes| "
                + elapsedMillis + " Milisecondes";
    }

}
