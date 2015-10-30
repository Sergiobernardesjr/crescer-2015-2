﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;
using System.Xml.Linq;

namespace Locadora.Dominio
{
    public class Database
    {

        public const string XML = @"C:\Users\Sergio\Documents\CWI\Crescer\Modulo_01\src\modulo-03-c-sharp\TrabalhoLocadoraJogo\ConsoleApplication\Database\Jogos.xml";

        public void CadastrarJogo(Jogo jogo)
        {
            XDocument xmlJogos = XDocument.Load(XML);


            XElement jogos = new XElement("jogo");
            jogos.Add(new XAttribute("id", ProximoId()));
            jogos.Add(new XElement("nome", jogo.Nome));
            jogos.Add(new XElement("preco", jogo.Preco));
            jogos.Add(new XElement("categoria", jogo.Categoria));

            xmlJogos.Element("jogos").Add(jogos);
            xmlJogos.Save(XML);

        }

        public int ProximoId()
        {
            XElement xmlJogos = XElement.Load(XML);

            int Id = Convert.ToInt32(xmlJogos.Elements("jogo").Last().Attribute("id").Value);

            return Id + 1;
        }

        public List<Jogo> PesquisarJogosPorNome(string nome)
        {
            string nomeJogo;
            Categoria categoria;
            double preco;
            List<Jogo> jogosPesquisados = new List<Jogo>();

            XDocument xmlJogos = XDocument.Load(XML);

            var query = from jogo in xmlJogos.Element("jogos").Elements("jogo")
                        where jogo.Element("nome").Value.Contains(nome)
                        select new
                        {
                            Nome = jogo.Element("nome").Value,
                            categoria = (Categoria)Enum.Parse(typeof(Categoria), jogo.Element("categoria").Value),
                            Preco = Convert.ToDouble(jogo.Element("preco").Value)
                        };

           var a = query.ToList();

            foreach (var item in a)
            {
                var categoriaItem = item.categoria.ToString();
                var jogo = new Jogo(
                        nomeJogo = item.Nome,
                        preco = item.Preco,
                        categoria = (Categoria)Enum.Parse(typeof(Categoria), categoriaItem)
                        );
                jogosPesquisados.Add(jogo);                 
            }

            return jogosPesquisados;
        }
    }
}