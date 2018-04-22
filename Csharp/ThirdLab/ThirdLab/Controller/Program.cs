using System;

namespace ThirdLab
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			
			Menu ();

		}

		private static void Menu()
		{
			Output.PrintLn ("Welcome");
			Random random = new Random ();
			bool okay = true;
			string choise;
			while (okay)
			{
				Output.Print ("\n\nChoose something:\n1 - Calculate Dragon heads\n2 - Find Out Your MoodFace\n3 - Solve Quadric Equation\n4 - Play Dice Game\n5 - Exit\n\n->");
				choise = Console.ReadLine ().ToLower();
				int param1;
				switch (choise)
				{
				case "1":
					Output.Print ("How old are dragon?\n-->");
					param1 = CorrectInteger ();
					Output.PrintLn (Dragon.HeadsAndEyes (param1));
					break;
				case "2":
					Output.PrintLn (MoodSensor.Finder (random.Next (5)));
					break;
				case "3":
					MenuForQuadEquation ();
					break;
				case "4":
					MenuForDice ();
					break;
				case "5": 
					okay = false;
					break;

				default:
					Output.PrintLn ("Uncorrect input. Please, try again");
					break;
					

				}
			}



		}

		private static bool CheckerForWrongInput(int i)
		{
			if (i != -898) {
				return true;
			}
			else
			{
				return false;
			}
		}

		private static int CorrectInteger()
		{
			int i;
			try
			{
				i = int.Parse(Console.ReadLine());
				return i;
			}
			catch
			{
				Output.PrintLn ("Please, input correct number");
				return -898;
			}
		}

		private static void MenuForQuadEquation()
		{
			double a, b, c, d, x1, x2;

			Output.Print("Hello, I can solve equation: ax^2+bx+c=0.\n");
			Output.Print ("Input a:");
			a = CorrectInteger ();
			Output.Print ("Input b:");
			b = CorrectInteger ();
			Output.Print ("Input d:");
			c = CorrectInteger ();


			if (a != 0) {
				d = b * b - 4 * a * c;

				if (d > 0) {
					x1 = QuadricEquation.Solver(a, b, d, 1);
					x2 = QuadricEquation.Solver(a, b, d, -1);

					Output.Print("\nThere are two decisions:");
					Output.Print("\nx1 = " + x1);
					Output.Print("\nx2 = " + x2);
				} else if (d == 0) {
					x1 = QuadricEquation.Solver(a, b, d, 1);

					Output.Print("\nThere are two decisions but they are the same:");
					Output.Print("\nx1 = x2 = " + x1);
				} else {
					Output.Print("\nNo decision!");
				}
			} else {
				Output.Print("\nA can't equals 0!!!");
			}
		}

		private static void MenuForDice()
		{
			
			string s,choise;
			int you1, you2, ya1, ya2;

			Output.PrintLn("Hello,Lets play a game!");
			while (true) {
				while (true) {
					Output.PrintLn("Choose who will be the first: Type 1 to be first " +
						"or 2 to be second");
					choise = Console.ReadLine ();

					if (choise.Equals("1")) {
						Output.PrintLn("Okay, you first.\nPress Enter to throw a bones.");
						s = Console.ReadLine();
						you1 = Dice.GameMaker();
						you2 = Dice.GameMaker();
						Output.PrintLn("The result is: " + you1 + " and " + you2 +
							" , both - " + (you1 + you2) + ".");
						Output.PrintLn("My turn. Press Enter to throw my bones.");
						s = Console.ReadLine();
						ya1 = Dice.GameMaker();
						ya2 = Dice.GameMaker();
						Output.PrintLn("The result is: " + ya1 + " and " + ya2 +
							" , both - " + (ya1 + ya2) + ".");
						break;
					} else if (choise.Equals("2")) {
						Output.PrintLn("Okay, i am first.\nPress Enter to throw bones.");
						s = Console.ReadLine();
						ya1 = Dice.GameMaker();
						ya2 = Dice.GameMaker();
						Output.PrintLn("The result is: " + ya1 + " and " + ya2 +
							" , both - " + (ya1 + ya2) + ".");
						Output.PrintLn("Your turn. Press Enter to throw bones.");
						s = Console.ReadLine();
						you1 = Dice.GameMaker();
						you2 = Dice.GameMaker();
						Output.PrintLn("The result is: " + you1 + " and " + you2 +
							" , both - " + (you1 + you2) + ".");
						break;
					} else {
						Output.PrintLn("Choose 1 or 2!!!");
					}
				}
				if (ya1 + ya2 > you1 + you2) {
					Output.PrintLn("Lol, I am winner!");
				} else if (you1 + you2 > ya1 + ya2) {
					Output.PrintLn("Congratulations!You win");
				} else {
					Output.PrintLn("Draw!");
				}
				Output.PrintLn("Press Enter to repeat or 0 to exit.");
				s = Console.ReadLine();
				if (s.Equals("0")) {
					break;
				}
			}
		}


	}
}
