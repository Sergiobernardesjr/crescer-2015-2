﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class DetalheJogoModel
    {
        public string Nome { get; set; }
        public string Descricao { get; set; }
        public string Selo { get; set; }
        public string Imagem { get; set; }
        public string Video { get; set; }
        public int Id { get; set; }
    }
}