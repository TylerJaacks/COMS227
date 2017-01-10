package tests;


	import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import api.Util;
import hw4.FullAdder;


	/**
	 * JUnit Tests designed to help with Hw4.
	 * @author Arnoldo Montoya-Gamez
	 *
	 */
	public class FullAdderTester {
	
		FullAdder fa;
		
		@Before
		public void Initialize(){
			fa = new FullAdder();
		}
		
		@Test
		public void FullAdderTest1() {
			String description = "FullAdder Test, inputs set to \"111\" - ";
			String expected = "11";
			String actual;
			Util.setInputs(fa, "111");
			fa.propagate();
			actual = Util.toString(fa.outputs());
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void FullAdderTest2() {
			String description = "FullAdder Test, inputs set to \"110\" - ";
			String expected = "10";
			String actual;
			Util.setInputs(fa, "110");
			fa.propagate();
			actual = Util.toString(fa.outputs());
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void FullAdderTest3() {
			String description = "FullAdder Test, inputs set to \"100\" - ";
			String expected = "01";
			String actual;
			Util.setInputs(fa, "100");
			fa.propagate();
			actual = Util.toString(fa.outputs());
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void FullAdderTest4() {
			String description = "FullAdder Test, inputs set to \"101\" - ";
			String expected = "10";
			String actual;
			Util.setInputs(fa, "101");
			fa.propagate();
			actual = Util.toString(fa.outputs());
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void FullAdderTest5() {
			String description = "FullAdder Test, inputs set to \"000\" - ";
			String expected = "00";
			String actual;
			Util.setInputs(fa, "000");
			fa.propagate();
			actual = Util.toString(fa.outputs());
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void FullAdderTest6() {
			String description = "FullAdder Test, outputs set to \"Invalidate\" - ";
			String expected = "--";
			String actual;
			Util.setInputs(fa, "111");
			fa.propagate();
			fa.invalidateOutputs();
			actual = Util.toString(fa.outputs());
			assertEquals(description, expected, actual);
		}
			@Test
			public void FullAdderTest7() {
				String description = "FullAdder input() method Test, inputs set to \"100\" - ";
				String expected = "[0, 0, 1]";
				String actual;
				Util.setInputs(fa, "100");
				fa.propagate();
				fa.invalidateOutputs();
				actual = Arrays.toString(fa.inputs());
				assertEquals(description, expected, actual);
			}
			
			@Test
			public void FullAdderTest8() {
				String description = "FullAdder outputs() method Test, inputs set to \"100\" - ";
				String expected = "[1, 0]";
				String actual;
				Util.setInputs(fa, "100");
				fa.propagate();
				actual = Arrays.toString(fa.outputs());
				assertEquals(description, expected, actual);
			}
			
			@Test
			public void FullAdderTest9() {
				String description = "FullAdder inputsValid() method Test, inputs set to \"100\" - ";
				boolean expected = true;
				boolean actual;
				Util.setInputs(fa, "100");
				fa.propagate();
				actual = fa.inputsValid();
				assertEquals(description, expected, actual);
			}
			
			@Test
			public void FullAdderTest10() {
				String description = "FullAdder inputsValid() + invalidateinputs() method Test, inputs set to \"100\" - ";
				boolean expected = false;
				boolean actual;
				Util.setInputs(fa, "100");
				fa.propagate();
				fa.invalidateInputs();
				actual = fa.inputsValid();
				assertEquals(description, expected, actual);
			}
			
			@Test
			public void FullAdderTest11() {
				String description = "FullAdder outputsValid() method Test, inputs set to \"100\" - ";
				boolean expected = true;
				boolean actual;
				Util.setInputs(fa, "100");
				fa.propagate();
				actual = fa.outputsValid();
				assertEquals(description, expected, actual);
			}
			
			@Test
			public void FullAdderTest12() {
				String description = "FullAdder outputsValid() + invalidateOutputs() method Test, inputs set to \"100\" - ";
				boolean expected = false;
				boolean actual;
				Util.setInputs(fa, "100");
				fa.propagate();
				fa.invalidateOutputs();
				actual = fa.outputsValid();
				assertEquals(description, expected, actual);
			}
			
			@Test
			public void FullAdderTest13() {
				String description = "FullAdder outputs() method Test, inputs set to \"100\" - ";
				String expected = "[1, 0]";
				String actual;
				Util.setInputs(fa, "100");
				fa.propagate();
				actual = Arrays.toString(fa.outputs());
				assertEquals(description, expected, actual);
			}

}