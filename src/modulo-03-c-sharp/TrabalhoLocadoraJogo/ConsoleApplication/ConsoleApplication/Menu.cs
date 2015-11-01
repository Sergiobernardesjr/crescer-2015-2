using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.TEC
{
    class Menu
    {
        Database Database = new Database();

        public void SelecaoDoMenu(int opcao)
        {
            if (opcao == 1)
            {
                JogoParaSerCadastrado();
            }

            else if (opcao == 2)
            {
                var lista = PesquisaJogo();
                foreach (var item in lista)
                {
                    Console.WriteLine("Id: {0}",item.Id);
                    Console.WriteLine("Nome: {0}", item.Nome);
                    Console.WriteLine("Preco: {0:C}", item.Preco);
                    Console.WriteLine("Categoria: {0}", item.Categoria);
                }
            }

            else if (opcao == 3)
            {
                Console.WriteLine("Nome do jogo a ser alterado: ");
                string nomeJogo = Console.ReadLine();
                
                List<Jogo> listaJogo = Database.PesquisarJogosPorNome(nomeJogo);

                if(listaJogo.Count > 1)
                {
                    EditarListaDeJogo(listaJogo);
                }

                else
                {
                    EditarJogo(listaJogo, 1);
                }
            }
        }

        public void EditarJogo(List<Jogo> listaJogo, int id)
        {
            Console.WriteLine("Alterar 1 - Nome, 2 - Preço ou 3 - Categoria: ");
            int dado = Convert.ToInt32(Console.ReadLine());

            if (dado == 1)
            {
                Console.WriteLine("Nome: ");
                listaJogo[id - 1].Nome = Console.ReadLine();

                Database.EditarJogo(listaJogo[id-1]);
            }

            else if (dado == 2)
            {
                Console.WriteLine("Preco: ");
                listaJogo[id - 1].Preco = Convert.ToDouble(Console.ReadLine());

                Database.EditarJogo(listaJogo[id-1]);
            }

            else if (dado == 3)
            {
                Console.WriteLine("Categoria: ");
                listaJogo[id - 1].Categoria = (Categoria)Enum.Parse(typeof(Categoria), Console.ReadLine());

                Database.EditarJogo(listaJogo[id-1]);
            }
        }

        public void JogoParaSerCadastrado()
        {
            Console.WriteLine("Nome: ");
            string nome = Console.ReadLine();

            Console.WriteLine("Preco: ");
            double preco = Convert.ToDouble(Console.ReadLine());

            Console.WriteLine("Categoria: ");
            Categoria categoria = (Categoria)Enum.Parse(typeof(Categoria), Console.ReadLine());

            var jogo = new Jogo(nome, preco, categoria);

            Database.CadastrarJogo(jogo);
        }

        public List<Jogo> PesquisaJogo()
        {
            Console.WriteLine("Nome do jogo a ser pesquisado: ");
            string nomeJogo = Console.ReadLine();

            List<Jogo> lista = Database.PesquisarJogosPorNome(nomeJogo);

            return lista;
        }

        public void EditarListaDeJogo(List<Jogo> listaJogo)
        {
            int i = 0;
            foreach (var item in listaJogo)
            {
                i++;
                Console.WriteLine("Id: {0}\r\nNome: {1}\r\nPreco: {2:C}\r\nCategoria: {3}", i, item.Nome, item.Preco, item.Categoria);
            }

            Console.WriteLine("Escolha um jogo a editar(digite o id): ");
            int id = Convert.ToInt32(Console.ReadLine());

            EditarJogo(listaJogo, id);
        }
    }
}
