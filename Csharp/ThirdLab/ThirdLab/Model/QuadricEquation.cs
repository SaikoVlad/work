using System;

namespace ThirdLab
{
	public class QuadricEquation
	{
		public static double Solver(double a, double b, double d, int k)
		{
			return (-b + k*Math.Sqrt(d))/(2*a);
		}
	}
}

