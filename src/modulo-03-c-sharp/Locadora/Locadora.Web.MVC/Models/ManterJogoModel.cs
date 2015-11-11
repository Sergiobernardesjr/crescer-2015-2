using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class ManterJogoModel
    {
        [Required(ErrorMessage ="Nome possui preenchimento obrigatório.")]
        [StringLength(250)]
        public string Nome { get; set; }
        
        [Required(ErrorMessage = "Categoria não pode ser vazia.")]
        public string Categoria { get; set; }

        [Required(ErrorMessage = "Selo não pode ser vazio.")]
        public string Selo { get; set; }

        [DisplayName("Descrição")]
        public string Descricao { get; set; }

        public string Imagem { get; set; }

        [DisplayName("Vídeo")]
        public string Video { get; set; }

        public int Id { get; set; }
    }
}