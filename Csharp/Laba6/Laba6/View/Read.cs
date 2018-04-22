using System;

namespace Laba6
{
	public class Read
	{

		public static int Integer() {
			int input = Convert.ToInt32(Console.ReadLine ());
			return input;
		}
		public static String String() {
			String input = (Console.ReadLine ());
			return input;
		}
		public static double Double() {
			double input = Convert.ToDouble(Console.ReadLine ());
			return input;
		}
		public static bool Boolean() {
			bool input = Convert.ToBoolean(Console.ReadLine ());
			return input;
		}

	}
}

