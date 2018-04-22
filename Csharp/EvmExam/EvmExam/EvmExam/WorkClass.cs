using System;

namespace EvmExam
{
	public class WorkClass
	{
		public WorkClass ()
		{
		}

		public static void Division(double a, double b)
		{
			double res = a / b;
			if (res - (int)(res) == 0) {
				Console.WriteLine ("Int");
			} else {
				DoublePrint (res);
			}
		}

		private static void IntPrint(double a)
		{
			Console.WriteLine ("Your num is integer({0})",a);
		}

		private static void DoublePrint(double a)
		{
			string tempery = a.ToString ();
			string[] split = tempery.Split (',');

			//Console.WriteLine("\t\tZ = \t{0} \t.\t {1} ",split[0],split[1]);
			Console.ForegroundColor = ConsoleColor.Blue;
			Console.Write("\n\n\t\tZ = \t");
			Console.ForegroundColor = ConsoleColor.Green;
			Console.Write ("{0} ", split [0]);
			Console.ForegroundColor = ConsoleColor.Yellow;
			Console.Write ("\t.\t");
			Console.ForegroundColor = ConsoleColor.Red;
			Console.WriteLine (split [1] + "\n\n");
			Console.ForegroundColor = ConsoleColor.Black;

		}

	}
}