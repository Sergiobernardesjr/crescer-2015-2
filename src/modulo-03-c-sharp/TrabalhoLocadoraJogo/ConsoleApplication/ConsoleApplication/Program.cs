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
            var menu = new Menu();
            string nome;
            List<string> jogosBuscados = new List<string>();

            //Console.WriteLine("1 - Cadastrar, 2 - Pesquisar ou 3 - Editar: ");
            //menu.SelecaoDoMenu(Convert.ToInt32(Console.ReadLine()));

            data.RelatorioJogos();
            
            Console.Read();
        }
    }
}

