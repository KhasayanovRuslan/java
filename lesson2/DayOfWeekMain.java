public enum DayOfWeek {
    MONDAY(40), TUESDAY(32), WEDNESDAY(24), THURSDAY(16), FRIDAY(8);
    
    private int hours;

    DayOfWeek (int hours) {
        this.hours = hours;
    }   

    public int getWorkingHours(DayOfWeek day) {
        System.out.println(day.hours);
    }
}
    
public class DayOfWeekMain {
    public static void main(final String[] args) {
        System.out.println(getWorkingHours(DayOfWeek.MONDAY));
    }
}