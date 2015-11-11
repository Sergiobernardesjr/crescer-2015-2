using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class LoginModel
    {
        public string Usuario { get; private set; }

        public string[] Permissoes { get; private set; }

        public LoginModel(string usuario, string[] permissoes)
        {
            this.Usuario = usuario;
            this.Permissoes = permissoes;
        }
    }
}