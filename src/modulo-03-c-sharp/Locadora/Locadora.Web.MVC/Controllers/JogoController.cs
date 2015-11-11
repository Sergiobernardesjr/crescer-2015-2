using Locadora.Dominio;
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
                manterJogoModel.Video = manterJogoModelPesquisado.Descricao;
                manterJogoModel.Imagem = manterJogoModelPesquisado.Descricao;
                manterJogoModel.Selo = manterJogoModelPesquisado.Selo.ToString();
                manterJogoModel.Imagem = manterJogoModelPesquisado.Imagem;

                return View(manterJogoModel);
            }
            return View(manterJogoModel);
        }

        [HttpPost]
        public ActionResult Salvar(ManterJogoModel manterJogo)
        {
            if (ModelState.IsValid)
            {
                if (manterJogo != null)
                {
                    var jogo = new Jogo((int)manterJogo.Id);
                    var manterJogoPesquisado = repositorio.BuscarPorId((int)manterJogo.Id);

                    jogo.Nome = manterJogoPesquisado.Nome;
                    jogo.Descricao = manterJogoPesquisado.Descricao;
                    jogo.Video = manterJogoPesquisado.Video;
                    jogo.Imagem = manterJogoPesquisado.Imagem;
                    jogo.Selo = manterJogoPesquisado.Selo;
                    jogo.Categoria = manterJogoPesquisado.Categoria;
                    
                    repositorio.Atualizar(jogo);
                    
                }
                return View();
            }
            else
            {
                var jogo = new Jogo((int)manterJogo.Id);
                
                jogo.Nome = manterJogo.Nome;
                jogo.Descricao = manterJogo.Descricao;
                jogo.Video = manterJogo.Descricao;
                jogo.Imagem = manterJogo.Imagem;
                jogo.Selo = manterJogo.Selo;
                jogo.Categoria = manterJogo.Categoria;
                
                repositorio.Criar(jogo);
            }

            return View();
        }
    }
}