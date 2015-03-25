/**
 * 
 */
package unittest;

import static org.junit.Assert.*;

import org.junit.Test;

import demo.Demo;

/**
 * @author divineit
 *
 */
public class DemoTest {

	@Test(timeout=100)
	public void test() {
//		fail("Something went wrong");
		Demo demo = new Demo();
		assertEquals("Should be 3", 2, demo.multiply(3, 1));
		
	}

}
