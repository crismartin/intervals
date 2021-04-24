package usantatecla;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntersectionTest {

    private  Point [] intervalA ;
    private  Point [] intervalB ;
    private IntervalBuilder intervalBuilderA;
    private IntervalBuilder intervalBuilderB;

    private static final int max = 1;
    private static final int min = 0;

    private Point minIntervalB;
    private Point maxIntervalB;

    @BeforeEach
    public void before(){
        this.intervalA = new Point[]{new Point(0), new Point(10)};
        this.intervalB = new Point[]{new Point(0), new Point(10)};
        this.intervalBuilderA = new IntervalBuilder();
        this.intervalBuilderB = new IntervalBuilder();

    }

    @Test
    public void givenTwoIntervalsClosedWhenCompareMaxPointOfIntervalBWithMinPointIntervalA(){
        minIntervalB = new Point(-5);
        maxIntervalB = new Point(0);
        Interval intervalA = new IntervalBuilder().closed(this.intervalA[min].getEquals()).closed(this.intervalA[max].getEquals()).build();
        Interval intervalB = new IntervalBuilder().closed(minIntervalB.getEquals()).closed(maxIntervalB.getEquals()).build();
        assertTrue(intervalA.hasIntersection(intervalB));

        intervalB = new IntervalBuilder().closed(minIntervalB.getEquals()).closed(maxIntervalB.getGreater()).build();
        assertTrue(intervalA.hasIntersection(intervalB));

        intervalB = new IntervalBuilder().closed(minIntervalB.getEquals()).closed(maxIntervalB.getLess()).build();
        assertFalse(intervalA.hasIntersection(intervalB));
    }

    @Test
    public void givenTwoIntervalsClosedWhenCompareMinPointOfIntervalBWithMaxPointIntervalA(){
        minIntervalB = new Point(10);
        maxIntervalB = new Point(15);
        Interval intervalA = new IntervalBuilder().closed(this.intervalA[min].getEquals()).closed(this.intervalA[max].getEquals()).build();
        Interval intervalB = new IntervalBuilder().closed(minIntervalB.getEquals()).closed(maxIntervalB.getEquals()).build();
        assertTrue(intervalA.hasIntersection(intervalB));

        intervalB = new IntervalBuilder().closed(minIntervalB.getLess()).closed(maxIntervalB.getEquals()).build();
        assertTrue(intervalA.hasIntersection(intervalB));

        intervalB = new IntervalBuilder().closed(minIntervalB.getGreater()).closed(maxIntervalB.getEquals()).build();
        assertFalse(intervalA.hasIntersection(intervalB));

    }

    @Test
    public void givenTwoIntervalsClosedWhenIntervalAContainsIntervalBThenTrue(){
        minIntervalB = new Point(4);
        maxIntervalB = new Point(6);
        Interval intervalA = new IntervalBuilder().closed(this.intervalA[min].getEquals()).closed(this.intervalA[max].getEquals()).build();
        Interval intervalB = new IntervalBuilder().closed(minIntervalB.getEquals()).closed(maxIntervalB.getEquals()).build();
        assertTrue(intervalA.hasIntersection(intervalB));
    }

    @Test
    public void givenTwoIntervalsOpenWhenCompareMaxPointOfIntervalBWithMinPointIntervalA(){
        minIntervalB = new Point(-5);
        maxIntervalB = new Point(0);
        Interval intervalA = new IntervalBuilder().open(this.intervalA[min].getEquals()).open(this.intervalA[max].getEquals()).build();
        Interval intervalB = new IntervalBuilder().open(minIntervalB.getEquals()).open(maxIntervalB.getEquals()).build();
        assertFalse(intervalA.hasIntersection(intervalB));

        intervalB = new IntervalBuilder().open(minIntervalB.getEquals()).open(maxIntervalB.getGreater()).build();
        assertTrue(intervalA.hasIntersection(intervalB));

        intervalB = new IntervalBuilder().open(minIntervalB.getEquals()).open(maxIntervalB.getLess()).build();
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
