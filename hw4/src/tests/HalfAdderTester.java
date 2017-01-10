package tests;


	import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import api.Util;
import hw4.HalfAdder;


	/**
	 * JUnit Tests designed to help with Hw4.
	 * @author Arnoldo Montoya-Gamez
	 *
	 */
	public class HalfAdderTester {

		HalfAdder h;
		
		@Before
		public void Initialize(){

			h = new HalfAdder();
		}
		
		@Test
	public void HalfAdderTest1() {
		String description = "HalfAdder Test, inputs set to \"10\" - ";
		String expected = "01";
		String actual;
		Util.setInputs(h, "10");
		h.propagate();
		actual = Util.toString(h.outputs());
		assertEquals(description, expected, actual);
	}
	
	@Test
	public void HalfAdderTest2() {
		String description = "HalfAdder Test, inputs set to \"01\" - ";
		String expected = "01";
		String actual;
		Util.setInputs(h, "01");
		h.propagate();
		actual = Util.toString(h.outputs());
		assertEquals(description, expected, actual);
	}
	
	@Test
	public void HalfAdderTest3() {
		String description = "HalfAdder Test, inputs set to \"00\" - ";
		String expected = "00";
		String actual;
		Util.setInputs(h, "00");
		h.propagate();
		actual = Util.toString(h.outputs());
		assertEquals(description, expected, actual);
	}
	
	@Test
	public void HalfAdderTest4() {
		String description = "HalfAdder Test, inputs set to \"11\" - ";
		String expected = "10";
		String actual;
		Util.setInputs(h, "11");
		h.propagate();
		actual = Util.toString(h.outputs());
		assertEquals(description, expected, actual);
	}
	
	@Test
	public void HalfAdderTest5() {
		String description = "HalfAdder Test, propagate, invalidate, propagate again, inputs set to \"11\" - ";
		String expected = "10";
		String actual;
		Util.setInputs(h, "11");
		h.propagate();
		h.invalidateOutputs();
		Util.setInputs(h, "11");
		h.propagate();
		actual = Util.toString(h.outputs());
		assertEquals(description, expected, actual);
	}
	
	@Test
	public void HalfAdderTest6() {
		String description = "HalfAdder Test, outputs set to \"Invalidate\" - ";
		String expected = "--";
		String actual;
		Util.setInputs(h, "10");
		h.propagate();
		h.invalidateOutputs();
		actual = Util.toString(h.outputs());
		assertEquals(description, expected, actual);
	}
	
	@Test
	public void HalfAdderTest7() {
		String description = "HalfAdder input() method Test, inputs set to \"10\" - ";
		String expected = "[0, 1]";
		String actual;
		Util.setInputs(h, "10");
		h.propagate();
		h.invalidateOutputs();
		actual = Arrays.toString(h.inputs());
		assertEquals(description, expected, actual);
	}
	
	@Test
	public void HalfAdderTest8() {
		String description = "HalfAdder outputs() method Test, inputs set to \"10\" - ";
		String expected = "[1, 0]";
		String actual;
		Util.setInputs(h, "10");
		h.propagate();
		actual = Arrays.toString(h.outputs());
		assertEquals(description, expected, actual);
	}
	
	@Test
	public void HalfAdderTest9() {
		String description = "HalfAdder inputsValid() method Test, inputs set to \"10\" - ";
		boolean expected = true;
		boolean actual;
		Util.setInputs(h, "10");
		h.propagate();
		actual = h.inputsValid();
		assertEquals(description, expected, actual);
	}
	
	@Test
	public void HalfAdderTest10() {
		String description = "HalfAdder inputsValid() + invalidateinputs() method Test, inputs set to \"10\" - ";
		boolean expected = false;
		boolean actual;
		Util.setInputs(h, "10");
		h.propagate();
		h.invalidateInputs();
		actual = h.inputsValid();
		assertEquals(description, expected, actual);
	}
	
	@Test
	public void HalfAdderTest11() {
		String description = "HalfAdder outputsValid() method Test, inputs set to \"10\" - ";
		boolean expected = true;
		boolean actual;
		Util.setInputs(h, "10");
		h.propagate();
		actual = h.outputsValid();
		assertEquals(description, expected, actual);
	}
	
	@Test
	public void HalfAdderTest12() {
		String description = "HalfAdder outputsValid() + invalidateOutputs() method Test, inputs set to \"10\" - ";
		boolean expected = false;
		boolean actual;
		Util.setInputs(h, "10");
		h.propagate();
		h.invalidateOutputs();
		actual = h.outputsValid();
		assertEquals(description, expected, actual);
	}
	
	@Test
	public void HalfAdderTest13() {
		String description = "HalfAdder outputs() method Test, inputs set to \"01\" - ";
		String expected = "[1, 0]";
		String actual;
		Util.setInputs(h, "01");
		h.propagate();
		actual = Arrays.toString(h.outputs());
		assertEquals(description, expected, actual);
	}

}