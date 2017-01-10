package Hw4Tests;


	import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import api.Util;
import hw4.OrGate;


	/**
	 * JUnit Tests designed to help with Hw4.
	 * @author Arnoldo Montoya-Gamez
	 *
	 */
	public class OrGateTester {

		OrGate o;
		
		@Before
		public void Initialize(){
			o = new OrGate();
		}
		
		@Test
		public void OrGateTest1() {
			String description = "OrGate Test, inputs set to \"11\" - ";
			String expected = "1";
			String actual;
			Util.setInputs(o, "11");
			o.propagate();
			actual = Util.toString(o.outputs());
			assertEquals(description, expected, actual);
		}	
		
		@Test
		public void OrGateTest2() {
			String description = "OrGate Test, inputs set to \"01\" - ";
			String expected = "1";
			String actual;
			Util.setInputs(o, "01");
			o.propagate();
			actual = Util.toString(o.outputs());
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void OrGateTest3() {
			String description = "OrGate Test, inputs set to \"10\" - ";
			String expected = "1";
			String actual;
			Util.setInputs(o, "10");
			o.propagate();
			actual = Util.toString(o.outputs());
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void OrGateTest4() {
			String description = "OrGate Test, inputs set to \"00\" - ";
			String expected = "0";
			String actual;
			Util.setInputs(o, "00");
			o.propagate();
			actual = Util.toString(o.outputs());
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void OrGateTest5() {
			String description = "OrGate Test, outputs set to \"Invalidate\" - ";
			String expected = "-";
			String actual;
			Util.setInputs(o, "01");
			o.propagate();
			o.invalidateOutputs();
			actual = Util.toString(o.outputs());
			assertEquals(description, expected, actual);
		}

		@Test
		public void OrGateTest6() {
			String description = "OrGate input() method Test, inputs set to \"11\" - ";
			String expected = "[1, 1]";
			String actual;
			Util.setInputs(o, "11");
			o.propagate();
			o.invalidateOutputs();
			actual = Arrays.toString(o.inputs());
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void OrGateTest7() {
			String description = "OrGate outputs() method Test, inputs set to \"11\" - ";
			String expected = "[1]";
			String actual;
			Util.setInputs(o, "11");
			o.propagate();
			actual = Arrays.toString(o.outputs());
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void OrGateTest8() {
			String description = "OrGate inputsValid() method Test, inputs set to \"11\" - ";
			boolean expected = true;
			boolean actual;
			Util.setInputs(o, "11");
			o.propagate();
			actual = o.inputsValid();
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void OrGateTest9() {
			String description = "OrGate inputsValid() + invalidateinputs() method Test, inputs set to \"11\" - ";
			boolean expected = false;
			boolean actual;
			Util.setInputs(o, "11");
			o.propagate();
			o.invalidateInputs();
			actual = o.inputsValid();
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void OrGateTest10() {
			String description = "OrGate outputsValid() method Test, inputs set to \"11\" - ";
			boolean expected = true;
			boolean actual;
			Util.setInputs(o, "11");
			o.propagate();
			actual = o.outputsValid();
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void OrGateTest11() {
			String description = "OrGate outputsValid() + invalidateOutputs() method Test, inputs set to \"11\" - ";
			boolean expected = false;
			boolean actual;
			Util.setInputs(o, "11");
			o.propagate();
			o.invalidateOutputs();
			actual = o.outputsValid();
			assertEquals(description, expected, actual);
		}

}