using NUnit.Framework;
using System;

namespace Laba6
{
	[TestFixture ()]
	public class SumAndQuantityTest
	{
		[Test ()]
		public void SumTester ()
		{
			int sum = 45;
			Assert.AreEqual (9, SumAndQuantity.Sum (sum));
		}
		public void Quantity()
		{
			int qu = 45;
			Assert.AreEqual (2, SumAndQuantity.Quantity (qu));
		}
	}
}

