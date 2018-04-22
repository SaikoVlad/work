using System;

namespace laba36
{
	public class DragonHeads
	{

		public static int HeadFinder(int years)
		{
			int result = 0;
			if (years < 200 && years > 0) {
				result = FirstFinder (years);
				return result;
			} else if (years >= 200 && years < 300) {
				result = SecondFinder (years);
				return result;
			} else if (years >= 300 && years > 0) {
				result = SecondFinder (years);
				years -= 300;
				for (int i = 0; i < years; i++) {
					result += 1;
				}
				return result;
			} else {
				return 12;
			}
		
		}



		private static int RanHeads()
		{
			Random random = new Random ();
			return random.Next (2, 5);
		}

		private static int SecondFinder(int years)
		{
			years -= 200;
			int result = FirstFinder (years);
			for (int i = 0; i < years; i++) 
			{
				result += 2;
			}
			return result;
		}

		private static int FirstFinder(int years)
		{
			int result = 0;
			for (int i = 0; i < years; i++)
			{
				result += RanHeads();
			}
			return result;
		}

		public static int EyeFinder(int heads)
		{
			return heads * 2;
		}



	}
}

