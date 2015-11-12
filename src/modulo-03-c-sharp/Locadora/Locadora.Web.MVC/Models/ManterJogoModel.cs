using Locadora.Dominio;
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
        
        [Required]
        [EnumDataType(typeof(Categoria), ErrorMessage ="Selecione uma categoria")]
        public Categoria Categoria { get; set; }

        [Required]
        [EnumDataType(typeof(Selo), ErrorMessage = "Selecione uma selo")]
        public Selo Selo { get; set; }

        [DisplayName("Descrição")]
        public string Descricao { get; set; }

        public string Imagem { get; set; }

        [DisplayName("Vídeo")]
        public string Video { get; set; }

        public int Id { get; set; }
    }
}