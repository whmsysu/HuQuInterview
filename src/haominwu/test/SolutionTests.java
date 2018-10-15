package haominwu.test;
import static org.junit.Assert.*;
import org.junit.Test;

import haominwu.solution.solution.Solution;
import haominwu.solution.exception.InvalidFormatException;;

public class SolutionTests {
	
	@Test
	public void testIpToInt_correct_1() throws InvalidFormatException {
		// 172.168.5.1=>2896692481L 
		char[] s = {'1','7','2','.','1','6','8','.','5','.','1'};
		assertEquals(2896692481L, Solution.ipToInteger(s));
	}
	
	@Test
	public void testIpToInt_correct_2() throws InvalidFormatException {
		//255.255.255.255=>4294967295L
		char[] s = {'2','5','5','.','2','5','5','.','2','5','5','.','2','5', '5'};
		assertEquals(4294967295L, Solution.ipToInteger(s));
	}
	
	@Test
	public void testIpToInt_correct_3() throws InvalidFormatException {
		//255.255.255.255=>4294967295L
		char[] s = {'0','.','0', '.','0', '.', '0'};
		assertEquals(0L, Solution.ipToInteger(s));
	}
	
	@Test
	public void testIpToInt_correct_withSpace() throws InvalidFormatException {
		//172 .168.5.1=>2896692481L
		char[] s = {'1','7','2',' ','.','1','6','8','.','5','.','1'};
		assertEquals(2896692481L, Solution.ipToInteger(s));
	}
	
	@Test
	public void testIpToInt_correct_withSpace_2() throws InvalidFormatException {
		// 172.168.5.1=>2896692481L
		char[] s = {' ','1','7','2','.','1','6','8','.','5','.','1'};
		assertEquals(2896692481L, Solution.ipToInteger(s));
	}
	
	@Test
	public void testIpToInt_correct_withSpace_3() throws InvalidFormatException {
		// 172.168.5.1=>2896692481L
		char[] s = {'1','7','2','.', ' ', '1','6','8','.','5','.','1'};
		assertEquals(2896692481L, Solution.ipToInteger(s));
	}
	
	@Test
	public void testIpToInt_correct_withSpaceAtEnd() throws InvalidFormatException {
		//172.168.5.1 =>2896692481L
		char[] s = {'1','7','2','.','1','6','8',' ','.','5',' ','.','1',' '};
		assertEquals(2896692481L, Solution.ipToInteger(s));
	}
	
	@Test(expected = InvalidFormatException.class)
	public void testIpToInt_invalidFormat_withSpace() throws InvalidFormatException {
		//1 72.168.5.1 throw invalid format exception
		char[] s = {'1',' ','7','2','.','1','6','8','.','5','.','1'};
		Solution.ipToInteger(s);
	}
	
	@Test(expected = InvalidFormatException.class)
	public void testIpToInt_invalidFormat_outOfRangeInteger() throws InvalidFormatException {
		//256.168.5.1 throw invalid format exception
		char[] s = {'2','5','6','.','1','6','8','.','5','.','1'};
		Solution.ipToInteger(s);
	}

	@Test(expected = InvalidFormatException.class)
	public void testIpToInt_invalidFormat_invalidChar_1() throws InvalidFormatException {
		//2e6.168.5.1 throw invalid format exception 
		char[] s = {'2','e','6','.','1','6','8','.','5','.','1'};
		Solution.ipToInteger(s);
	}
	
	@Test(expected = InvalidFormatException.class)
	public void testIpToInt_invalidFormat_invalidChar_2() throws InvalidFormatException {
		//172.168.5.e throw invalid format exception 
		char[] s = {'1','7','2','.','1','6','8','.','5','.','e'};
		Solution.ipToInteger(s);
	}
	
	@Test(expected = InvalidFormatException.class)
	public void testIpToInt_invalidFormat_invalidChar_3() throws InvalidFormatException {
		//172.168.5.e throw invalid format exception 
		char[] s = {'-','1','7','2','.','1','6','8','.','5','.','1'};
		Solution.ipToInteger(s);
	}
	
	@Test(expected = InvalidFormatException.class)
	public void testIpToInt_invalidFormat_threeSections_1() throws InvalidFormatException {
		//172.168.5 throw invalid format exception 
		char[] s = {'1','7','2','.','1','6','8','.','5'};
		Solution.ipToInteger(s);
	}
	
	
	@Test(expected = InvalidFormatException.class)
	public void testIpToInt_invalidFormat_threeSections_2() throws InvalidFormatException {
		//.168.5.1 throw invalid format exception 
		char[] s = {'.','1','6','8','.','5','1'};
		Solution.ipToInteger(s);
	}
	
	@Test(expected = InvalidFormatException.class)
	public void testIpToInt_invalidFormat_threeSections_3() throws InvalidFormatException {
		//172.168.5. throw invalid format exception
		char[] s = {'1','7','2','.','1','6','8','.','5','.'};
		Solution.ipToInteger(s);
	}
	
	@Test(expected = InvalidFormatException.class)
	public void testIpToInt_invalidFormat_fiveSections() throws InvalidFormatException {
		//172.168.5.1.0 throw invalid format exception
		char[] s = {'1','7','2','.','1','6','8','.','5','.','1', '.', '0'};
		Solution.ipToInteger(s);
	}

	
}
