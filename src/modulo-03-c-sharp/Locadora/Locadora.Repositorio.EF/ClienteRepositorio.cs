using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;

namespace Locadora.Repositorio.EF
{
    class ClienteRepositorio : IClienteRepositorio
    {
        public Cliente BuscarPorId(int id)
        {
            using (var db = new BancoDeDados())
            {
                return db.Cliente.Find(id);
            }
        }

        public IList<Cliente> BuscarPorNome(string nome)
        {
            using (var db = new BancoDeDados())
            {
                return db.Cliente.Where(j => j.Nome.Contains(nome)).ToList();
            }
        }
    }
}
