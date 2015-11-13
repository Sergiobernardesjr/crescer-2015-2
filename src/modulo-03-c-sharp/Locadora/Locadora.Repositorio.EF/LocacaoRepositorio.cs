using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;

namespace Locadora.Repositorio.EF
{
    public class LocacaoRepositorio : ILocacaoRepositorio
    {
        public Locacao BuscarIdPorJogo(int id)
        {
            throw new NotImplementedException();
        }

        public Locacao BuscarPorId(int id)
        {
            throw new NotImplementedException();
        }

        public IList<Locacao> BuscarTodos()
        {
            throw new NotImplementedException();
        }

        public int Locar(Locacao locacao)
        {
            using (var db = new BancoDeDados())
            {
                db.Entry(locacao).State = System.Data.Entity.EntityState.Added;

                return db.SaveChanges();
            }
        }
    }
}
