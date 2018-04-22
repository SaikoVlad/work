using NUnit.Framework;
using System;

namespace Laba6
{
	[TestFixture ()]
	public class MaxValueTest
	{
		[Test ()]
		public void TestCase ()
		{
			int i = 123;
			Assert.AreEqual ('3', MaxValue.MaxValueFounder (i));
		}
	}
}

