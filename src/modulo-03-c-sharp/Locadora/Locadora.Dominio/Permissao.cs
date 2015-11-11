using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Permissao
    {
        public int Id { get; private set; }
        public string Nome { get; set; }
        public ICollection<Usuario> Usuario { get; set; }
    }
}
