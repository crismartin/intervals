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
    public void givenTwoIntervalsClosedWhenMaxPointOfIntervalBLessThanMinPointIntervalAThenTrue(){
        Interval intervalA = new IntervalBuilder().closed(0).closed(10).build();
        Interval intervalB = new IntervalBuilder().closed(-5).closed(-1).build();
        assertFalse(intervalA.hasIntersection(intervalB));
    }

    @Test
    public void givenTwoIntervalsClosedWhenMinPointOfIntervalBEqualsMaxPointIntervalAThenTrue(){
        Interval intervalA = new IntervalBuilder().closed(0).closed(10).build();
        Interval intervalB = new IntervalBuilder().closed(10).closed(15).build();
        assertTrue(intervalA.hasIntersectionMaxWithMinB(intervalB));
    }

    @Test
    public void givenTwoIntervalsClosedWhenMinPointOfIntervalBLessThanMaxPointIntervalAThenTrue(){
        Interval intervalA = new IntervalBuilder().closed(0).closed(10).build();
        Interval intervalB = new IntervalBuilder().closed(9).closed(13).build();
        assertTrue(intervalA.hasIntersectionMaxWithMinB(intervalB));
    }

    @Test
    public void givenTwoIntervalsClosedWhenMinPointOfIntervalBGreatherThanMaxPointIntervalAThenTrue(){
        Interval intervalA = new IntervalBuilder().closed(0).closed(10).build();
        Interval intervalB = new IntervalBuilder().closed(11).closed(13).build();
        assertFalse(intervalA.hasIntersectionMaxWithMinB(intervalB));
    }

    @Test
    public void givenTwoIntervalsClosedWhenIntervalAContainsIntervalBThenTrue(){
        Interval intervalA = new IntervalBuilder().closed(0).closed(10).build();
        Interval intervalB = new IntervalBuilder().closed(4).closed(6).build();
        assertTrue(intervalA.contains(intervalB));
    }

}
