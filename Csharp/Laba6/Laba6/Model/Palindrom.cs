using System;

namespace Laba6
{
	public class Palindrom
	{

		public static bool GetPalindrome(int pal) {
			int next = 0;
			int pal2 = pal;

			while (pal2 != 0) {
				next = (next * 10) + (pal2 % 10);
				pal2 /= 10;
			}

			if (pal == next) {
				return true;
			} else {
				return false;
			}
		}

	}
}

