using System;

namespace Laba6
{
	public class SimpleOrNot
	{

		public static bool SimpleOrNotChecker(int n) {
			bool f = true;
			int i;
			for (i = 2; i < n; i++) {
				if (n % i == 0) {
					f = false;
					break;
				}
			}
			if (f) {
				return true;
			} else {
				return false;
			}
		}

	}
}

