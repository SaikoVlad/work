using System;

namespace Laba6
{
	public class PerfectOrNo
	{
		
		public static bool CheckerForPerfection(int n) {
			int summa = 0;
			for (int i = 1; i < n; i++) {
				if (n % i == 0) {
					summa += i;
				}
			}
			if (summa == n) {
				return true;
			} else {
				return false;
			}
		}

	}
}

