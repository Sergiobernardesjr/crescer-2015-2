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
            XDocument xmlJogos = XDocument.Load(XML);

            var query = from jogo in xmlJogos.Element("jogos").Elements("jogo")
                        where jogo.Element("nome").Value.Contains(nome)
                        select new Jogo(
                            jogo.Element("nome").Value,                            
                            Convert.ToDouble(jogo.Element("preco").Value),
                            (Categoria)Enum.Parse(typeof(Categoria), jogo.Element("categoria").Value),
                            Convert.ToInt32(jogo.Element("id").Value)                                                        
                        );

            var a = query.ToList();

            return a;
        }
    }
}