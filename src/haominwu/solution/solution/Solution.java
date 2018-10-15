package haominwu.solution.solution;

import haominwu.solution.exception.InvalidFormatException;

/**
Programming Question:
Convert an IPv4 address in the format of null-terminated C string into a 32-bit integer. For example, given an IP address “172.168.5.1”, the output should be a 32-bit integer with “172” as the highest order 8 bit, 168 as the second highest order 8 bit, 5 as the second lowest order 8 bit, and 1 as the lowest order 8 bit. That is,
"172.168.5.1" => 2896692481 Requirements:
1. You can only iterate the string once.
2. You should handle spaces correctly: a string with spaces between a digit and a dot is a valid input; while a string with spaces between two digits is not.
"172[Space].[Space]168.5.1" is a valid input. Should process the output normally.
"1[Space]72.168.5.1" is not a valid input. Should report an error. 3. Please provide unit tests.
**/

public class Solution {
	/**
	 * Transfer ip address to long integer
	 * @param s c_string ip address
	 * @return integer transferred by ip address
	 * @throws Exception invalid format 
	 */
	public static long ipToInteger(char[] s) throws InvalidFormatException {
        //Indicate if the section has a space
		boolean hasSpace = false;
		//Indicate if the section has a digit
        boolean sectionHasInt = false;
        int sectionInteger = 0;
        long result = 0;
        //Shift for each section
        int[] shifts = {24, 16, 8, 0};
        int sectionIndex = 0;
        for(int i=0;i<s.length;i++){
            if (s[i]>='0' && s[i]<='9') {
            	//Detect a digit
            	if (hasSpace && sectionHasInt) {
            		//Space between two digits
                    throw new InvalidFormatException("Invalid Format");
                }
            	
            	hasSpace = false;
            	sectionHasInt = true;
                sectionInteger = sectionInteger * 10 + s[i] - '0';
                if (sectionInteger > 255) {
                	// Integer in one ip address section is larger than 255
                	throw new InvalidFormatException("Invalid Format");
                }
            }
            else if (s[i] == ' ') {
                hasSpace = true; 
            }
            else if (s[i] == '.') {
            	if (!sectionHasInt) {
            		//No integer in one ip address section
            		throw new InvalidFormatException("Invalid Format");
            	}
                hasSpace = false;
                //Shift the integer in each section 
                result += (long)sectionInteger<<shifts[sectionIndex];
                sectionInteger = 0;
                sectionIndex++;
                if (sectionIndex > 3) {
                	// Input ip address has more than 4 sections
                	throw new InvalidFormatException("Invalid Format");
                }
                sectionHasInt = false;
            }
            else {
            	throw new InvalidFormatException("Invalid Format");
            }
        }
        
        // Handle the last section
        if (!sectionHasInt) {
        	throw new InvalidFormatException("Invalid Format");
    	}
        
        if (sectionIndex != 3) {
        	// Input ip address has less than 4 sections
        	throw new InvalidFormatException("Invalid Format");
        }
        
        result += (long)sectionInteger<<shifts[sectionIndex];
        return result;    
    }     
}
