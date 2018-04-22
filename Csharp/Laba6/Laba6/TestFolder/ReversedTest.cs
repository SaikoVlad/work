using NUnit.Framework;
using System;

namespace Laba6
{
	[TestFixture ()]
	public class ReversedTest
	{
		[Test ()]
		public void ReverserTest ()
		{
			int rev = 12345;
			Assert.AreEqual (54321, Reversed.Reverser (rev));
		}
	}
}

