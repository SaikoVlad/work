using System;

namespace ThirdLab
{
	public class Dragon
	{
		public static string HeadsAndEyes(int ages)
		{
			String result;

			if(ages < 1) {
				result = "Uncorrect age!";
			}
			else if(ages < 201 && ages > 0) {
				result = "Heads: " + ages*3 + ".\nEyes: " + ages*6 +".";
			}
			else if(ages < 301 && ages > 200) {
				result = "Heads: " + (200*3+(ages-200)*2) + ".\nEyes: " + (200*6+(ages-200)*4) +".";
			}
			else {
				result = "Heads: " + (200*3+100*2+(ages-300)) + ".\nEyes: " + (200*6+100*4+(ages-300)*2) +".";
			}

			return result;
		}
	}
}

