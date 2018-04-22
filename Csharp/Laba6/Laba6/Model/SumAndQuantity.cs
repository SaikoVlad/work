using System;

namespace Laba6
{
	public class SumAndQuantity
	{

		public static int Sum(int n)
		{
			
			int sum = 0, count = 0;
			while (n != 0)
			{
				sum = sum + (n % 10);
				n /= 10;
				count++;
			}

			return sum;
		}
		public static int Quantity(int n)
		{
			int count = 0;
			while (n!=0){
				n /= 10;
				count++;
			}

			return count;
		}

	}
}

