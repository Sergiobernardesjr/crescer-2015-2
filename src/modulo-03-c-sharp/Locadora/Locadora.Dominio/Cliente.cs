using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Cliente : EntidadeBase
    {
        public string Nome { get; set; }
        public IList<Jogo> JogosLocados { get; set; }

        public Cliente()
        {

        }

        public Cliente(int id)
        {
            this.Id = id;
        }

        public bool PodeLocar()
        {
            return JogosLocados.Count < 3;
        }
    }
}
