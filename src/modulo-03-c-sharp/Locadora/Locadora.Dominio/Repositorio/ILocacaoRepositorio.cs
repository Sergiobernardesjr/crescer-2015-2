using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Repositorio
{
    public interface ILocacaoRepositorio
    {
        int Locar(Locacao locacao);
        Locacao BuscarPorId(int id);
        Locacao BuscarIdPorJogo(int id);
        IList<Locacao> BuscarTodos();
    }
}
