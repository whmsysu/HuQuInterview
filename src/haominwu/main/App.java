package haominwu.main;

import haominwu.solution.exception.InvalidFormatException;
import haominwu.solution.solution.Solution;

public class App {

	public static void main(String[] args) throws InvalidFormatException {
		char[] s = {'1','7','2','.','1','6','8','.','5','.','1'};
		System.out.println(Solution.ipToInteger(s));
	}
	
}
