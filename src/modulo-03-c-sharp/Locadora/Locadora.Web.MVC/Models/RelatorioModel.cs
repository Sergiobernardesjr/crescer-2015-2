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
            QtdDeJogos = ListaJogos.Count();
        }
    }
}