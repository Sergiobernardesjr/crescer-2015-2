using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class LocacaoModel
    {
        [DisplayName("Nome cliente")]
        public string NomeCliente { get; set; }

        public int IdJogo { get; set; }

        public string NomeJogo { get; set; }
    }
}