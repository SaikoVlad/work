using System;

namespace Laba6
{
	public class Reversed
	{

		public static int Reverser(int digit) {
			int res = 0;
			while (true) {
				if (digit > 0) {
					res = digit % 10 + res * 10;
					digit /= 10;
				} else {
					break;
				}
			}
			return res;
		}

	}
}

