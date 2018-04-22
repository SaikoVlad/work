using System;

namespace Laba6
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			MainMenu ();
		}

		private static void MainMenu()
		{
			var work = true;
			int choice;
			int item;
			String again;
			while (work) {
				Out.Line("Take a choise:\n1 - Throw a coin\n2 - Check number for perfection\n3 - Reverse your number\n4 - Numbers operations\n5 - Exit\n->");
				try {
					choice = Read.Integer();
				} catch (Exception e) {
					Out.NewLine("Type error. Please, input integer.");
					continue;
				}
				switch (choice) {
				case 1:
					Out.Line("Input a limit for throwing: ");
					item = integerChecker();
					var head = HeadsOrTails.GetHeadResult(item);
					Out.NewLine("Heads: " + head);
					Out.NewLine("Tails: " + (item - head));
					break;
				case 2:
					Out.Line("Input a number for check: ");
					item = integerChecker();
					Out.NewLine("Result: " + PerfectOrNo.CheckerForPerfection(item));
					break;
				case 3:
					Out.Line("Input any number: ");
					item = integerChecker();
					Out.NewLine("Your reversed value: " + Reversed.Reverser(item));
					break;
				case 4:
					FourthMenu();
					break;
				default:
					work = false;
					break;
				}

			}//cycle
		}

		private static void FourthMenu()
		{
			int item, item1;
			Out.Line("\tChoose item of menu:\n\t1 - Sum And Quantity\n\t2 - Palindrom\n\t3 - Simple or not\n\t4 - Deviders\n\t5 - LCM and GCD finder\n\t6 - Max value\n\t-> ");
			int choise = integerChecker();
			switch (choise) {
			case 1:
				Out.Line("\tType some integer: ");
				item = integerChecker();
				Out.NewLine("\tSum is : " + SumAndQuantity.Sum(item));
				Out.NewLine("\tQuantity of numbers: " + SumAndQuantity.Quantity(item));
				break;
			case 2:
				Out.Line("\tIntput number: ");
				item = integerChecker();
				Out.NewLine("\tResult: " + Palindrom.GetPalindrome(item));
				break;
			case 3:
				Out.Line("\tInput your int value: ");
				item = integerChecker();
				Out.NewLine("\tResult is: " + SimpleOrNot.SimpleOrNotChecker(item));
				break;
			case 4:
				Out.Line("\tInput your value: ");
				item = integerChecker();
				Out.NewLine("\tDividers for " + item + ": " + Dividers.DividersFounder(item));
				break;
			case 5:
				Out.NewLine("\tType your numbers to find LCM and GCD: ");
				Out.Line("\t1)");
				item = integerChecker();
				Out.Line("\t2)");
				item1 = integerChecker();
				Out.NewLine("\tLCM: " + NodAndNokFinder.FinderOfNok(item, item1));
				Out.NewLine("\tGCD: " + NodAndNokFinder.FinderOfNod(item, item1));
				break;
			case 6:
				Out.Line ("Input some number:");
				item = integerChecker ();
				Out.NewLine ("Max value: " + MaxValue.MaxValueFounder (item));
				break;
			default:
				break;

			}
		}//fourthMenu

		private static int integerChecker() {
			int i;
			try {
				i = Read.Integer();
			} catch (Exception e) {
				Out.Line("Type error. Please, input integer.");
				return -1;
			}
			return i;
		}


	}
}
