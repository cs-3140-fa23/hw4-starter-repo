package sde.virginia.edu.hw4;

import java.time.DayOfWeek;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a time slot for a class, such as MWF 14:00-14:50 (Monday, Wednesday, and Friday starting at 14:00 [2p.m.])
 * @param days days of the week the class meets as a Set of {@link DayOfWeek}
 * @param startTimeHour the start time of the class as an hour, using 24-hour time (0-23 inclusive)
 * @param startTimeMinute the start time of the class a minute (0-59 inclusive)
 * @param endTimeHour the end time of the class as an hour, using 24-hour time (0-23 inclusive)
 * @param endTimeMinute the end time of the class as a minute (0-59 inclusive)
 */
public record TimeSlot(Set<DayOfWeek> days, int startTimeHour, int startTimeMinute,
                       int endTimeHour, int endTimeMinute) {
    public static final Set<DayOfWeek> MONDAY_WEDNESDAY_FRIDAY =
            Set.of(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY);
    public static final Set<DayOfWeek> TUESDAY_THURSDAY =
            Set.of(DayOfWeek.TUESDAY, DayOfWeek.THURSDAY);

    public TimeSlot {
        if (days == null) {
            throw new IllegalArgumentException("Cannot make a TimeSlot with null days");
        }
        if (days.isEmpty()) {
            throw new IllegalArgumentException("Cannot make a TimeSlot with no days");
        }
        var startTimeInMinutes = getTimeInMinutes(startTimeHour, startTimeMinute);
        var endTimeInMinutes = getTimeInMinutes(endTimeHour, endTimeMinute);
        if (endTimeInMinutes < startTimeInMinutes) {
            throw new IllegalArgumentException("Invalid TimeSlot: End Time earlier than Start Time");
        }
    }

    @Override
    public Set<DayOfWeek> days() {
        return Collections.unmodifiableSet(days);
    }

    public boolean overlapsWith(TimeSlot other) {
        var thisDays = new HashSet<DayOfWeek>(this.days);
        var otherDays = new HashSet<DayOfWeek>(other.days);
        thisDays.retainAll(otherDays);
        if (thisDays.isEmpty()) {
            return false;
        }
        var thisStartTime = getTimeInMinutes(startTimeHour, startTimeMinute);
        var thisEndTime = getTimeInMinutes(endTimeHour, endTimeMinute);
        var otherStartTime = getTimeInMinutes(other.startTimeHour, other.startTimeMinute);
        var otherEndTime = getTimeInMinutes(other.endTimeHour, other.endTimeMinute);

        return  (otherStartTime <= thisStartTime && thisStartTime < otherEndTime) ||
                (thisStartTime <= otherStartTime && otherStartTime < thisEndTime);
    }

    private static int getTimeInMinutes(int hour, int minutes) {
        return 60 * hour + minutes;
    }
}
