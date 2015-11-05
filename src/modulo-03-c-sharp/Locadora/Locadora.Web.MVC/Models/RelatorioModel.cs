using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class RelatorioModel
    {
        public List<JogoModel> listaJogos = new List<JogoModel>();
        public int qtdDeJogos { get; set; }
        public string nomeJogoMaiorPreco { get; set; }
        public string nomeJogoMenorPreco { get; set; }
        public decimal mediaValorDosJogos { get; set; }

        public RelatorioModel()
        {
            listaJogos = new List<JogoModel>();
        }
    }
}