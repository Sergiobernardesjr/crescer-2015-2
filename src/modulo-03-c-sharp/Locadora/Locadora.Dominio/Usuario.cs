using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Usuario
    {
        public int Id { get; private set; }
        public string NomeCompleto { get; set; }
        public string Email { get; private set; }
        public string Senha { get; private set; }
        public ICollection<Permissao> Permissao { get; set; }

        public Usuario()
        {
        }

        public Usuario(string nome, string email, string senha)
        {
            this.NomeCompleto = nome;
            this.Email = email;
            this.Senha = senha;
        }
    }
}
