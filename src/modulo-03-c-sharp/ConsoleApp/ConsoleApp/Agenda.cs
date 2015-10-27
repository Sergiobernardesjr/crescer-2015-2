using System;
using System.Collections.Generic;
using System.Linq;

namespace ConsoleApp
{
    public class Agenda
    {
        private List<Contato> contatos = new List<Contato>();

        public int QuantidadeContatos { get { return contatos.Count; } }

        public void AdicionarContato(Contato contato)
        {
            contatos.Add(contato);
        }

        public void RemoverContatosPorNome(string nomeContato)
        {
            var contatosASeremRemovios = new List<Contato>();

            for (int i = 0; i < contatos.Count; i++)
            {
                if (contatos[i].Nome == nomeContato)
                {
                    contatosASeremRemovios.Add(contatos[i]);
                }

                foreach (var contato in contatosASeremRemovios)
                {
                    contatos.Remove(contato);
                }
            }
        }

        public void RemoverContatosPorNumero(int Numero)
        {
            var contatosASeremRemovios = new List<Contato>();

            for (int i = 0; i < contatos.Count; i++)
            {
                if (contatos[i].Numero == Numero)
                {
                    contatosASeremRemovios.Add(contatos[i]);
                }

                foreach (var contato in contatosASeremRemovios)
                {
                    contatos.Remove(contato);
                }
            }
        }

        public void OrdenarContatosPorNome()
        {
            contatos = contatos.OrderBy(c => c.Nome).ToList();
        }

        public List<Contato> ListarContatos()
        {
            return contatos;
        }
    }
}
