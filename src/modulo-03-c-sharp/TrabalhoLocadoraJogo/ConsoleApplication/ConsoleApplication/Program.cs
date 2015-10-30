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
            string nome;
            List<string> jogosBuscados = new List<string>();

            Console.WriteLine("Digite um nome a ser pesquisado: ");
            nome = Console.ReadLine();

            data.PesquisarJogosPorNome(nome);

            foreach (var item in jogosBuscados)
            {
                Console.WriteLine(item);
            }
            
            Console.WriteLine(data.ProximoId());
            Console.Read();
        }
    }
}

