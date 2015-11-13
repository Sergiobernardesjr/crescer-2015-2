using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Dominio.Servico;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class LocacaoController : Controller
    {
        private ILocacaoRepositorio repositorioLocacao = new Locadora.Repositorio.EF.LocacaoRepositorio();
        private IClienteRepositorio repositorioCliente = new Locadora.Repositorio.EF.ClienteRepositorio();
        private IJogoRepositorio repositorioJogo = new Locadora.Repositorio.EF.JogoRepositorio();

        public ActionResult Index(int id)
        {
            var model = new LocacaoModel() { IdJogo = id };

            var jogo = repositorioJogo.BuscarPorId(id);

            model.NomeJogo = jogo.Nome;
            
            return View(model);
        }

        public ActionResult Locar(LocacaoModel locacaoModel)
        {
            var servicoLocacao = new ServicoLocacao();
            var clientePesquisado = repositorioCliente.BuscarPorNome(locacaoModel.NomeCliente);

            servicoLocacao.LocarJogo(clientePesquisado.Id, locacaoModel.IdJogo);

            return RedirectToAction("JogosDisponiveis", "Relatorio");
        }
    }
}