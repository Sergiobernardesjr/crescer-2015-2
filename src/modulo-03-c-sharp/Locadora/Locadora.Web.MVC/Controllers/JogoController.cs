using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Extensions;
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
    public class JogoController : Controller
    {
        private IJogoRepositorio repositorio = new Locadora.Repositorio.EF.JogoRepositorio();

        public ActionResult DetalheJogo(int id)
        {
            var detalheJogoModel = new DetalheJogoModel();

            var jogoBuscado = repositorio.BuscarPorId(id);

            detalheJogoModel.Id = jogoBuscado.Id;
            detalheJogoModel.Nome = jogoBuscado.Nome;
            detalheJogoModel.Descricao = jogoBuscado.Descricao;
            detalheJogoModel.Selo = jogoBuscado.Selo.ToString();
            detalheJogoModel.Imagem = jogoBuscado.Imagem;

            return View(detalheJogoModel);
        }

        [HttpGet]
        public ActionResult Manter(int id = 0)
        {
            var manterJogoModel = new ManterJogoModel();

            if (id > 0)
            {
                var manterJogoModelPesquisado = repositorio.BuscarPorId(id);

                manterJogoModel.Id = manterJogoModelPesquisado.Id;
                manterJogoModel.Nome = manterJogoModelPesquisado.Nome;
                manterJogoModel.Descricao = manterJogoModelPesquisado.Descricao;
                manterJogoModel.Video = manterJogoModelPesquisado.Video;
                manterJogoModel.Imagem = manterJogoModelPesquisado.Imagem;
                manterJogoModel.Selo = manterJogoModelPesquisado.Selo;
                manterJogoModel.Categoria = manterJogoModelPesquisado.Categoria;

                return View(manterJogoModel);
            }
            return View(manterJogoModel);
        }

        [HttpPost]
        public ActionResult Salvar(ManterJogoModel manterJogo)
        {
            if (ModelState.IsValid)
            {
                //if (manterJogo == null)
                //{
                //    var jogo = this.ConverterManterJogoModelEmJogo(manterJogo);

                //    repositorio.Criar(jogo);

                //    return View("Manter", manterJogo);


                //}
                //else
                //{
                var jogo = this.ConverterManterJogoModelEmJogo(manterJogo);

                repositorio.Atualizar(jogo);

                return RedirectToAction("JogosDisponiveis", "Relatorio");
                //}

            }
            else
            {
                return View("Manter", manterJogo);
            }
        }
    }
}