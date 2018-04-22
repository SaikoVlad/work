using System;

namespace ThirdLab
{
	public class Dice
	{
		public static int GameMaker()
		{
			Random random = new Random();
			return (random.Next(0,6));
		}
	}
}

