package usantatecla;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntersectionTest {

    private Point[] intervalA;
    private Point[] intervalB;
    private IntervalBuilder intervalBuilderA;
    private IntervalBuilder intervalBuilderB;

    private static final int max = 1;
    private static final int min = 0;

    private Point minIntervalB;
    private Point maxIntervalB;

    @BeforeEach
    public void before() {
        this.intervalA = new Point[]{new Point(0), new Point(10)};
        this.intervalB = new Point[]{new Point(0), new Point(10)};
    }

    @Test
    public void givenTwoIntervalsOpenWhenCompareMaxPointOfIntervalBWithMinPointIntervalA() {
        minIntervalB = new Point(-5);
        maxIntervalB = new Point(0.2);

        Interval intervalA = new IntervalBuilder().open(this.intervalA[min].getEquals()).open(this.intervalA[max].getEquals()).build();
        Interval intervalB = new IntervalBuilder().open(minIntervalB.getEquals()).open(maxIntervalB.getEquals()).build();
        assertTrue(intervalA.hasIntersection(intervalB));

        intervalB = new IntervalBuilder().open(minIntervalB.getEquals()).open(maxIntervalB.getLess()).build();
        assertFalse(intervalA.hasIntersection(intervalB));

        intervalB = new IntervalBuilder().open(minIntervalB.getEquals()).open(maxIntervalB.getGreater()).build();
        assertTrue(intervalA.hasIntersection(intervalB));
    }

    @Test
    public void givenTwoIntervalsOpenWhenCompareMinPointOfIntervalBWithMaxPointIntervalA() {
        minIntervalB = new Point(9.8);
        maxIntervalB = new Point(15);

        Interval intervalA = new IntervalBuilder().open(this.intervalA[min].getEquals()).open(this.intervalA[max].getEquals()).build();
        Interval intervalB = new IntervalBuilder().open(minIntervalB.getEquals()).open(maxIntervalB.getEquals()).build();
        assertTrue(intervalA.hasIntersection(intervalB));

        intervalB = new IntervalBuilder().open(minIntervalB.getLess()).open(maxIntervalB.getEquals()).build();
        assertTrue(intervalA.hasIntersection(intervalB));

        intervalB = new IntervalBuilder().open(minIntervalB.getGreater()).open(maxIntervalB.getEquals()).build();
        assertFalse(intervalA.hasIntersection(intervalB));
    }

    @Test
    public void givenTwoIntervalsOpenWhenIntervalAContainsIntervalBThenTrue() {
        minIntervalB = new Point(0);
        maxIntervalB = new Point(10);
        Interval intervalA = new IntervalBuilder().open(this.intervalA[min].getEquals()).open(this.intervalA[max].getEquals()).build();
        Interval intervalB = new IntervalBuilder().open(minIntervalB.getEquals()).open(maxIntervalB.getEquals()).build();
        assertTrue(intervalA.hasIntersection(intervalB));
    }

    @Test
    public void givenIntervalAOpenClosedAndIntervalBClosedClosedWhenCompareMaxPointOfIntervalBWithMinPointIntervalA() {
        minIntervalB = new Point(-5);
        maxIntervalB = new Point(0.1);

        Interval intervalA = new IntervalBuilder().open(this.intervalA[min].getEquals()).closed(this.intervalA[max].getEquals()).build();
        Interval intervalB = new IntervalBuilder().closed(minIntervalB.getEquals()).closed(maxIntervalB.getEquals()).build();
        assertTrue(intervalA.hasIntersection(intervalB));

        intervalB = new IntervalBuilder().closed(minIntervalB.getEquals()).closed(maxIntervalB.getLess()).build();
        assertFalse(intervalA.hasIntersection(intervalB));

        intervalB = new IntervalBuilder().closed(minIntervalB.getEquals()).closed(maxIntervalB.getGreater()).build();
        assertTrue(intervalA.hasIntersection(intervalB));
    }

    @Test
    public void givenIntervalAOpenClosedAndIntervalBClosedClosedWhenCompareMinPointOfIntervalBWithMaxPointIntervalA() {
        minIntervalB = new Point(10);
        maxIntervalB = new Point(15);

        Interval intervalA = new IntervalBuilder().open(this.intervalA[min].getEquals()).closed(this.intervalA[max].getEquals()).build();
        Interval intervalB = new IntervalBuilder().closed(minIntervalB.getEquals()).closed(maxIntervalB.getEquals()).build();
        assertTrue(intervalA.hasIntersection(intervalB));

        intervalB = new IntervalBuilder().closed(minIntervalB.getLess()).closed(maxIntervalB.getEquals()).build();
        assertTrue(intervalA.hasIntersection(intervalB));

        intervalB = new IntervalBuilder().closed(minIntervalB.getGreater()).closed(maxIntervalB.getEquals()).build();
        assertFalse(intervalA.hasIntersection(intervalB));
    }

    @Test
    public void givenIntervalAOpenClosedAndIntervalBClosedClosedWhenIntervalAContainsIntervalB() {
        minIntervalB = new Point(0.1);
        maxIntervalB = new Point(10);

        Interval intervalA = new IntervalBuilder().open(this.intervalA[min].getEquals()).closed(this.intervalA[max].getEquals()).build();
        Interval intervalB = new IntervalBuilder().closed(minIntervalB.getEquals()).closed(maxIntervalB.getEquals()).build();
        assertTrue(intervalA.hasIntersection(intervalB));

        intervalB = new IntervalBuilder().closed(minIntervalB.getLess()).closed(maxIntervalB.getGreater()).build();
        assertTrue(intervalA.hasIntersection(intervalB));

        intervalB = new IntervalBuilder().closed(minIntervalB.getGreater()).closed(maxIntervalB.getLess()).build();
        assertTrue(intervalA.hasIntersection(intervalB));
    }


    @Test
    public void givenIntervalAClosedOpenAndIntervalBClosedOpenWhenCompareMaxPointOfIntervalBWithMinPointIntervalA() {
        minIntervalB = new Point(-5);
        maxIntervalB = new Point(0.1);

        Interval intervalA = new IntervalBuilder().closed(this.intervalA[min].getEquals()).open(this.intervalA[max].getEquals()).build();
        Interval intervalB = new IntervalBuilder().closed(minIntervalB.getEquals()).open(maxIntervalB.getEquals()).build();
        assertTrue(intervalA.hasIntersection(intervalB));

        intervalB = new IntervalBuilder().closed(minIntervalB.getEquals()).open(maxIntervalB.getLess()).build();
        assertFalse(intervalA.hasIntersection(intervalB));

        intervalB = new IntervalBuilder().closed(minIntervalB.getEquals()).open(maxIntervalB.getGreater()).build();
        assertTrue(intervalA.hasIntersection(intervalB));
    }

    @Test
    public void givenIntervalAClosedOpenAndIntervalBClosedOpenWhenCompareMinPointOfIntervalBWithMaxPointIntervalA() {
        minIntervalB = new Point(9.9);
        maxIntervalB = new Point(15);

        Interval intervalA = new IntervalBuilder().closed(this.intervalA[min].getEquals()).open(this.intervalA[max].getEquals()).build();
        Interval intervalB = new IntervalBuilder().closed(minIntervalB.getEquals()).open(maxIntervalB.getEquals()).build();
        assertTrue(intervalA.hasIntersection(intervalB));

        intervalB = new IntervalBuilder().closed(minIntervalB.getLess()).open(maxIntervalB.getEquals()).build();
        assertTrue(intervalA.hasIntersection(intervalB));

        intervalB = new IntervalBuilder().closed(minIntervalB.getGreater()).open(maxIntervalB.getEquals()).build();
        assertFalse(intervalA.hasIntersection(intervalB));
    }

    @Test
    public void givenIntervalAClosedOpenAndIntervalBClosedOpenWhenIntervalAContainsIntervalBThenTrue() {
        minIntervalB = new Point(0);
        maxIntervalB = new Point(10);

        Interval intervalA = new IntervalBuilder().closed(this.intervalA[min].getEquals()).open(this.intervalA[max].getEquals()).build();
        Interval intervalB = new IntervalBuilder().closed(minIntervalB.getEquals()).open(maxIntervalB.getEquals()).build();
        assertTrue(intervalA.hasIntersection(intervalB));

        intervalB = new IntervalBuilder().closed(minIntervalB.getLess()).open(maxIntervalB.getGreater()).build();
        assertTrue(intervalA.hasIntersection(intervalB));

        intervalB = new IntervalBuilder().closed(minIntervalB.getGreater()).open(maxIntervalB.getLess()).build();
        assertTrue(intervalA.hasIntersection(intervalB));
    }


    @Test
    public void givenIntervalAClosedClosedAndIntervalBOpenClosedWhenCompareMaxPointOfIntervalBWithMinPointIntervalA() {
        minIntervalB = new Point(-5);
        maxIntervalB = new Point(0);

        Interval intervalA = new IntervalBuilder().closed(this.intervalA[min].getEquals()).closed(this.intervalA[max].getEquals()).build();
        Interval intervalB = new IntervalBuilder().open(minIntervalB.getEquals()).closed(maxIntervalB.getEquals()).build();
        assertTrue(intervalA.hasIntersection(intervalB));

        intervalB = new IntervalBuilder().open(minIntervalB.getEquals()).closed(maxIntervalB.getLess()).build();
        assertFalse(intervalA.hasIntersection(intervalB));

        intervalB = new IntervalBuilder().open(minIntervalB.getEquals()).closed(maxIntervalB.getGreater()).build();
        assertTrue(intervalA.hasIntersection(intervalB));
    }


}
