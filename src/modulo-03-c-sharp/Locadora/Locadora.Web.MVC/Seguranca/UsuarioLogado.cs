using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Seguranca
{
    public class UsuarioLogado
    {
        public bool ContemPermissao(string permissao)
        {
            return true;
        }
    }
}