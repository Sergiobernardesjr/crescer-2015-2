using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Locadora.Dominio;

namespace TestDominio
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void CadastraDoisJogosEOIdIncrementa()
        {
            var data = new Database();
            var jg1 = new Jogo("Rally", 10, Categoria.CORRIDA);
            var jg2 = new Jogo("Guittar", 20, Categoria.ESPORTE);

            data.CadastrarJogo(jg1);
            data.CadastrarJogo(jg2);

            int IdEsperado = data.ProximoId() + 2;
            int IdAtual = data.ProximoId();

            Assert.AreEqual(IdEsperado, IdEsperado);
        }
    }
}
