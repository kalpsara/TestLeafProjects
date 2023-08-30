package dailychallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
	public static boolean isAnagram(String input1, String input2) {
		

		// Remove all the white space and convert to lower case
		input1 = input1.replaceAll("\\s", "").toLowerCase();
		input2 = input2.replaceAll("\\s", "").toLowerCase();

		// Check length of both strings
		if (input1.length() != input2.length())
			return false;
		else
		{
			for (int i = 0; i < input1.length(); i++)
			{
				for (int j = 0; j < input2.length(); j++)
				{
					if (input1.charAt(i) == input2.charAt(j))
					{
						input2 = input2.substring(0, j) + input2.substring(j + 1);
						break;
					}
				}
			}

			if (input2.length() == 0)
			{
				return true;
			} else
			{
				return false;
			}}

	}

	public static void main(String[] args) {
		System.out.println(isAnagram("stop", "post"));

	}

}
