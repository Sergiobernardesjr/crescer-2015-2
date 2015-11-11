using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;

namespace Locadora.Web.MVC.Controllers
{
    public class LoginController : Controller
    {
        private IJogoRepositorio repositorio = new Repositorio.EF.JogoRepositorio();


        public ActionResult Login(string login, string senha)
        {
            return View();
        }
    }
}