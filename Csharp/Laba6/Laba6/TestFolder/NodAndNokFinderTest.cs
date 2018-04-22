using NUnit.Framework;
using System;

namespace Laba6
{
	[TestFixture ()]
	public class NodAndNokFinderTest
	{
		[Test ()]
		public void Nod ()
		{
			int nod = 3;
			Assert.AreEqual (nod, NodAndNokFinder.FinderOfNod (3, 24));
		}

		[Test()]
		public void Nok()
		{
			int nok = 3;
			Assert.AreEqual (nok, NodAndNokFinder.FinderOfNod (3, 24));
		}

	}
}

