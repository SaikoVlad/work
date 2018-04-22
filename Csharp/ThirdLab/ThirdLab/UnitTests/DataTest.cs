using NUnit.Framework;
using System;

namespace ThirdLab
{
	[TestFixture ()]
	public class DataTest
	{
		[Test ()]
		public void TestCase ()
		{
			string wait = "2017.11.8";
			string real = DataOfNextDay.Next (2017, 11, 7);
			Assert.AreEqual (wait, real);
		}
	}
}