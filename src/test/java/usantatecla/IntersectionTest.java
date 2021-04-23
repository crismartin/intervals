package usantatecla;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class IntersectionTest {

    @Test
    public void givenTwoIntervalsClosedWhenOnePointOfIntervalBInsideInIntervalAthenTrue(){
        Interval intervalA = new IntervalBuilder().closed(0).closed(10).build();
        Interval intervalB = new IntervalBuilder().closed(-5).closed(0).build();
        assertTrue(new Intersection(intervalA, intervalB).exist());
    }
}
