using System;
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

        public string PesquisarJogosPorNome(string nome)
        {
            string nomeJogo;
            string categoria;
            double preco;

            XDocument xmlJogos = XDocument.Load(XML);

            var query = from jogo in xmlJogos.Elements("jogo")
                        where jogo.Element("nome").Value.ToString() == nome
                        select new
                        {
                            Nome = jogo.Element("nome").Value,
                            Categoria = jogo.Element("categoria").Value,
                            Preco = jogo.Element("preco").Value
                        };

            foreach (var jogo in query)
            {
                nomeJogo = jogo.Nome;
                categoria = jogo.Categoria;
                preco = Convert.ToDouble(jogo.Preco);

                var frase = String.Format("Nome:\r\n{0}\r\nCategoria:\r\n{1}\r\nPreco:\r\n{2:2C}", nomeJogo, categoria, preco);
                return frase;
            }
        }
    }
}