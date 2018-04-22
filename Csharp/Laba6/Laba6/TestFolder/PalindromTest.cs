using NUnit.Framework;
using System;

namespace Laba6
{
	[TestFixture ()]
	public class PalindromTest
	{
		[Test ()]
		public void PalindromTester ()
		{
			int p = 30203;
			Assert.AreEqual (true, Palindrom.GetPalindrome (p));
		}
	}
}

