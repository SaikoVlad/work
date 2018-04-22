using System;
namespace EvmExam
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			//Console.BackgroundColor = ConsoleColor.White;
			Console.Clear ();
			Cycle ();
		}
		private static void Cycle()
		{
			double first, second;
			while (true)
			{
				Console.ForegroundColor = ConsoleColor.Black;
				Console.WriteLine ("1 - Calculate values\n\tany other key to exit...");
				string choice = Console.ReadLine ();
				if (choice != "1")
				{
					break;
				}
				try
				{
					Console.Clear();
					Console.Write("Input first value: ");
					first = Convert.ToDouble(Console.ReadLine());
					Console.Write("Input second value: ");
					second = Convert.ToDouble(Console.ReadLine());
					WorkClass.Division(first,second);
				}catch(Exception) {
					Console.WriteLine ("Incorrect input! Please, be careful");
					continue;
				}

			}
		}
	}
}
