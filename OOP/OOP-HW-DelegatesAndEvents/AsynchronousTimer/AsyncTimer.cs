﻿using System;
using System.Threading;

namespace AsynchronousTimer
{
    public class AsyncTimer
    {
        private Action tick;
        private int interval;
        private int ticks;

        public AsyncTimer(Action method, int interval, int ticks)
        {
            this.Interval = interval;
            this.Ticks = ticks;
            this.tick = method;
            this.OnTick(EventArgs.Empty);
        }

        public int Interval
        {
            get
            {
                return this.interval;
            }

            set
            {
                if (value < 0)
                {
                    throw new ArgumentOutOfRangeException("Interval", "Timer interval can not be negative!");
                }

                this.interval = value;
            }
        }

        public int Ticks
        {
            get
            {
                return this.ticks;
            }

            set
            {
                if (value < 0)
                {
                    throw new ArgumentOutOfRangeException("Interval", "Ticks can not be negative number!");
                }

                this.ticks = value;
            }
        }

        public virtual void OnTick(EventArgs e)
        {
            if (this.tick != null)
            {
                Thread newThread = new Thread(() =>
                {                  
                    for (int i = 0; i < this.Ticks; i++)
                    {
                        this.tick();
                        Thread.Sleep(this.Interval);
                    }
                });
                newThread.Start();
            }
        }
    }
}
