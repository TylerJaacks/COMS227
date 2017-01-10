package Hw4Tests;


	import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import api.Util;
import hw4.NotGate;


	/**
	 * JUnit Tests designed to help with Hw4.
	 * @author Arnoldo Montoya-Gamez
	 *
	 */
	public class NotGateTester {

		NotGate n;
		
		@Before
		public void Initialize(){
			n = new NotGate();
		}
		
		@Test
		public void NotGateTest1() {
			String description = "NotGate Test, inputs set to \"1\" - ";
			String expected = "0";
			String actual;
			Util.setInputs(n, "1");
			n.propagate();
			actual = Util.toString(n.outputs());
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void NotGateTest2() {
			String description = "NotGate Test, inputs set to \"0\" - ";
			String expected = "1";
			String actual;
			Util.setInputs(n, "0");
			n.propagate();
			actual = Util.toString(n.outputs());
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void NotGateTest3() {
			String description = "NotGate Test, Outputs set to \"Invalidate\" - ";
			String expected = "-";
			String actual;
			Util.setInputs(n, "1");
			n.propagate();
			n.invalidateOutputs();
			actual = Util.toString(n.outputs());
			assertEquals(description, expected, actual);
		}

		@Test
		public void NotGateTest4() {
			String description = "NotGate input() method Test, inputs set to \"1\" - ";
			String expected = "[1]";
			String actual;
			Util.setInputs(n, "1");
			n.propagate();
			n.invalidateOutputs();
			actual = Arrays.toString(n.inputs());
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void NotGateTest5() {
			String description = "NotGate outputs() method Test, inputs set to \"1\" - ";
			String expected = "[0]";
			String actual;
			Util.setInputs(n, "1");
			n.propagate();
			actual = Arrays.toString(n.outputs());
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void NotGateTest6() {
			String description = "NotGate inputsValid() method Test, inputs set to \"1\" - ";
			boolean expected = true;
			boolean actual;
			Util.setInputs(n, "1");
			n.propagate();
			actual = n.inputsValid();
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void NotGateTest7() {
			String description = "NotGate inputsValid() + invalidateinputs() method Test, inputs set to \"1\" - ";
			boolean expected = false;
			boolean actual;
			Util.setInputs(n, "1");
			n.propagate();
			n.invalidateInputs();
			actual = n.inputsValid();
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void NotGateTest8() {
			String description = "NotGate outputsValid() method Test, inputs set to \"1\" - ";
			boolean expected = true;
			boolean actual;
			Util.setInputs(n, "1");
			n.propagate();
			actual = n.outputsValid();
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void NotGateTest9() {
			String description = "NotGate outputsValid() + invalidateOutputs() method Test, inputs set to \"1\" - ";
			boolean expected = false;
			boolean actual;
			Util.setInputs(n, "1");
			n.propagate();
			n.invalidateOutputs();
			actual = n.outputsValid();
			assertEquals(description, expected, actual);
		}

}