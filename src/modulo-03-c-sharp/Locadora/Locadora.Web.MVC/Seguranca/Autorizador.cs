using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Principal;
using System.Threading;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;
using System.Web.Security;

namespace Locadora.Web.MVC.Seguranca
{
    public class Autorizador : AuthorizeAttribute
    {
        protected override bool AuthorizeCore(HttpContextBase httpContext)
        {
            UsuarioLogado usuario = ControleDeSessao.UsuarioLogado;
            return usuario != null
                    && TemOCookieDeAutenticacao(httpContext)
                    && TemAsPermissoesRequeridas(usuario);
        }
        protected override void HandleUnauthorizedRequest(AuthorizationContext filterContext)
        {
            filterContext.Result = new RedirectToRouteResult(
                                                new RouteValueDictionary
                                                {
                                                    { "action", "Index" },
                                                    { "controller", "Home" }
                                                });
        }

        private bool TemAsPermissoesRequeridas(UsuarioLogado usuarioLogado)
        {
            string[] permissoesRequeridas = String.IsNullOrWhiteSpace(this.Roles) ?
                                                new string[0] : this.Roles.Split(';');

            foreach (string permissao in permissoesRequeridas)
            {
                if (!usuarioLogado.Permissoes.Contains(permissao))
                {
                    return false;
                }
            }

            return true;
        }

        private bool TemOCookieDeAutenticacao(HttpContextBase httpContext)
        {
            return FormsAuthentication.CookiesSupported
                && httpContext.Request.Cookies != null
                && httpContext.Request.Cookies[FormsAuthentication.FormsCookieName] != null;
        }
    }
}