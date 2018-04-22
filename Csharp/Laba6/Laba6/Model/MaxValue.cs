using System;

namespace Laba6
{
	public class MaxValue
	{

		public static char MaxValueFounder(int li) {

			String line = li.ToString();
			char[] massive = line.ToCharArray();
			Array.Sort(massive);
			return massive[massive.Length - 1];

		}

	}
}

