using NUnit.Framework;
using System;

namespace ThirdLab
{
	[TestFixture ()]
	public class QuadTest
	{
		[Test ()]
		public void TestCase ()
		{

			double wait = -0.5;
			double real = QuadricEquation.Solver(2, 3, 1, 1);

			Assert.AreEqual (wait, real,0.1);
		}
	}
}

