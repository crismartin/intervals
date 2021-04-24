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
    public void givenTwoIntervalsClosedWhenMaxPointOfIntervalBLessThanMinPointIntervalAThenFalse(){
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

    @Test
    public void givenTwoIntervalsClosedWhenMinPointOfIntervalBLessThanMaxPointIntervalAThenTrue(){
        Interval intervalA = new IntervalBuilder().closed(0).closed(10).build();
        Interval intervalB = new IntervalBuilder().closed(9).closed(13).build();
        assertTrue(intervalA.hasIntersection(intervalB));
    }

    @Test
    public void givenTwoIntervalsClosedWhenMinPointOfIntervalBGreatherThanMaxPointIntervalAThenFalse(){
        Interval intervalA = new IntervalBuilder().closed(0).closed(10).build();
        Interval intervalB = new IntervalBuilder().closed(11).closed(13).build();
        assertFalse(intervalA.hasIntersection(intervalB));
    }

    @Test
    public void givenTwoIntervalsClosedWhenIntervalAContainsIntervalBThenTrue(){
        Interval intervalA = new IntervalBuilder().closed(0).closed(10).build();
        Interval intervalB = new IntervalBuilder().closed(4).closed(6).build();
        assertTrue(intervalA.hasIntersection(intervalB));
    }

    @Test
    public void givenTwoIntervalsOpenWhenMaxPointOfIntervalBEqualsMinPointIntervalAThenFalse(){
        Interval intervalA = new IntervalBuilder().open(0).open(10).build();
        Interval intervalB = new IntervalBuilder().open(-5).open(0).build();
        assertFalse(intervalA.hasIntersection(intervalB));
    }
    @Test
    public void givenTwoIntervalsOpenWhenMaxPointOfIntervalBGreatherThanMinPointIntervalAThenTrue(){
        Interval intervalA = new IntervalBuilder().open(0).open(10).build();
        Interval intervalB = new IntervalBuilder().open(-5).open(0.1).build();
        assertTrue(intervalA.hasIntersection(intervalB));
    }
    @Test
    public void givenTwoIntervalsOpenWhenMaxPointOfIntervalBLessThanMinPointIntervalAThenFalse(){
        Interval intervalA = new IntervalBuilder().open(0).open(10).build();
        Interval intervalB = new IntervalBuilder().open(-5).open(-0.1).build();
        assertFalse(intervalA.hasIntersection(intervalB));
    }

    @Test
    public void givenTwoIntervalsOpenWhenMinPointOfIntervalBEqualsMaxPointIntervalAThenFalse(){
        Interval intervalA = new IntervalBuilder().open(0).open(10).build();
        Interval intervalB = new IntervalBuilder().open(10).open(15).build();
        assertFalse(intervalA.hasIntersection(intervalB));
    }

    @Test
    public void givenTwoIntervalsOpenWhenMinPointOfIntervalBLessThanMaxPointIntervalAThenTrue(){
        Interval intervalA = new IntervalBuilder().open(0).open(10).build();
        Interval intervalB = new IntervalBuilder().open(9.9).open(13).build();
        assertTrue(intervalA.hasIntersection(intervalB));
    }

    @Test
    public void givenTwoIntervalsOpenWhenMinPointOfIntervalBGreatherThanMaxPointIntervalAThenFalse(){
        Interval intervalA = new IntervalBuilder().open(0).open(10).build();
        Interval intervalB = new IntervalBuilder().open(10.1).open(13).build();
        assertFalse(intervalA.hasIntersection(intervalB));
    }

    @Test
    public void givenTwoIntervalsOpenWhenIntervalAContainsIntervalBThenTrue(){
        Interval intervalA = new IntervalBuilder().open(0).open(10).build();
        Interval intervalB = new IntervalBuilder().open(0).open(10).build();
        assertTrue(intervalA.hasIntersection(intervalB));
    }

}
