using System;
using System.Threading;

namespace AsynchronousTimer
{
    class AsyncTimerTesting
    {
        public static void Main(string[] args)
        {
            AsyncTimer Alarm1 = new AsyncTimer(AlarmMsg1, 200, 10);
            AsyncTimer at2 = new AsyncTimer(AlarmMsg2, 250, 30);

            for (int i = 0; i < 100; i++)
            {
                Console.WriteLine("Main program running.");
                Thread.Sleep(400);
            }
        }

        public static void AlarmMsg1()
        {
            Console.WriteLine("Time to wake up!");
        }

        public static void AlarmMsg2()
        {
            Console.WriteLine("It's a beautiful day. You just have to open your eyes.");
        }
    }
}
