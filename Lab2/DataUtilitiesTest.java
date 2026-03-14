package org.jfree.data.test;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import junit.framework.TestCase;

public class DataUtilitiesTest extends TestCase {
	
	private Values2D values2D;

	@Before
	public void setUp() {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;

	    testValues.addValue(1, "R1", "C1");
	    testValues.addValue(2, "R1", "C2");
	    testValues.addValue(3, "R1", "C3");

	    testValues.addValue(4, "R2", "C1");
	    testValues.addValue(5, "R2", "C2");
	    testValues.addValue(6, "R2", "C3");

	    testValues.addValue(7, "R3", "C1");
	    testValues.addValue(8, "R3", "C2");
	    testValues.addValue(9, "R3", "C3");
		
	}
	
	@After
	public void teardown() {
		values2D = null;
	}
	
	//calculateColumnTotal tests-------------------------------------------------------
	@Test
	public void testValidDataAndColumnColumnTotal() {
		assertEquals("Wrong sum returned. It should be 12.0",
				12.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d);
	}
	
	@Test
	public void testNullDataColumnTotal() {
		DefaultKeyedValues2D data = new DefaultKeyedValues2D();

		data.addValue(1,"R1","C1");
		data.addValue(null,"R1","C2");
		data.addValue(3,"R1","C3");
		
		try {
			DataUtilities.calculateColumnTotal(data, 0);
			fail("No exception thrown. The expected outcome was: a thrown exception of type IllegalArgumentException");
		}
		catch (Exception e) {
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testColumnTotalColumnIndexOutOfBounds() {

	    try {
	        DataUtilities.calculateColumnTotal(values2D, 3);
	        fail("Expected exception for column index greater than number of columns");
	    }
	    catch (Exception e) {
	        assertTrue(e instanceof IndexOutOfBoundsException);
	    }

	}
	
	@Test
	public void testColumnTotalNullDataObject() {
		try {
			DataUtilities.calculateColumnTotal(null, 0);
			fail("No exception thrown. The expected outcome was: a thrown exception of type NullPointerException");
		}
		catch (Exception e) {
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(NullPointerException.class));
		}
	}
	
	@Test
    public void testColumnTotalInvalidNegativeColumn() {

        try {
            DataUtilities.calculateColumnTotal(values2D, -1);
            fail("Expected exception for negative column index");
        }
        catch (Exception e) {
            assertTrue(e instanceof Exception);
        }

    }
	
	//calculateRowTotal tests-------------------------------------------------------
	@Test
    public void testValidDataAndRowRowTotal() {
		System.out.println();
		assertEquals("Wrong sum returned. It should be 6.0",
				6.0, DataUtilities.calculateRowTotal(values2D, 0), 0.0000001d);
	}
	
	@Test
    public void testNullDataRowTotal() {
		
		DefaultKeyedValues2D data = new DefaultKeyedValues2D();

		data.addValue(1,"R1","C1");
		data.addValue(null,"R1","C2");
		data.addValue(3,"R1","C3");

		try {
			DataUtilities.calculateRowTotal(data, 0);
			fail("No exception thrown. The expected outcome was: a thrown exception of type IllegalArgumentException");
		}
		catch (Exception e) {
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testRowTotalRowIndexOutOfBounds() {

	    try {
	        DataUtilities.calculateRowTotal(values2D, 3);
	        fail("Expected exception for column index greater than number of rows");
	    }
	    catch (Exception e) {
	        assertTrue(e instanceof IndexOutOfBoundsException);
	    }

	}
	
	@Test
	public void testRowTotalNullDataObject() {
		try {
			DataUtilities.calculateRowTotal(null, 0);
			fail("No exception thrown. The expected outcome was: a thrown exception of type NullPointerException");
		}
		catch (Exception e) {
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(NullPointerException.class));
		}
	}
	
	@Test
    public void testRowTotalInvalidNegativeColumn() {

        try {
            DataUtilities.calculateRowTotal(values2D, -1);
            fail("Expected exception for negative column index");
        }
        catch (Exception e) {
            assertTrue(e instanceof Exception);
        }

    }
	
	//createNumberArray tests-------------------------------------------------------
	
	@Test
    public void testCreateNumberArrayValidBoundary() {

        double[] testArray = {3.0};
		Number[] result = DataUtilities.createNumberArray(testArray);

        assertEquals(1, result.length);

    }
	
	@Test
    public void testCreateNumberArrayValid() {

        double[] testArray = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0};
		Number[] result = DataUtilities.createNumberArray(testArray);

        assertEquals(6, result.length);

    }
	
	@Test
    public void testCreateNumberArrayEmpty() {

        double[] testArray = {};

        Number[] result = DataUtilities.createNumberArray(testArray);

        assertEquals(0, result.length);

    }
	
	 @Test
	    public void testCreateNumberArrayNull() {

	        try {
	            DataUtilities.createNumberArray(null);
	            fail("Expected IllegalArgumentException");
	        }
	        catch (Exception e) {
	            assertTrue(e.getClass().equals(IllegalArgumentException.class));
	        }

	    }
	 
	 //createNumberArray2D tests-------------------------------------------------------
	 
	 @Test
	    public void testCreateNumberArray2DValidBoundary() {

	        double[][] test2DArray = {{1.0, 2.0}};

	        Number[][] result = DataUtilities.createNumberArray2D(test2DArray);

	        assertEquals(1, result.length);
	        assertEquals(2, result[0].length);

	    }
	 
	 @Test
	    public void testCreateNumberArray2DValid() {

	        double[][] test2DArray = {
	                {1.0, 2.0},
	                {3.0, 4.0}
	        };

	        Number[][] result = DataUtilities.createNumberArray2D(test2DArray);

	        assertEquals(2, result.length);
	        assertEquals(2, result[0].length);

	    }
	 
	 @Test
	    public void testCreateNumberArray2DEmpty() {

	        double[][] test2DArray = {{}};

	        Number[][] result = DataUtilities.createNumberArray2D(test2DArray);

	        assertEquals(1, result.length);
	        assertEquals(0, result[0].length);

	    }
	 
	 @Test
	    public void testCreateNumberArray2DNull() {

	        try {
	            DataUtilities.createNumberArray2D(null);
	            fail("Expected IllegalArgumentException");
	        }
	        catch (Exception e) {
	            assertTrue(e.getClass().equals(IllegalArgumentException.class));
	        }

	    }
	 
	 //getCumulativePercentages tests-------------------------------------------------------
	 @Test
	    public void testGetCumulativePercentagesValid() {

			DefaultKeyedValues dataset = new DefaultKeyedValues();

		 	dataset.addValue("A", 5);
		 	dataset.addValue("B", 9);
		 	dataset.addValue("C", 2);
		 	System.out.println(dataset.getValue(0));
		 	System.out.println(dataset.getValue(1));
		 	System.out.println(dataset.getValue(2));
	        System.out.println(dataset.getItemCount());

	        KeyedValues result = DataUtilities.getCumulativePercentages(dataset);

	        assertEquals(5.0 / 16.0, result.getValue(0).doubleValue(), 0.0000001d);
	        assertEquals(14.0 / 16.0, result.getValue(1).doubleValue(), 0.0000001d);
	        assertEquals(1.0, result.getValue(2).doubleValue(), 0.0000001d);

	    }

	    
	    @Test
	    public void testGetCumulativePercentagesZeroValues() {

	    	DefaultKeyedValues dataset = new DefaultKeyedValues();
	    	dataset.addValue("A", 0);
	    	dataset.addValue("B", 0);
	    	dataset.addValue("C", 0);

	        KeyedValues result = DataUtilities.getCumulativePercentages(dataset);

	        assertTrue(Double.isNaN(result.getValue(0).doubleValue()));
	        assertTrue(Double.isNaN(result.getValue(1).doubleValue()));
	        assertTrue(Double.isNaN(result.getValue(2).doubleValue()));

	    }
	    
	    
	    @Test
	    public void testGetCumulativePercentagesSingleValue() {

	    	DefaultKeyedValues dataset = new DefaultKeyedValues();
	    	dataset.addValue("A", 10);

	        KeyedValues result = DataUtilities.getCumulativePercentages(dataset);
	        System.out.println(dataset.getValue(0));
	        System.out.println(dataset.getItemCount());

	        assertEquals(1.0, result.getValue(0).doubleValue(), 0.0000001d);

	    }
	    
	    @Test
	    public void testGetCumulativePercentagesNegativeValue() {

			DefaultKeyedValues dataset = new DefaultKeyedValues();

		 	dataset.addValue("A", -1);
		 	dataset.addValue("B", 2);
		 	dataset.addValue("C", 3);
		 	System.out.println(dataset.getValue(0));
		 	System.out.println(dataset.getValue(1));
		 	System.out.println(dataset.getValue(2));
	        System.out.println(dataset.getItemCount());

	        KeyedValues result = DataUtilities.getCumulativePercentages(dataset);

	        assertEquals(-1.0 / 4.0, result.getValue(0).doubleValue(), 0.0000001d);
	        assertEquals(1.0 / 4.0, result.getValue(1).doubleValue(), 0.0000001d);
	        assertEquals(4.0 / 4.0, result.getValue(2).doubleValue(), 0.0000001d);

	    }
	    
	    @Test
	    public void testGetCumulativePercentagesNull() {
	    	
	    	try {
	    	     KeyedValues result = DataUtilities.getCumulativePercentages(null);
				fail("No exception thrown. The expected outcome was: a thrown exception of type IllegalArgumentException");
			}
			catch (Exception e) {
				assertTrue("Incorrect exception type thrown",
						e.getClass().equals(IllegalArgumentException.class));
			}

	    }
	    
}
