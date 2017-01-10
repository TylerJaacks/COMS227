package Hw4Tests;


	import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import api.Util;
import hw4.Register;


	/**
	 * JUnit Tests designed to help with Hw4.
	 * @author Arnoldo Montoya-Gamez
	 *
	 */
	public class RegisterTester {

		Register reg;
		
		@Before
		public void Initialize(){
			reg = new Register(3);
		}
		
	@Test
	public void RegisterTest1() {
		String description = "Register Test, outputs set to \"Initial State\" - ";
		String expected = "000";
		String actual;
		actual = Util.toString(reg.outputs());
		assertEquals(description, expected, actual);
	}
	
	@Test
	public void RegisterTest2() {
		String description = "Register Test, setEnabled() set to false, outputs set to \"111\" - ";
		String expected = "000";	
		String actual;
		Util.setInputs(reg, "111");
		reg.tick();
		actual = Util.toString(reg.outputs());
		assertEquals(description, expected, actual);
	}
	@Test
	public void RegisterTest3() {
		String description = "Register Test, setEnabled() is true, outputs set to \"111\" - ";
		String expected = "111";
		String actual;
		Util.setInputs(reg, "111");
		reg.setEnabled(true);
		reg.tick();
		actual = Util.toString(reg.outputs());
		assertEquals(description, expected, actual);
	}
	
	@Test
	public void RegisterTest4() {
		String description = "Register Test, setEnabled() is true, outputs set to \"110\" - ";
		String expected = "110";
		String actual;
		Util.setInputs(reg, "110");
		reg.setEnabled(true);
		reg.tick();
		actual = Util.toString(reg.outputs());
		assertEquals(description, expected, actual);
		}
	
	@Test
	public void RegisterTest5() {
		String description = "Register Test, setEnabled() is false, outputs set to \"111\" - ";
		String expected = "000";
		String actual;
		Util.setInputs(reg, "111");
		reg.setEnabled(false);
		reg.tick();
		actual = Util.toString(reg.outputs());
		assertEquals(description, expected, actual);
		}

	@Test
	public void RegisterTest6() {
		String description = "Register Test, setEnabled() is true, outputs set to \"111\" , then it was cleared - ";
		String expected = "000";
		String actual;
		Util.setInputs(reg, "111");
		reg.setEnabled(true);
		reg.tick();
		reg.clear();
		actual = Util.toString(reg.outputs());
		assertEquals(description, expected, actual);
		}
	@Test
	public void RegisterTest7() {
		String description = "Register input() method Test, inputs set to \"110\" - ";
		String expected = "[0, 1, 1]";
		String actual;
		Util.setInputs(reg, "110");
		reg.setEnabled(true);
		reg.tick();
		actual = Arrays.toString(reg.inputs());
		assertEquals(description, expected, actual);
	}
	
	@Test
	public void RegisterTest8() {
		String description = "Register outputs() method Test, inputs set to \"110\" - ";
		String expected = "[0, 1, 1]";
		String actual;
		Util.setInputs(reg, "110");
		reg.setEnabled(true);
		reg.tick();
		actual = Arrays.toString(reg.outputs());
		assertEquals(description, expected, actual);
	}
	
	@Test
	public void RegisterTest9() {
		String description = "Register inputsValid() method Test, inputs set to \"100\" - ";
		boolean expected = true;
		boolean actual;
		Util.setInputs(reg, "110");
		reg.setEnabled(true);
		reg.tick();
		actual = reg.inputsValid();
		assertEquals(description, expected, actual);
	}
	
	@Test
	public void RegisterTest10() {
		String description = "Register inputsValid() + invalidateinputs() method Test, inputs set to \"100\" - ";
		boolean expected = false;
		boolean actual;
		Util.setInputs(reg, "110");
		reg.setEnabled(true);
		reg.tick();
		reg.invalidateInputs();
		actual = reg.inputsValid();
		assertEquals(description, expected, actual);
	}
	
	@Test
	public void RegisterTest11() {
		String description = "Register outputsValid() method Test, inputs set to \"100\" - ";
		boolean expected = true;
		boolean actual;
		reg.setEnabled(true);
		reg.tick();
		actual = reg.outputsValid();
		assertEquals(description, expected, actual);
	}
	
	@Test
	public void RegisterTest12() {
		String description = "Register outputsValid() + invalidateOutputs() method Test, inputs set to \"100\" - ";
		boolean expected = true;
		boolean actual;
		reg.setEnabled(true);
		reg.tick();
		reg.invalidateOutputs();
		actual = reg.outputsValid();
		assertEquals(description, expected, actual);
	}
	
	@Test
	public void RegisterTest13() {
		String description = "Register outputs() method Test, inputs set to \"110\" - ";
		String expected = "[0, 1, 1]";
		String actual;
		Util.setInputs(reg, "110");
		reg.setEnabled(true);
		reg.tick();
		actual = Arrays.toString(reg.outputs());
		assertEquals(description, expected, actual);
	}

}