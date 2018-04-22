using NUnit.Framework;
using System;

namespace ThirdLab
{
	[TestFixture ()]
	public class MoodTest
	{
		[Test ()]
		public void TestCase ()
		{
			string exp = "You are in a good mood:\n" +
				"                                               \\(⌒ω⌒)/";
			Assert.AreEqual (exp, MoodSensor.Finder (1));
		}
	}
}

