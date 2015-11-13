using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Locacao : EntidadeBase
    {
        public int IdJogo { get; set; }
        public int IdCliente { get; set; }
        public decimal PrecoLocacao { get; set; }
        public DateTime DataEntregaLocacao { get; set; }
        public Cliente Cliente { get; set; }
        public Jogo Jogo { get; set; }

        public Locacao(Jogo jogo, Cliente cliente)
        {
            IdJogo = jogo.Id;
            IdCliente = cliente.Id;
            CalcularValorSelo();
        }

        public void CalcularValorSelo()
        {
            DataEntregaLocacao = DateTime.Now;
            if (Selo.OURO == Jogo.Selo) {
                PrecoLocacao = 15.00m;
                DataEntregaLocacao.AddDays(1);
            }
            else if(Selo.PRATA == Jogo.Selo)
            {
                PrecoLocacao = 10.00m;
                DataEntregaLocacao.AddDays(2);
            }
            else if(Selo.BRONZE == Jogo.Selo)
            {
                PrecoLocacao = 5.00m;
                DataEntregaLocacao.AddDays(3);
            }
        }
    }
}
