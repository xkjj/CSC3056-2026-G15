package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class RangeTestAI {

    private Range range;

    @Before
    public void setUp() {
        range = new Range(2.0, 8.0);
    }

    // contains(double value)

    @Test
    public void testContainsValueWithinRange() {
        assertTrue("Value inside range should return true",
                range.contains(5.0));
    }

    @Test
    public void testContainsValueBelowLowerBoundary() {
        assertFalse("Value below lower bound should return false",
                range.contains(1.0));
    }

    @Test
    public void testContainsValueAtUpperBoundary() {
        assertTrue("Value equal to upper bound should be contained",
                range.contains(8.0));
    }

    // constrain(double value)

    @Test
    public void testConstrainValueWithinRange() {
        assertEquals("Value inside range should remain unchanged",
                5.0, range.constrain(5.0), 0.0000001);
    }

    @Test
    public void testConstrainValueBelowLowerBound() {
        assertEquals("Value below range should be constrained to lower bound",
                2.0, range.constrain(1.0), 0.0000001);
    }

    @Test
    public void testConstrainValueAboveUpperBound() {
        assertEquals("Value above range should be constrained to upper bound",
                8.0, range.constrain(10.0), 0.0000001);
    }

    // intersects(double lower, double upper)

    @Test
    public void testIntersectsPartialOverlap() {
        assertTrue("Ranges with partial overlap should intersect",
                range.intersects(6.0, 10.0));
    }

    @Test
    public void testIntersectsNoOverlap() {
        assertFalse("Ranges with no overlap should not intersect",
                range.intersects(9.0, 12.0));
    }

    @Test
    public void testIntersectsTouchingBoundary() {
        assertTrue("Ranges touching at boundary should intersect",
                range.intersects(8.0, 12.0));
    }

    // expand(Range range, double lowerMargin, double upperMargin)

    @Test
    public void testExpandPositiveMargins() {
        Range input = new Range(2.0, 6.0);
        Range result = Range.expand(input, 0.25, 0.25);

        assertEquals("Lower bound after expansion incorrect",
                1.0, result.getLowerBound(), 0.0000001);

        assertEquals("Upper bound after expansion incorrect",
                7.0, result.getUpperBound(), 0.0000001);
    }

    @Test
    public void testExpandZeroMargins() {
        Range input = new Range(2.0, 6.0);
        Range result = Range.expand(input, 0.0, 0.0);

        assertEquals(2.0, result.getLowerBound(), 0.0000001);
        assertEquals(6.0, result.getUpperBound(), 0.0000001);
    }

    // getCentralValue()

    @Test
    public void testCentralValueNormalRange() {
        Range r = new Range(2.0, 8.0);

        assertEquals("Central value incorrect",
                5.0, r.getCentralValue(), 0.0000001);
    }

    @Test
    public void testCentralValueZeroLengthRange() {
        Range r = new Range(4.0, 4.0);

        assertEquals("Central value should equal bound when range length is zero",
                4.0, r.getCentralValue(), 0.0000001);
    }
}