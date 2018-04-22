using System;

namespace Laba6
{
	public class NodAndNokFinder
	{
		public static int FinderOfNod(int a, int b) {
			return b == 0 ? a : FinderOfNod(b,a % b);
		}
		public static int FinderOfNok(int a, int b) {
			return (a/FinderOfNod(a, b) * b);
		}
	}
}

