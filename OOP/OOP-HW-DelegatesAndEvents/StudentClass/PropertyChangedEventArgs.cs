﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StudentClass
{
    public class PropertyChangedEventArgs<T> : EventArgs
    {
        public PropertyChangedEventArgs(string name, T oldValue, T newValue)
        {
            this.PropertyName = name;
            this.OldValue = oldValue;
            this.NewValue = newValue;
        }

        public string PropertyName { get; set; }

        public T OldValue { get; set; }

        public T NewValue { get; set; }
    }
}
