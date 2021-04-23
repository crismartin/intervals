package usantatecla;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class IntersectionTest {

    @Test
    public void givenTwoIntervalsClosedWhenOnePointOfIntervalBInsideInIntervalAthenTrue(){
        Interval intervalA = new IntervalBuilder().closed(0).closed(10).build();
        Interval intervalB = new IntervalBuilder().closed(-5).closed(0).build();
        assertTrue(new Intersection(intervalA, intervalB).exist());
    }

    @Test
    public void givenTwoIntervalsClosedWhenNonePointOfIntervalBInsideInIntervalAthenTrue(){
        Interval intervalA = new IntervalBuilder().closed(0).closed(10).build();
        Interval intervalB = new IntervalBuilder().closed(-5).closed(-1).build();
        assertFalse(new Intersection(intervalA, intervalB).exist());
    }
}
