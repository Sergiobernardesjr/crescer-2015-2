using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class LoginModel
    {
        [Required(ErrorMessage = "Email possui preenchimento obrigatório.")]
        [EmailAddress(ErrorMessage ="Email inválido.")]
        public string Email { get; set; }

        [Required(ErrorMessage = "Senha possui preenchimento obrigatório.")]
        public string Senha { get; set; }
    }
}