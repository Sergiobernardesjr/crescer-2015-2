using Locadora.Dominio;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Extensions
{
    public static class ExtensionsController
    {
        public static Jogo ConverterManterJogoModelEmJogo(this Controller controller, ManterJogoModel manterJogo)
        {
            var jogo = new Jogo((int)manterJogo.Id);

            jogo.Nome = manterJogo.Nome;
            jogo.Descricao = manterJogo.Descricao;
            jogo.Video = manterJogo.Video;
            jogo.Imagem = manterJogo.Imagem;
            jogo.Selo = manterJogo.Selo;
            jogo.Categoria = manterJogo.Categoria;

            return jogo;
        }
    }
}