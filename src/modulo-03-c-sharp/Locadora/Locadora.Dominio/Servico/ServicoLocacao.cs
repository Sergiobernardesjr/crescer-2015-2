using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Servico
{
    public class ServicoLocacao
    {
        IJogoRepositorio jogoRepositorio;
        IClienteRepositorio clienteRepositorio;

        public bool LocarJogo(int idCliente, Jogo jogo)
        {
            var jogoPesquisado = jogoRepositorio.BuscarPorId(jogo.Id);
            var clientePesquisado = clienteRepositorio.BuscarPorId(idCliente);

            if (clientePesquisado.PodeLocar() && jogoPesquisado.ClienteLocacao == null)
            {
                jogoPesquisado.LocarPara(clientePesquisado);

                return true;
            }
            return false;
        }
    }
}
