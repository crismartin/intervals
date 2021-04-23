package usantatecla;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class IntersectionTest {

    @Test
    public void givenTwoIntervalsClosedWhenMaxPointOfIntervalBEqualsMinPointIntervalAThenTrue(){
        Interval intervalA = new IntervalBuilder().closed(0).closed(10).build();
        Interval intervalB = new IntervalBuilder().closed(-5).closed(0).build();
        assertTrue(intervalA.hasIntersection(intervalB));
    }

    @Test
    public void givenTwoIntervalsClosedWhenMaxPointOfIntervalBGreatherThanMinPointIntervalAThenTrue(){
        Interval intervalA = new IntervalBuilder().closed(0).closed(10).build();
        Interval intervalB = new IntervalBuilder().closed(-5).closed(1).build();
        assertTrue(intervalA.hasIntersection(intervalB));
    }

    @Test
    public void givenTwoIntervalsClosedWhenNonePointOfIntervalBInsideInIntervalAThenTrue(){
        Interval intervalA = new IntervalBuilder().closed(0).closed(10).build();
        Interval intervalB = new IntervalBuilder().closed(-5).closed(-1).build();
        assertFalse(intervalA.hasIntersection(intervalB));
    }

    @Test
    public void givenTwoIntervalsClosedWhenMinPointOfIntervalBEqualsMaxPointIntervalAThenTrue(){
        Interval intervalA = new IntervalBuilder().closed(0).closed(10).build();
        Interval intervalB = new IntervalBuilder().closed(10).closed(15).build();
        assertTrue(intervalA.hasIntersection(intervalB));
    }
}
