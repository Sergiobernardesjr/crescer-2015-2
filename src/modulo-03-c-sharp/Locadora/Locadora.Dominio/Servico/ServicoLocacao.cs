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
        ILocacaoRepositorio locacaoRepositorio;
        Locacao locacao;

        public bool LocarJogo(int idCliente, int idJogo)
        {
            var jogoPesquisado = jogoRepositorio.BuscarPorId(idJogo);
            var clientePesquisado = clienteRepositorio.BuscarPorId(idCliente);

            this.locacao = new Locacao(jogoPesquisado, clientePesquisado);

            var qtdDeClienteComJogos = locacaoRepositorio.BuscarTodos().Count(c => c.IdCliente == clientePesquisado.Id);

            if (qtdDeClienteComJogos < 3)
            {
                locacaoRepositorio.Locar(locacao);

                return true;
            }

            return false;
        }

        public void DevolverJogo(int idJogo)
        {
            locacao = locacaoRepositorio.BuscarIdPorJogo(idJogo);
            var jogoEncontrado = jogoRepositorio.BuscarPorId(idJogo);
            var dataEntregue = DateTime.Now - locacao.DataEntregaLocacao;

            if (dataEntregue.Days > 0)
            {
                for (int i = 0, diaDataEntregue = dataEntregue.Days; i < diaDataEntregue; i++)
                    locacao.PrecoLocacao += 5.00m;
            }

        }
    }
}
