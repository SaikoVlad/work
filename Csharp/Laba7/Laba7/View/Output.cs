using System;

namespace View
{
	public class Output
	{
		public static void Write (string outer)
		{
			Console.Write (outer);
		}

		public static void WriteLine (string outer)
		{
			Console.WriteLine (outer);
		}

		public static void Write (int outer)
		{
			Console.Write (outer);
		}

		public static void WriteLine (int outer)
		{
			Console.WriteLine (outer);
		}

		public static void Write (double outer)
		{
			Console.Write (outer);
		}

		public static void WriteLine (double outer)
		{
			Console.WriteLine (outer);
		}

		public static void WriteMass (int rows, int columns, int[,]matrix)
		{
			string outer = "";
			for (int i = 0; i < rows; i++) 
			{
				for (int j = 0; j < columns; j++)
				{
					outer += "\t" + matrix[i,j];
				}
				outer += "\n\n";
			}
			Output.WriteLine(outer);
		}

	}
}

