using NUnit.Framework;
using System;

namespace Laba6
{
	[TestFixture ()]
	public class DividersTest
	{
		[Test ()]
		public void TestCase ()
		{
			Assert.AreEqual (2, Dividers.DividersFounder (3));
		}
	}
}

