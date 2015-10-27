using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace ConsoleApp.Testes
{
    [TestClass]
    public class AgendaTestes
    {
        [TestMethod]
        public void AgendaTemUmContato()
        {
            var agenda = new Agenda();

            var contato = new Contato("Sergio", 12345);


            agenda.AdicionarContato(contato);

            Assert.AreEqual(agenda.QuantidadeContatos, 1);
        }

        [TestMethod]
        public void AgendaTemDoisContatosEÉRemovidoUmContatoPorNome()
        {
            var agenda = new Agenda();

            var contato = new Contato("Sergio", 12345);
            var contato1 = new Contato("Test", 12345);


            agenda.AdicionarContato(contato);
            agenda.AdicionarContato(contato1);

            agenda.RemoverContatosPorNome("Test");


            Assert.AreEqual(agenda.QuantidadeContatos, 1);
        }

        [TestMethod]
        public void AgendaTemDoisContatosEÉRemovidoUmContatoPorNumero()
        {
            var agenda = new Agenda();

            var contato = new Contato("Sergio", 12345);
            var contato1 = new Contato("Test", 12345);


            agenda.AdicionarContato(contato);
            agenda.AdicionarContato(contato1);

            agenda.RemoverContatosPorNumero(12345);


            Assert.AreEqual(agenda.QuantidadeContatos, 1);
        }

        [TestMethod]
        public void AgendaTem3ContatoEDoisSaoRemovidosPorNomeIgual()
        {
            var agenda = new Agenda();

            agenda.AdicionarContato(new Contato("Sergio", 12345));
            agenda.AdicionarContato(new Contato("Joao", 98766));
            agenda.AdicionarContato(new Contato("Sergio", 123456));

            agenda.RemoverContatosPorNome("Sergio");

            Assert.AreEqual(agenda.QuantidadeContatos, 1);
        }

        [TestMethod]
        public void AgendaTem3ContatoEDoisSaoRemovidosPorNumeroIgual()
        {
            var agenda = new Agenda();

            agenda.AdicionarContato(new Contato("Sergio", 12345));
            agenda.AdicionarContato(new Contato("Joao", 98766));
            agenda.AdicionarContato(new Contato("Sergio", 12345));

            agenda.RemoverContatosPorNumero(12345);

            Assert.AreEqual(agenda.QuantidadeContatos, 1);
        }
    }
}
