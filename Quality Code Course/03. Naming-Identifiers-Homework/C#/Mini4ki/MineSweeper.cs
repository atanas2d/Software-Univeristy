using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace mini4ki
{
    public class MineSweeper
    {
        public class RankingSystem
        {
            private string name;

            private int points;

            public string Name
            {
                get
                {
                    return name;
                }

                set
                {
                    name = value;
                }
            }

            public int Points
            {
                get
                {
                    return points;
                }

                set
                {
                    points = value;
                }
            }

            public RankingSystem()
            {
            }

            public RankingSystem(string name, int points)
            {
                this.name = name;
                this.points = points;
            }
        }

        private static void Main(string[] args)
        {
            string command = string.Empty;
            char[,] field = createPlayground();
            char[,] bombs = locateBombs();
            int counter = 0;
            bool boom = false;
            List<RankingSystem> champions = new List<RankingSystem>(6);
            int row = 0;
            int column = 0;
            bool flag = true;
            const int max = 35;
            bool flag2 = false;

            do
            {
                if (flag)
                {
                    Console.WriteLine(
                        "Hajde da igraem na “Mini4KI”. Probvaj si kasmeta da otkriesh poleteta bez mini4ki."
                        + " Komanda 'top' pokazva klasiraneto, 'restart' po4va nova igra, 'exit' izliza i hajde 4ao!");
                    dump(field);
                    flag = false;
                }

                Console.Write("Daj red i kolona : ");
                command = Console.ReadLine().Trim();
                if (command.Length >= 3)
                {
                    if (int.TryParse(command[0].ToString(), out row) && 
                        int.TryParse(command[2].ToString(), out column) && 
                        row <= field.GetLength(0) && 
                        column <= field.GetLength(1))
                    {
                        command = "turn";
                    }
                }

                switch (command)
                {
                    case "top":
                        topRankings(champions);
                        break;
                    case "restart":
                        field = createPlayground();
                        bombs = locateBombs();
                        dump(field);
                        boom = false;
                        flag = false;
                        break;
                    case "exit":
                        Console.WriteLine("4a0, 4a0, 4a0!");
                        break;
                    case "turn":
                        if (bombs[row, column] != '*')
                        {
                            if (bombs[row, column] == '-')
                            {
                                playerTurn(field, bombs, row, column);
                                counter++;
                            }

                            if (max == counter)
                            {
                                flag2 = true;
                            }
                            else
                            {
                                dump(field);
                            }
                        }
                        else
                        {
                            boom = true;
                        }

                        break;
                    default:
                        Console.WriteLine("\nGreshka! nevalidna Komanda\n");
                        break;
                }

                if (boom)
                {
                    dump(bombs);
                    Console.Write("\nHrrrrrr! Umria gerojski s {0} to4ki. " + "Daj si niknejm: ", counter);
                    string nickName = Console.ReadLine();
                    RankingSystem t = new RankingSystem(nickName, counter);
                    if (champions.Count < 5)
                    {
                        champions.Add(t);
                    }
                    else
                    {
                        for (int i = 0; i < champions.Count; i++)
                        {
                            if (champions[i].Points < t.Points)
                            {
                                champions.Insert(i, t);
                                champions.RemoveAt(champions.Count - 1);
                                break;
                            }
                        }
                    }

                    champions.Sort((RankingSystem r1, RankingSystem r2) => r2.Name.CompareTo(r1.Name));
                    champions.Sort((RankingSystem r1, RankingSystem r2) => r2.Points.CompareTo(r1.Points));
                    topRankings(champions);

                    field = createPlayground();
                    bombs = locateBombs();
                    counter = 0;
                    boom = false;
                    flag = true;
                }

                if (flag2)
                {
                    Console.WriteLine("\nBRAVOOOS! Otvri 35 kletki bez kapka kryv.");
                    dump(bombs);
                    Console.WriteLine("Daj si imeto, batka: ");
                    string imeee = Console.ReadLine();
                    RankingSystem points = new RankingSystem(imeee, counter);
                    champions.Add(points);
                    topRankings(champions);
                    field = createPlayground();
                    bombs = locateBombs();
                    counter = 0;
                    flag2 = false;
                    flag = true;
                }
            }
            while (command != "exit");
            Console.WriteLine("Made in Bulgaria - Uauahahahahaha!");
            Console.WriteLine("AREEEEEEeeeeeee.");
            Console.Read();
        }

        private static void topRankings(List<RankingSystem> points)
        {
            Console.WriteLine("\nTo4KI:");
            if (points.Count > 0)
            {
                for (int i = 0; i < points.Count; i++)
                {
                    Console.WriteLine("{0}. {1} --> {2} kutii", i + 1, points[i].Name, points[i].Points);
                }

                Console.WriteLine();
            }
            else
            {
                Console.WriteLine("prazna klasaciq!\n");
            }
        }

        private static void playerTurn(char[,] POLE, char[,] BOMBI, int RED, int KOLONA)
        {
            char bombCounter = bombCount(BOMBI, RED, KOLONA);
            BOMBI[RED, KOLONA] = bombCounter;
            POLE[RED, KOLONA] = bombCounter;
        }

        private static void dump(char[,] board)
        {
            int legnth = board.GetLength(0);
            int height = board.GetLength(1);
            Console.WriteLine("\n    0 1 2 3 4 5 6 7 8 9");
            Console.WriteLine("   ---------------------");
            for (int i = 0; i < legnth; i++)
            {
                Console.Write("{0} | ", i);
                for (int j = 0; j < height; j++)
                {
                    Console.Write(string.Format("{0} ", board[i, j]));
                }

                Console.Write("|");
                Console.WriteLine();
            }

            Console.WriteLine("   ---------------------\n");
        }

        private static char[,] createPlayground()
        {
            int boardRows = 5;
            int boardColumns = 10;
            char[,] board = new char[boardRows, boardColumns];
            for (int i = 0; i < boardRows; i++)
            {
                for (int j = 0; j < boardColumns; j++)
                {
                    board[i, j] = '?';
                }
            }

            return board;
        }

        private static char[,] locateBombs()
        {
            int rows = 5;
            int columns = 10;
            char[,] playGround = new char[rows, columns];

            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < columns; j++)
                {
                    playGround[i, j] = '-';
                }
            }

            List<int> listOfBombs = new List<int>();
            while (listOfBombs.Count < 15)
            {
                Random random = new Random();
                int cellNum = random.Next(50);
                if (!listOfBombs.Contains(cellNum))
                {
                    listOfBombs.Add(cellNum);
                }
            }

            foreach (int i2 in listOfBombs)
            {
                int column = i2 / columns;
                int row = i2 % columns;
                if (row == 0 && i2 != 0)
                {
                    column--;
                    row = columns;
                }
                else
                {
                    row++;
                }

                playGround[column, row - 1] = '*';
            }

            return playGround;
        }

        private static void calculations(char[,] playGround)
        {
            int column = playGround.GetLength(0);
            int row = playGround.GetLength(1);

            for (int i = 0; i < column; i++)
            {
                for (int j = 0; j < row; j++)
                {
                    if (playGround[i, j] != '*')
                    {
                        char bombCounter = bombCount(playGround, i, j);
                        playGround[i, j] = bombCounter;
                    }
                }
            }
        }

        private static char bombCount(char[,] playGround, int length, int height)
        {
            int count = 0;
            int columns = playGround.GetLength(0);
            int rows = playGround.GetLength(1);

            if (length - 1 >= 0)
            {
                if (playGround[length - 1, height] == '*')
                {
                    count++;
                }
            }

            if (length + 1 < columns)
            {
                if (playGround[length + 1, height] == '*')
                {
                    count++;
                }
            }

            if (height - 1 >= 0)
            {
                if (playGround[length, height - 1] == '*')
                {
                    count++;
                }
            }

            if (height + 1 < rows)
            {
                if (playGround[length, height + 1] == '*')
                {
                    count++;
                }
            }

            if ((length - 1 >= 0) && (height - 1 >= 0))
            {
                if (playGround[length - 1, height - 1] == '*')
                {
                    count++;
                }
            }

            if ((length - 1 >= 0) && (height + 1 < rows))
            {
                if (playGround[length - 1, height + 1] == '*')
                {
                    count++;
                }
            }

            if ((length + 1 < columns) && (height - 1 >= 0))
            {
                if (playGround[length + 1, height - 1] == '*')
                {
                    count++;
                }
            }

            if ((length + 1 < columns) && (height + 1 < rows))
            {
                if (playGround[length + 1, height + 1] == '*')
                {
                    count++;
                }
            }

            return char.Parse(count.ToString());
        }
    }
}