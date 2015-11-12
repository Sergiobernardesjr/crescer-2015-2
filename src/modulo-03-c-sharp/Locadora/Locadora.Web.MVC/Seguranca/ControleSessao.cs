using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Security;

namespace Locadora.Web.MVC.Seguranca
{
    public class ControleDeSessao
    {
        private const string USUARIO_LOGADO = "USUARIO_LOGADO";

        public static UsuarioLogado UsuarioLogado
        {
            get
            {
                UsuarioLogado usuarioLogado = null;

                if (HttpContext.Current.Session != null)
                {
                    usuarioLogado = HttpContext.Current.Session[USUARIO_LOGADO] as UsuarioLogado;
                }

                return usuarioLogado;
            }
        }

        public static void CriarSessaoDeUsuario(Usuario usuarioAutenticado)
        {
            var usuarioLogado = new UsuarioLogado(usuarioAutenticado);
            FormsAuthentication.SetAuthCookie(usuarioLogado.Email, true);
            HttpContext.Current.Session[USUARIO_LOGADO] = usuarioLogado;
        }

        public static void Encerrar()
        {
            FormsAuthentication.SignOut();
            HttpContext.Current.Session.Abandon();
        }
    }
}