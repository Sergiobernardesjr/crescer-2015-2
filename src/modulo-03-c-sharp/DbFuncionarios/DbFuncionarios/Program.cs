using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DbFuncionarios
{
    class Program
    {
        static void Main(string[] args)
        {
            var BaseDeDados = new BaseDeDados();

            var gerente = new Cargo("Gerente", 550.5);

            BaseDeDados.OrdenadosPorCargo();

            foreach (var item in BaseDeDados.BuscarPorCargo(gerente))
            {
                Console.WriteLine(item.Nome);
            }

            Console.WriteLine();
            
            Console.Read();
        }
    }
}
