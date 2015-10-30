using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using DbFuncionarios;
using System.Collections.Generic;

namespace UnitTestProject1
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void OrdenacaoPorCargo()
        {
            BaseDeDados BaseDeDados = new BaseDeDados();

            IList<Funcionario> funcionariosPorCategoria = BaseDeDados.OrdenadosPorCargo();

            Assert.AreEqual("Analista", funcionariosPorCategoria[0].Cargo.Titulo);
            Assert.AreEqual("Gerente", funcionariosPorCategoria[BaseDeDados.Funcionarios.Count - 1].Cargo.Titulo);
        }

        [TestMethod]
        public void BuscarPorParteDoNomeEOrdenadoPeloNome()
        {
            BaseDeDados BaseDeDados = new BaseDeDados();

            IList<string> ListaEsperado = new List<string>();
            IList<string> ListaAtual = new List<string>();

            ListaEsperado.Add("Jean Pinzon");
            ListaEsperado.Add("Leandro Andreolli");
            ListaEsperado.Add("Lucas Leal");

            foreach (var item in BaseDeDados.BuscarPorNome("ea"))
            {
                ListaAtual.Add(item.Nome.ToString());
            }

            Assert.AreEqual(ListaEsperado[0], ListaAtual[0]);
            Assert.AreEqual(ListaEsperado[1], ListaAtual[1]);
            Assert.AreEqual(ListaEsperado[2], ListaAtual[2]);
        }
    }
}
