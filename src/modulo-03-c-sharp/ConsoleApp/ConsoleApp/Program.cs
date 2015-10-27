using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    class Program
    {
        static void Main(string[] args)
        {
            var listaContatos = new List<Contato>();
            var agenda = new Agenda();
            var Nome = "";
            var Numero = 0;
            var opcao = 0;

            while (opcao != 4)
            {
                Console.WriteLine("Agenda: Cadastrar contato - 1 | Remover contato - 2 | Listar contatos - 3 | Sair - 4: ");
                opcao = Convert.ToInt32(Console.ReadLine());

                if (opcao == 1)
                {
                    Console.WriteLine("Nome: ");
                    Nome = Convert.ToString(Console.ReadLine());
                    Console.WriteLine("Numero: ");
                    Numero = Convert.ToInt32(Console.ReadLine());

                    agenda.AdicionarContato(new Contato(Nome, Numero));
                }

                else if (opcao == 2)
                {
                    Console.WriteLine("Remover usuário por Nome - 1 ou Numero - 2: ");
                    if (Convert.ToInt32(Console.ReadLine()) == 1)
                    { 
                        Console.WriteLine("Nome: ");
                        agenda.RemoverContatosPorNome(Convert.ToString(Console.ReadLine()));
                    }
                    else if (Convert.ToInt32(Console.ReadLine())== 2)
                    {
                        Console.WriteLine("Numero: ");
                        agenda.RemoverContatosPorNumero(Convert.ToInt32(Console.ReadLine()));
                    }

                }

                else if (opcao == 3){
                    foreach (var contato in agenda.ListarContatos())
                    {
                        Console.WriteLine(contato.Nome + "-" + contato.Numero);
                    }
                }

                Console.WriteLine("Aperte qualquer tecla para continuar...");
                Console.ReadKey();
                Console.Clear();
            }
        }
    }
}