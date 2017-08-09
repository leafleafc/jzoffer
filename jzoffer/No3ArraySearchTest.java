package JZoffer;

import static org.junit.Assert.*;

import org.junit.Test;

public class No3ArraySearchTest {

	@Test
	public void testMain() {
		//fail("Not yet implemented");
	}

	@Test
	public void testFindByTheUpperRightCorner() {
		int[][] array = {{1,2,8,9},
		         {2,4,9,12},
		         {4,7,10,13},
		         {6,8,11,15}};
		assertEquals(true, new No3ArraySearch().findByTheUpperRightCorner(9,array));
		//fail("Not yet implemented");
	}

	@Test
	public void testFindByTheLowerLeftCorner() {
		//fail("Not yet implemented");
	}

}
