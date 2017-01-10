package Hw4Tests;


	import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import api.Util;
import hw4.Multiplexer;


	/**
	 * JUnit Tests designed to help with Hw4.
	 * @author Arnoldo Montoya-Gamez
	 *
	 */
	public class MultiplexerTester {
		Multiplexer m;
		Multiplexer m2;
		
		@Before
		public void Initialize(){
			m = new Multiplexer(2);
			m2 = new Multiplexer(3);
		}
		
		@Test
		public void MultiplexerTest1() {
			String description = "Multiplexer Test, k = 2, inputs set to \"001001\" - ";
			String expected = "1";
			String actual;
			Util.setInputs(m, "001001");
			m.propagate();
			actual = Util.toString(m.outputs());
			assertEquals(description, expected, actual);
		}

		@Test
		public void MultiplexerTest2() {
			String description = "Multiplexer Test, k = 2, inputs set to \"011001\" - ";
			String expected = "0";
			String actual;
			Util.setInputs(m, "011001");
			m.propagate();
			actual = Util.toString(m.outputs());
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void MultiplexerTest3() {
			String description = "Multiplexer Test, k = 2, inputs set to \"101001\" - ";
			String expected = "0";
			String actual;
			Util.setInputs(m, "101001");
			m.propagate();
			actual = Util.toString(m.outputs());
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void MultiplexerTest4() {
			String description = "Multiplexer Test, k = 2, inputs set to \"111001\" - ";
			String expected = "1";
			String actual;
			Util.setInputs(m, "111001");
			m.propagate();
			actual = Util.toString(m.outputs());
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void MultiplexerTest5() {
			String description = "Multiplexer Test, k = 2, inputs set to \"001001\" - ";
			String expected = "-";
			String actual;
			Util.setInputs(m, "001001");
			m.propagate();
			m.invalidateOutputs();
			actual = Util.toString(m.outputs());
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void MultiplexerTest6() {
			String description = "Multiplexer Test, k = 3, inputs set to \"11001010001\" - ";
			String expected = "1";
			String actual;
			Util.setInputs(m2, "11001010001");
			m2.propagate();
			actual = Util.toString(m2.outputs());
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void MultiplexerTest7() {
			String description = "Multiplexer Test, k = 3, inputs set to \"01001010001\" - ";
			String expected = "0";
			String actual;
			Util.setInputs(m2, "01001010001");
			m2.propagate();
			actual = Util.toString(m2.outputs());
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void MultiplexerTest8() {
			String description = "Multiplexer Test, k = 3, inputs set to \"00001010001\" - ";
			String expected = "1";
			String actual;
			Util.setInputs(m2, "00001010001");
			m2.propagate();
			actual = Util.toString(m2.outputs());
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void MultiplexerTest9() {
			String description = "Multiplexer Test, k = 3, inputs set to \"10\" - ";
			String expected = "0";
			String actual;
			Util.setInputs(m2, "11101010001");
			m2.propagate();
			actual = Util.toString(m2.outputs());
			assertEquals(description, expected, actual);
		}

		@Test
		public void MultiplexerTest10() {
			String description = "Multiplexer input() method Test, inputs set to \"11101010001\" - ";
			String expected = "[1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1]";
			String actual;
			Util.setInputs(m2, "11101010001");
			m2.propagate();
			m2.invalidateOutputs();
			actual = Arrays.toString(m2.inputs());
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void MultiplexerTest11() {
			String description = "Multiplexer outputs() method Test, inputs set to \"11101010001\" - ";
			String expected = "[0]";
			String actual;
			Util.setInputs(m2, "11101010001");
			m2.propagate();
			actual = Arrays.toString(m2.outputs());
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void MultiplexerTest12() {
			String description = "Multiplexer inputsValid() method Test, inputs set to \"11101010001\" - ";
			boolean expected = true;
			boolean actual;
			Util.setInputs(m2, "11101010001");
			m2.propagate();
			actual = m2.inputsValid();
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void MultiplexerTest13() {
			String description = "Multiplexer inputsValid() + invalidateinputs() method Test, inputs set to \"11101010001\" - ";
			boolean expected = false;
			boolean actual;
			Util.setInputs(m2, "11101010001");
			m2.propagate();
			m2.invalidateInputs();
			actual = m2.inputsValid();
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void MultiplexerTest14() {
			String description = "Multiplexer outputsValid() method Test, inputs set to \"11101010001\" - ";
			boolean expected = true;
			boolean actual;
			Util.setInputs(m2, "11101010001");
			m2.propagate();
			actual = m2.outputsValid();
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void MultiplexerTest15() {
			String description = "Multiplexer outputsValid() + invalidateOutputs() method Test, inputs set to \"11101010001\" - ";
			boolean expected = false;
			boolean actual;
			Util.setInputs(m2, "11101010001");
			m2.propagate();
			m2.invalidateOutputs();
			actual = m2.outputsValid();
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void MultiplexerTest16() {
			String description = "Multiplexer outputs() method Test, inputs set to \"00001010001\" - ";
			String expected = "[1]";
			String actual;
			Util.setInputs(m2, "00001010001");
			m2.propagate();
			actual = Arrays.toString(m2.outputs());
			assertEquals(description, expected, actual);
		}

}