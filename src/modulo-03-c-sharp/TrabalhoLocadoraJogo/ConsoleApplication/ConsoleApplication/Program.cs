using Locadora.Dominio;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace Locadora.TEC
{
    class Program
    {
        static void Main(string[] args)
        {
            var data = new Database();

            Console.WriteLine(data.ProximoId());
            Console.Read();
        }
    }
}

