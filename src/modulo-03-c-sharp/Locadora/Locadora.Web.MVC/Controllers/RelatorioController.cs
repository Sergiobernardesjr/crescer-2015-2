using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using Locadora.Web.MVC.Seguranca;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    [Autorizador]
    public class RelatorioController : Controller
    {
        private IJogoRepositorio repositorio = new Locadora.Repositorio.EF.JogoRepositorio();

        public ActionResult JogosDisponiveis(string nome)
        {
            RelatorioModel relatorio = new RelatorioModel();

            IList<Dominio.Jogo> jogos = new List<Dominio.Jogo>();

            if (!String.IsNullOrWhiteSpace(nome))
            {
                jogos = repositorio.BuscarPorNome(nome);
            }

            else
            {
                jogos = repositorio.BuscarTodos();
            }

            if (jogos.Count > 0)
            {
                foreach (var jogo in jogos)
                {
                    JogoModel jogoModel = new JogoModel()
                    {
                        Id = jogo.Id,
                        Nome = jogo.Nome,
                        Categoria = jogo.Categoria.ToString(),
                    };

                    relatorio.ListaJogos.Add(jogoModel);
                    relatorio.CalcularRelatorio();
                }
            }
            return View(relatorio);
        }
    }
}
