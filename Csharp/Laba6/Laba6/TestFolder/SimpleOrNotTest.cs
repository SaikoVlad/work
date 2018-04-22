using NUnit.Framework;
using System;

namespace Laba6
{
	[TestFixture ()]
	public class SimpleOrNotTest
	{
		[Test ()]
		public void SimpleOrNotTester ()
		{
			int nonsimple = 4;
			Assert.AreEqual (false, SimpleOrNot.SimpleOrNotChecker (nonsimple));
		}
	}
}

