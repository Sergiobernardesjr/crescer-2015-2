using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
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

        public ActionResult Manter(int id=0)
        {
            if(id > 0)
            {
                var manterJogoModel = new ManterJogoModel();
                var manterJogoModelPesquisado = repositorio.BuscarPorId(id);

                manterJogoModel.Id = manterJogoModelPesquisado.Id;
                manterJogoModel.Nome = manterJogoModelPesquisado.Nome;
                manterJogoModel.Descricao = manterJogoModelPesquisado.Descricao;
                manterJogoModel.Video = manterJogoModelPesquisado.Descricao;
                manterJogoModel.Imagem = manterJogoModelPesquisado.Descricao;
                manterJogoModel.Selo = manterJogoModelPesquisado.Selo.ToString();
                manterJogoModel.Imagem = manterJogoModelPesquisado.Imagem;
            }
            return View();
        }
    }
}