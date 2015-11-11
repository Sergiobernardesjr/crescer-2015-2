using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Repositorio
{
    public interface IUsuarioRepositorio
    {
        Usuario BuscarPorEmailESenha(string email, string senha);
        int Criar(Usuario usuario);
        int Atualizar(Usuario usuario);
        int Excluir(int id);
    }
}
