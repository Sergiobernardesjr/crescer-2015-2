using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class RelatorioController : Controller
    {
        private IJogoRepositorio repositorio = new Locadora.Repositorio.ADO.JogoRepositorio();

        public ActionResult JogosDisponiveis()
        {
            RelatorioModel relatorio = new RelatorioModel();

            var jogos = repositorio.BuscarTodos();

            foreach (var jogo in jogos)
            {
                JogoModel jogoModel = new JogoModel()
                {
                    Id = jogo.Id,
                    Nome = jogo.Nome,
                    Categoria = jogo.Categoria.ToString(),
                    Preco = jogo.Preco
                };

                relatorio.listaJogos.Add(jogoModel);
            }

            var jogoMaisCaro = relatorio.listaJogos.Max(jogo => jogo.Preco);
            var jogoMaisBarato = relatorio.listaJogos.Min(jogo => jogo.Preco);

            relatorio.nomeJogoMaiorPreco = relatorio.listaJogos.First(jogo => jogo.Preco == jogoMaisCaro).Nome;

            relatorio.nomeJogoMenorPreco = relatorio.listaJogos.First(jogo => jogo.Preco == jogoMaisBarato).Nome;

            relatorio.qtdDeJogos = relatorio.listaJogos.Count();

            relatorio.mediaValorDosJogos = relatorio.listaJogos.Average(jogo => jogo.Preco);

            return View(relatorio);
        }
    }
}
