using Locadora.Dominio.Repositorio;
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
        private IJogoRepositorio repositorio = new Locadora.Repositorio.EF.JogoRepositorio();

        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Locar(int id)
        {
            var jogo = repositorio.BuscarPorId(id);


            return View();
        }
    }
}