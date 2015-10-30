using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace Locadora.Dominio
{
     public class Jogo
    {
        public string Nome { get; private set; }
        public Categoria Categoria { get; set; }
        public double Preco { get; private set; }
        public int Id { get; private set; }

        public Jogo(string nome, double preco, Categoria categoria)
        {
            this.Nome = nome;
            this.Preco = preco;
            this.Categoria = categoria;
        }

        public Jogo(XElement jogo, string XML)
        {
            //XDocument xmlJogos = XDocument.Load(XML);

            //jogo = xmlJogos.Element("jogo");

            //this.Nome = jogo.Element("nome").Value;
            //this.Preco = jogo.XElement("preco").Value;
            //this.Categoria = jogo.XElement("categoria").Value;

        }

    }
}
