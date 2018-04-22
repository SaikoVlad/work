using System;

namespace ThirdLab
{
	public class Input
	{
		public static int Integer()
		{
			int i;
			try
			{
				i = int.Parse(Console.ReadLine());

			}catch {
				Output.PrintLn ("Incorrect input");
				return -898;
			}
			return i;
		}
	}
}

