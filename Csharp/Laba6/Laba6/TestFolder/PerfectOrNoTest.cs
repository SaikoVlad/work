using NUnit.Framework;
using System;

namespace Laba6
{
	[TestFixture ()]
	public class PerfectOrNoTest
	{
		[Test ()]
		public void PerfectionTest ()
		{
			int perfect = 496;
			Assert.AreEqual (true, PerfectOrNo.CheckerForPerfection (perfect));
		}
	}
}

