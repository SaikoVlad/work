using System;

namespace Laba6
{
	public class Dividers
	{

		public static int DividersFounder(int n)
		{

			int count = 0;
			for (int i = 1; i <= n; i++) {
				if ((n % i) == 0) {
					count++;
				}
			}
			return count;

		}

	}
}

