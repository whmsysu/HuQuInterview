package haominwu.test;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import haominwu.source.Solution;

public class SolutionTests {
	
	@Rule
    public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testIpToInt_correct_1() throws Exception {
		// 172.168.5.1=>2896692481L 
		char[] s = {'1','7','2','.','1','6','8','.','5','.','1'};
		assertEquals(2896692481L, Solution.ipToInteger(s));
	}
	
	@Test
	public void testIpToInt_correct_2() throws Exception {
		//255.255.255.255=>4294967295L
		char[] s = {'2','5','5','.','2','5','5','.','2','5','5','.','2','5', '5'};
		assertEquals(4294967295L, Solution.ipToInteger(s));
	}
	
	@Test
	public void testIpToInt_correct_withSpace() throws Exception {
		//172 .168.5.1=>2896692481L
		char[] s = {'1','7','2',' ','.','1','6','8','.','5','.','1'};
		assertEquals(2896692481L, Solution.ipToInteger(s));
	}
	
	@Test
	public void testIpToInt_correct_withSpace_2() throws Exception {
		// 172.168.5.1=>2896692481L
		char[] s = {' ','1','7','2','.','1','6','8','.','5','.','1'};
		assertEquals(2896692481L, Solution.ipToInteger(s));
	}
	
	@Test
	public void testIpToInt_correct_withSpaceAtEnd() throws Exception {
		//172.168.5.1 =>2896692481L
		char[] s = {'1','7','2','.','1','6','8',' ','.','5',' ','.','1',' '};
		assertEquals(2896692481L, Solution.ipToInteger(s));
	}
	
	@Test
	public void testIpToInt_invalidFormat_withSpace() throws Exception {
		//1 72.168.5.1 throw invalid format exception
		char[] s = {'1',' ','7','2','.','1','6','8','.','5','.','1'};
		exception.expectMessage("Invalid Format");
		Solution.ipToInteger(s);
	}
	
	@Test
	public void testIpToInt_invalidFormat_outOfRangeInteger() throws Exception {
		//256.168.5.1 throw invalid format exception
		char[] s = {'2','5','6','.','1','6','8','.','5','.','1'};
		exception.expectMessage("Invalid Format");
		Solution.ipToInteger(s);
	}

	
	@Test
	public void testIpToInt_invalidFormat_invalidChar_1() throws Exception {
		//2e6.168.5.1 throw invalid format exception 
		char[] s = {'2','e','6','.','1','6','8','.','5','.','1'};
		exception.expectMessage("Invalid Format");
		Solution.ipToInteger(s);
	}
	
	@Test
	public void testIpToInt_invalidFormat_invalidChar_2() throws Exception {
		//172.168.5.e throw invalid format exception 
		char[] s = {'1','7','2','.','1','6','8','.','5','.','e'};
		exception.expectMessage("Invalid Format");
		Solution.ipToInteger(s);
	}
	
	@Test
	public void testIpToInt_invalidFormat_invalidChar_3() throws Exception {
		//172.168.5.e throw invalid format exception 
		char[] s = {'-','1','7','2','.','1','6','8','.','5','.','1'};
		exception.expectMessage("Invalid Format");
		Solution.ipToInteger(s);
	}
	
	@Test
	public void testIpToInt_invalidFormat_threeSections_1() throws Exception {
		//172.168.5 throw invalid format exception 
		char[] s = {'1','7','2','.','1','6','8','.','5'};
		exception.expectMessage("Invalid Format");
		Solution.ipToInteger(s);
	}
	
	
	@Test
	public void testIpToInt_invalidFormat_threeSections_2() throws Exception {
		//.168.5.1 throw invalid format exception 
		char[] s = {'.','1','6','8','.','5','1'};
		exception.expectMessage("Invalid Format");
		Solution.ipToInteger(s);
	}
	
	@Test
	public void testIpToInt_invalidFormat_threeSections_3() throws Exception {
		//172.168.5. throw invalid format exception
		char[] s = {'1','7','2','.','1','6','8','.','5','.'};
		exception.expectMessage("Invalid Format");
		Solution.ipToInteger(s);
	}
	
	@Test
	public void testIpToInt_invalidFormat_fiveSections() throws Exception {
		//172.168.5.1.0 throw invalid format exception
		char[] s = {'1','7','2','.','1','6','8','.','5','.','1', '.', '0'};
		exception.expectMessage("Invalid Format");
		Solution.ipToInteger(s);
	}

	
}
