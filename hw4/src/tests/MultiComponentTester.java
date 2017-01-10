package tests;


	import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import api.IComponent;
import api.Util;
import hw4.AndGate;
import hw4.MultiComponent;
import hw4.NotGate;
import hw4.OrGate;


	/**
	 * JUnit Tests designed to help with Hw4.
	 * @author Arnoldo Montoya-Gamez
	 *
	 */
	public class MultiComponentTester {

		IComponent[] ic1;
		MultiComponent mc1;	
		IComponent[] ic2;
		MultiComponent mc2;
		IComponent[] ic3;
		MultiComponent mc3;	
		
		@Before
		public void Initialize(){

			ic1 = new IComponent[3];
			for(int i = 0; i < ic1.length; i++)
				ic1[i] = new AndGate();
			mc1 = new MultiComponent(ic1);	
			
			ic2 = new IComponent[3];
			for(int i = 0; i < ic2.length; i++)
				ic2[i] = new OrGate();
			mc2 = new MultiComponent(ic2);
			
			ic3 = new IComponent[6];
			for(int i = 0; i < ic3.length; i++)
				ic3[i] = new NotGate();
			mc3 = new MultiComponent(ic3);
		}

		@Test
		public void MultiComponentTest1() {
			String description = "3 AndGate Multicomponent, inputs set to \"101111\" - ";
			String expected = "011";
			String actual;
			Util.setInputs(mc1, "101111");
			mc1.propagate();
			actual = Util.toString(mc1.outputs());
			assertEquals(description, expected, actual);
			}

		@Test
		public void MultiComponentTest2() {
			String description = "3 AndGate Multicomponent, inputs set to \"111111\" - ";
			String expected = "111";
			String actual;
			Util.setInputs(mc1, "111111");
			mc1.propagate();
			actual = Util.toString(mc1.outputs());
			assertEquals(description, expected, actual);
			}

		@Test
		public void MultiComponentTest3() {
			String description = "3 AndGate Multicomponent, inputs set to \"000000\" - ";
			String expected = "000";
			String actual;
			Util.setInputs(mc1, "000000");
			mc1.propagate();
			actual = Util.toString(mc1.outputs());
			assertEquals(description, expected, actual);
			}

		@Test
		public void MultiComponentTest4() {
			String description = "3 AndGate Multicomponent, inputs set to \"010111\" - ";
			String expected = "001";
			String actual;
			Util.setInputs(mc1, "010111");
			mc1.propagate();
			actual = Util.toString(mc1.outputs());
			assertEquals(description, expected, actual);
			}

		@Test
		public void MultiComponentTest5() {
			String description = "3 AndGate Multicomponent, outputs set to \"invalidate\" - ";
			String expected = "---";
			String actual;
			Util.setInputs(mc1, "101111");
			mc1.propagate();
			mc1.invalidateOutputs();
			actual = Util.toString(mc1.outputs());
			assertEquals(description, expected, actual);
			}

		@Test
		public void MultiComponentTest6() {
			String description = "3 OrGate Multicomponent, inputs set to \"101111\" - ";
			String expected = "111";
			String actual;
			Util.setInputs(mc2, "101111");
			mc2.propagate();
			actual = Util.toString(mc2.outputs());
			assertEquals(description, expected, actual);
			}

		@Test
		public void MultiComponentTest7() {
			String description = "3 OrGate Multicomponent, inputs set to \"101010\" - ";
			String expected = "111";
			String actual;
			Util.setInputs(mc2, "101010");
			mc2.propagate();
			actual = Util.toString(mc2.outputs());
			assertEquals(description, expected, actual);
			}

		@Test
		public void MultiComponentTest8() {
			String description = "3 OrGate Multicomponent, inputs set to \"010101\" - ";
			String expected = "111";
			String actual;
			Util.setInputs(mc2, "010101");
			mc2.propagate();
			actual = Util.toString(mc2.outputs());
			assertEquals(description, expected, actual);
			}

		@Test
		public void MultiComponentTest9() {
			String description = "3 OrGate Multicomponent, inputs set to \"000001\" - ";
			String expected = "001";
			String actual;
			Util.setInputs(mc2, "000001");
			mc2.propagate();
			actual = Util.toString(mc2.outputs());
			assertEquals(description, expected, actual);
			}

		@Test
		public void MultiComponentTest11() {
			String description = "3 OrGate Multicomponent, inputs set to \"100000\" - ";
			String expected = "100";
			String actual;
			Util.setInputs(mc2, "100000");
			mc2.propagate();
			actual = Util.toString(mc2.outputs());
			assertEquals(description, expected, actual);
			}

		@Test
		public void MultiComponentTest12() {
			String description = "3 OrGate Multicomponent, inputs set to \"001000\" - ";
			String expected = "010";
			String actual;
			Util.setInputs(mc2, "001000");
			mc2.propagate();
			actual = Util.toString(mc2.outputs());
			assertEquals(description, expected, actual);
			}

		@Test
		public void MultiComponentTest13() {
			String description = "3 OrGate Multicomponent, inputs set to \"000000\" - ";
			String expected = "000";
			String actual;
			Util.setInputs(mc2, "000000");
			mc2.propagate();
			actual = Util.toString(mc2.outputs());
			assertEquals(description, expected, actual);
			}

		@Test
		public void MultiComponentTest14() {
			String description = "3 OrGate Multicomponent, outputs set to \"invalidate\" - ";
			String expected = "---";
			String actual;
			Util.setInputs(mc2, "000000");
			mc2.propagate();
			mc2.invalidateOutputs();
			actual = Util.toString(mc2.outputs());
			assertEquals(description, expected, actual);
			}

		@Test
		public void MultiComponentTest15() {
			String description = "6 NotGate Multicomponent, outputs set to \"invalidate\" - ";
			String expected = "------";
			String actual;
			Util.setInputs(mc3, "000000");
			mc3.propagate();
			mc3.invalidateOutputs();
			actual = Util.toString(mc3.outputs());
			assertEquals(description, expected, actual);
			}

		@Test
		public void MultiComponentTest16() {
			String description = "6 NotGate Multicomponent, inputs set to \"010000\" - ";
			String expected = "101111";
			String actual;
			Util.setInputs(mc3, "010000");
			mc3.propagate();
			actual = Util.toString(mc3.outputs());
			assertEquals(description, expected, actual);
			}

		@Test
		public void MultiComponentTest17() {
			String description = "6 NotGate Multicomponent, inputs set to \"010101\" - ";
			String expected = "101010";
			String actual;
			Util.setInputs(mc3, "010101");
			mc3.propagate();
			actual = Util.toString(mc3.outputs());
			assertEquals(description, expected, actual);
			}

		@Test
		public void MultiComponentTest18() {
			String description = "6 NotGate Multicomponent, inputs set to \"100001\" - ";
			String expected = "011110";
			String actual;
			Util.setInputs(mc3, "100001");
			mc3.propagate();
			actual = Util.toString(mc3.outputs());
			assertEquals(description, expected, actual);
			}

		@Test
		public void MultiComponentTest19() {
			String description = "6 NotGate Multicomponent, inputs set to \"001001\" - ";
			String expected = "110110";
			String actual;
			Util.setInputs(mc3, "001001");
			mc3.propagate();
			actual = Util.toString(mc3.outputs());
			assertEquals(description, expected, actual);
			}

		@Test
		public void MultiComponentTest20() {
			String description = "6 NotGate Multicomponent, inputs set to \"111111\" - ";
			String expected = "000000";
			String actual;
			Util.setInputs(mc3, "111111");
			mc3.propagate();
			actual = Util.toString(mc3.outputs());
			assertEquals(description, expected, actual);
			}

		@Test
		public void MultiComponentTest21() {
			String description = "3 OrGate Multicomponent input() method Test, inputs set to \"100000\" - ";
			String expected = "[0, 0, 0, 0, 0, 1]";
			String actual;
			Util.setInputs(mc2, "100000");
			mc2.propagate();
			actual = Arrays.toString(mc2.inputs());
			assertEquals(description, expected, actual);
		}

		@Test
		public void MultiComponentTest22() {
			String description = "3 OrGate Multicomponent outputs() method Test, inputs set to \"100000\" - ";
			String expected = "[0, 0, 1]";
			String actual;
			Util.setInputs(mc2, "100000");
			mc2.propagate();
			actual = Arrays.toString(mc2.outputs());
			assertEquals(description, expected, actual);
		}

		@Test
		public void MultiComponentTest23() {
			String description = "3 OrGate Multicomponent inputsValid() method Test, inputs set to \"100000\" - ";
			boolean expected = true;
			boolean actual;
			Util.setInputs(mc2, "100000");
			mc2.propagate();
			actual = mc2.inputsValid();
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void MultiComponentTest24() {
			String description = "3 OrGate Multicomponent inputsValid() + invalidateinputs() method Test, inputs set to \"100000\" - ";
			boolean expected = false;
			boolean actual;
			Util.setInputs(mc2, "100000");
			mc2.propagate();
			mc2.invalidateInputs();
			actual = mc2.inputsValid();
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void MultiComponentTest25() {
			String description = "3 OrGate Multicomponent outputsValid() method Test, inputs set to \"100000\" - ";
			boolean expected = true;
			boolean actual;
			Util.setInputs(mc2, "100000");
			mc2.propagate();
			actual = mc2.outputsValid();
			assertEquals(description, expected, actual);
		}
		
		@Test
		public void MultiComponentTest26() {
			String description = "3 OrGate Multicomponent outputsValid() + invalidateoutputs() method Test, inputs set to \"100000\" - ";
			boolean expected = false;
			boolean actual;
			Util.setInputs(mc2, "100000");
			mc2.propagate();
			mc2.invalidateOutputs();
			actual = mc2.outputsValid();
			assertEquals(description, expected, actual);
		}

}