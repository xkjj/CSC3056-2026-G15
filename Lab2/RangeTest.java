package org.jfree.data.test;
 
import static org.junit.Assert.*;
 
import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;
import org.junit.*;
 
public class RangeTest {
 
	private Range rangeObjectUnderTest;
 
	@Before
	public void setUp() throws Exception {
		rangeObjectUnderTest = new Range(-1, 1);
	}
 
	@After
	public void tearDown() throws Exception {
	}
 
	@Test
	public void testCentralValueShouldBeZero() {
		assertEquals("The central value of -1 and 1 should be 0", 0, rangeObjectUnderTest.getCentralValue(),
				0.000000001d);
	}
	
 
	// constrain(double value) tests
 
	@Test
	public void testConstrainValueBelowLowerBound() {
		Range range = new Range(3, 7);
		assertEquals("constrain: value below lower bound should return 3.0", 3.0, range.constrain(2.9), 0.0000001d);
	}
 
	@Test
	public void testConstrainValueEqualToLowerBound() {
		Range range = new Range(3, 7);
		assertEquals("constrain: value equal to lower bound should return 3.0", 3.0, range.constrain(3.0), 0.0000001d);
	}
 
	@Test
	public void testConstrainValueWithinRange() {
		Range range = new Range(3, 7);
		assertEquals("constrain: value within range should return unchanged value", 5.0, range.constrain(5.0),
				0.0000001d);
	}
 
	@Test
	public void testConstrainValueEqualToUpperBound() {
		Range range = new Range(3, 7);
		assertEquals("constrain: value equal to upper bound should return 7.0", 7.0, range.constrain(7.0), 0.0000001d);
	}
 
	@Test
	public void testConstrainValueAboveUpperBound() {
		Range range = new Range(3, 7);
		assertEquals("constrain: value above upper bound should return 7.0", 7.0, range.constrain(7.1), 0.0000001d);
	}
 
	
	
	
	// contains method test cases
 
	@Test
	public void testContainsValueBelowLowerBound() {
		Range range = new Range(3, 7);
		assertFalse("contains: value below lower bound should return false", range.contains(2.9));
	}
 
	@Test
	public void testContainsValueEqualToLowerBound() {
		Range range = new Range(3, 7);
		assertTrue("contains: value equal to lower bound should return true", range.contains(3.0));
	}
 
	@Test
	public void testContainsValueWithinRange() {
		Range range = new Range(3, 7);
		assertTrue("contains: value inside range should return true", range.contains(5.0));
	}
 
	@Test
	public void testContainsValueEqualToUpperBound() {
		Range range = new Range(3, 7);
		assertTrue("contains: value equal to upper bound should return true", range.contains(7.0));
	}
 
	@Test
	public void testContainsValueAboveUpperBound() {
		Range range = new Range(3, 7);
		assertFalse("contains: value above upper bound should return false", range.contains(7.1));
	}
	
	
	
 
	// intersects(double lower, double upper) method tests
 
	@Test
	public void testIntersectsRangeCompletelyBeforeCurrentRange() {
		Range range = new Range(3, 7);
		assertFalse("intersects: range [1,2] should not intersect [3,7]", range.intersects(1.0, 2.0));
	}
 
	@Test
	public void testIntersectsRangeOverlappingLowerBoundary() {
		Range range = new Range(3, 7);
		assertTrue("intersects: range [2,4] should intersect [3,7]", range.intersects(2.0, 4.0));
	}
 
	@Test
	public void testIntersectsRangeCompletelyInsideCurrentRange() {
		Range range = new Range(3, 7);
		assertTrue("intersects: range [4,6] should intersect [3,7]", range.intersects(4.0, 6.0));
	}
 
	@Test
	public void testIntersectsRangeOverlappingUpperBoundary() {
		Range range = new Range(3, 7);
		assertTrue("intersects: range [5,9] should intersect [3,7]", range.intersects(5.0, 9.0));
	}
 
	@Test
	public void testIntersectsRangeCompletelyAfterCurrentRange() {
		Range range = new Range(3, 7);
		assertFalse("intersects: range [8,10] should not intersect [3,7]", range.intersects(8.0, 10.0));
	}
	
	
	// expand(Range range, double lowerMargin, double upperMargin) test cases
 
	@Test
	public void testExpandWithNullRangeThrowsException() {
		try {
			Range.expand(null, 0.25, 0.5);
			fail("Expected InvalidParameterException when range is null");
		} catch (Exception e) {
			assertTrue(e instanceof java.security.InvalidParameterException);
		}
	}
 
	@Test
	public void testExpandWithZeroMarginsReturnsSameRange() {
		Range input = new Range(2, 6);
		Range result = Range.expand(input, 0.0, 0.0);
 
		assertEquals("Lower bound should remain unchanged", 2.0, result.getLowerBound(), 0.0000001d);
		assertEquals("Upper bound should remain unchanged", 6.0, result.getUpperBound(), 0.0000001d);
	}
 
	@Test
	public void testExpandWithPositiveMargins() {
		Range input = new Range(2, 6);
		Range result = Range.expand(input, 0.25, 0.5);
 
		assertEquals("Lower bound incorrect after expansion", 1.0, result.getLowerBound(), 0.0000001d);
		assertEquals("Upper bound incorrect after expansion", 8.0, result.getUpperBound(), 0.0000001d);
	}
 
	@Test
	public void testExpandWithOneZeroAndOnePositiveMargin() {
		Range input = new Range(2, 6);
		Range result = Range.expand(input, 0.0, 0.5);
 
		assertEquals("Lower bound should remain unchanged", 2.0, result.getLowerBound(), 0.0000001d);
		assertEquals("Upper bound should expand correctly", 8.0, result.getUpperBound(), 0.0000001d);
	}
 
	@Test
	public void testExpandWithNegativeMarginsContractsRange() {

		    Range input = new Range(2, 6);

		    try {
		        Range.expand(input, -0.25, -0.25);
		        fail("Expected IllegalArgumentException");
		    } catch (IllegalArgumentException e) {
		        assertTrue(true);
		    }
		}
	
	// getCentralValue() test cases
 
	@Test
	public void testGetCentralValueWithEqualLowerAndUpperBounds() {
		Range range = new Range(5, 5);
		assertEquals("getCentralValue: range [5,5] should return 5.0", 5.0, range.getCentralValue(), 0.0000001d);
	}
 
	@Test
	public void testGetCentralValueWithPositiveRange() {
		Range range = new Range(2, 6);
		assertEquals("getCentralValue: range [2,6] should return 4.0", 4.0, range.getCentralValue(), 0.0000001d);
	}
 
	@Test
	public void testGetCentralValueWithNegativeRange() {
		Range range = new Range(-6, -2);
		assertEquals("getCentralValue: range [-6,-2] should return -4.0", -4.0, range.getCentralValue(), 0.0000001d);
	}
 
	@Test
	public void testGetCentralValueWithRangeIncludingZero() {
		Range range = new Range(-4, 4);
		assertEquals("getCentralValue: range [-4,4] should return 0.0", 0.0, range.getCentralValue(), 0.0000001d);
	}
 
	@Test
	public void testGetCentralValueWithMixedNegativeAndPositiveRange() {
		Range range = new Range(-2, 6);
		assertEquals("getCentralValue: range [-2,6] should return 2.0", 2.0, range.getCentralValue(), 0.0000001d);
	}
 
}
 