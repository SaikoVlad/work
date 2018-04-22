using System;

namespace ThirdLab
{
	public class MoodSensor
	{
		public static string Finder(int x)
		{
			string result;

			if (x == 0) {
				result = "You are in a basic mood:\n" +
					"                                               ¯\\_(ー_ー )_/¯";
			} else if (x == 1) {
				result = "You are in a good mood:\n" +
					"                                               \\(⌒ω⌒)/";
			} else if (x == 2) {
				result = "You are in a great mood: \n" +
					"                                               ╰(✯∀✯)╯";
			} else if (x == 3) {
				result = "You are in a bad mood(Please, don't cry): \n" +
					"                                               /(￣︿￣)\\";
			} else {
				result = "You are in an aweful mood(Sorry): \n" +
					"                                               \\(◣_◢)/";
			}

			return result;
		}
	}
}

