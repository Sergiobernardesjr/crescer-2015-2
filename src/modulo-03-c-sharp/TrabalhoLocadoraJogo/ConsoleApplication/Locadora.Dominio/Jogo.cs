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
        public string Nome { get; set; }
        public Categoria Categoria { get; set; }
        public double Preco { get; set; }
        public int Id { get; private set; }

        public Jogo(string nome, double preco, Categoria categoria, int? id)
        {
            this.Nome = nome;
            this.Preco = preco;
            this.Categoria = categoria;
        }
    }
}
