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
        private IJogoRepositorio repositorio = new Locadora.Repositorio.XML.JogoRepositorio();

        public ActionResult DetalheJogo(int id)
        {
            var detalheJogoModel = new DetalheJogoModel();

            var jogoBuscado = repositorio.BuscarPorId(id);

            detalheJogoModel.Id = jogoBuscado.Id;
            detalheJogoModel.Nome = jogoBuscado.Nome;
            detalheJogoModel.Descricao = jogoBuscado.Descricao;
            detalheJogoModel.Image = jogoBuscado.Imagem;
            
            return View(detalheJogoModel);
        }
    }
}