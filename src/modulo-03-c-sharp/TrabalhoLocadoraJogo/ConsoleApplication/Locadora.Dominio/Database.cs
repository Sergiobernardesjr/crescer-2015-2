using System;
using System.Collections.Generic;
using System.IO;
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
                        where jogo.Element("nome").Value.ToUpper().ToString().Contains(nome.ToUpper())
                        select new Jogo(
                            jogo.Element("nome").Value,                            
                            Convert.ToDouble(jogo.Element("preco").Value),
                            (Categoria)Enum.Parse(typeof(Categoria), jogo.Element("categoria").Value),
                            Convert.ToInt32(jogo.Attribute("id").Value)                                                        
                        );

            var jogos = query.ToList();

            return jogos;
        }

        public void EditarJogo(Jogo jogoEditado) {
            XElement xmlJogos = XElement.Load(XML);

            string idJogoString = jogoEditado.Id.ToString();

            XElement jogos = xmlJogos.Elements().FirstOrDefault(j => idJogoString == j.Attribute("id").Value);

            if (jogos != null)
            {
                jogos.Element("nome").SetValue(jogoEditado.Nome);
                jogos.Element("categoria").SetValue(jogoEditado.Categoria);
                jogos.Element("preco").SetValue(jogoEditado.Preco);
            }

            xmlJogos.Save(XML);
        }

        public void RelatorioJogos()
        {
            string caminhoRel = @"C:\Users\Sergio\Documents\CWI\Crescer\Modulo_01\src\modulo-03-c-sharp\TrabalhoLocadoraJogo\ConsoleApplication\Database\RelatorioJogos.txt";
            XElement xmlJogos = XElement.Load(XML);

            DateTime dataAtual = DateTime.Now;
                                    
            string cabecalhoNomeLocadora = "                             LOCADORA GAMES TCHE                               " + Environment.NewLine;
            string dataEHoraRel = String.Format("{0:dd/MM/yyyy}                                                       {0:HH:mm:ss}", dataAtual);
            string cabecalhoData = dataEHoraRel + Environment.NewLine;
            string nomeRelatorio =         "                              Relatório de Jogos                                 " + Environment.NewLine;
            string separacao =             "===============================================================================" + Environment.NewLine;
            string itensDoCabecalho =      "ID\t       Categoria\t             Nome\t                     Preço              " + Environment.NewLine;
                                                
            File.AppendAllText(caminhoRel, cabecalhoNomeLocadora);
            File.AppendAllText(caminhoRel, cabecalhoData);
            File.AppendAllText(caminhoRel, nomeRelatorio);
            File.AppendAllText(caminhoRel, separacao);
            File.AppendAllText(caminhoRel, itensDoCabecalho);

            foreach (var item in xmlJogos.Elements())
            {
                string fraseJogos = String.Format("{0}\t      {1}\t                   {2}\t                       {3}                ", item.Attribute("id").Value.ToString(), item.Element("categoria").Value.ToString(), item.Element("nome").Value.ToString(), item.Element("preco").Value.ToString()) + Environment.NewLine ;
                File.AppendAllText(caminhoRel, fraseJogos);
            }
        }
    }
}