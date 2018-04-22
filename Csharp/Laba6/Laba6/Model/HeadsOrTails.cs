using System;

namespace Laba6
{
	public class HeadsOrTails
	{
		public static int GetHeadResult(int maxValue){
			Random random = new Random();
			int tails = 0;
			int result = 0;
			for (int i = 0; i < maxValue; i++) {
				result = random.Next(2);
				if (result == 0) {
					tails++;
				}
			}


			return tails;
		}

		private static int Heads(int maxValue,int tails){
			return maxValue - tails;
		}
	}
}

