package tests;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import api.Util;
import hw4.AndGate;


	/**
	 * JUnit Tests designed to help with Hw4.
	 * @author Arnoldo Montoya-Gamez
	 *
	 */
	public class AndGateTester {

		AndGate a;
		
		@Before
		public void Initialize(){
			a = new AndGate();
		}
		
		@Test
		public void AndGateTest1() {
			String description = "AndGate Test, inputs set to \"11\" - ";
			String expected = "1";
			String actual;
			Util.setInputs(a, "11");
			a.propagate();
			actual = Util.toString(a.outputs());
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void AndGateTest2() {
			String description = "AndGate Test, inputs set to \"10\" - ";
			String expected = "0";
			String actual;
			Util.setInputs(a, "10");
			a.propagate();
			actual = Util.toString(a.outputs());
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void AndGateTest3() {
			String description = "AndGate Test, inputs set to \"01\" - ";
			String expected = "0";
			String actual;
			Util.setInputs(a, "01");
			a.propagate();
			actual = Util.toString(a.outputs());
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void AndGateTest4() {
			String description = "AndGate Test, inputs set to \"00\" - ";
			String expected = "0";
			String actual;
			Util.setInputs(a, "00");
			a.propagate();
			actual = Util.toString(a.outputs());
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void AndGateTest5() {
			String description = "AndGate Test, outputs set to \"Invalidate\" - ";
			String expected = "-";
			String actual;
			Util.setInputs(a, "11");
			a.propagate();
			a.invalidateOutputs();
			actual = Util.toString(a.outputs());
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void AndGateTest6() {
			String description = "AndGate input() method Test, inputs set to \"11\" - ";
			String expected = "[1, 1]";
			String actual;
			Util.setInputs(a, "11");
			a.propagate();
			a.invalidateOutputs();
			actual = Arrays.toString(a.inputs());
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void AndGateTest7() {
			String description = "AndGate outputs() method Test, inputs set to \"11\" - ";
			String expected = "[1]";
			String actual;
			Util.setInputs(a, "11");
			a.propagate();
			actual = Arrays.toString(a.outputs());
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void AndGateTest8() {
			String description = "AndGate inputsValid() method Test, inputs set to \"11\" - ";
			boolean expected = true;
			boolean actual;
			Util.setInputs(a, "11");
			a.propagate();
			actual = a.inputsValid();
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void AndGateTest9() {
			String description = "AndGate inputsValid() + invalidateinputs() method Test, inputs set to \"11\" - ";
			boolean expected = false;
			boolean actual;
			Util.setInputs(a, "11");
			a.propagate();
			a.invalidateInputs();
			actual = a.inputsValid();
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void AndGateTest10() {
			String description = "AndGate outputsValid() method Test, inputs set to \"11\" - ";
			boolean expected = true;
			boolean actual;
			Util.setInputs(a, "11");
			a.propagate();
			actual = a.outputsValid();
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void AndGateTest11() {
			String description = "AndGate outputsValid() + invalidateOutputs() method Test, inputs set to \"11\" - ";
			boolean expected = false;
			boolean actual;
			Util.setInputs(a, "11");
			a.propagate();
			a.invalidateOutputs();
			actual = a.outputsValid();
			assertEquals(description, expected, actual);
		}

}