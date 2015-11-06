using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class RelatorioModel
    {
        public List<JogoModel> ListaJogos = new List<JogoModel>();
        public int QtdDeJogos { get; set; }
        public string NomeJogoMaiorPreco { get; set; }
        public string NomeJogoMenorPreco { get; set; }
        public decimal MediaValorDosJogos { get; set; }
        public string EncontrouJogo { get; set; }

        public RelatorioModel()
        {
            ListaJogos = new List<JogoModel>();
        }

        public void CalcularRelatorio()
        {
            var jogoMaisCaro = ListaJogos.Max(jogo => jogo.Preco);
            var jogoMaisBarato = ListaJogos.Min(jogo => jogo.Preco);

            NomeJogoMaiorPreco = ListaJogos.First(jogo => jogo.Preco == jogoMaisCaro).Nome;

            NomeJogoMenorPreco = ListaJogos.First(jogo => jogo.Preco == jogoMaisBarato).Nome;

            QtdDeJogos = ListaJogos.Count();

            MediaValorDosJogos = ListaJogos.Average(jogo => jogo.Preco);
        }
    }
}