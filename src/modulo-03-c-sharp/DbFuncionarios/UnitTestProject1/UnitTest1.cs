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
        public void BuscarPorParteDoNomeEOrdenadoPeloNomeEa()
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

        [TestMethod]
        public void BuscarPorParteDoNomeEOrdenadoPeloNomeEl()
        {
            BaseDeDados BaseDeDados = new BaseDeDados();

            IList<string> ListaEsperado = new List<string>();
            IList<string> ListaAtual = new List<string>();

            ListaEsperado.Add("Felipe Nervo");
            ListaEsperado.Add("Gabriel Alboy");
            ListaEsperado.Add("Rafael Benetti");

            foreach (var item in BaseDeDados.BuscarPorNome("el"))
            {
                ListaAtual.Add(item.Nome.ToString());
            }

            Assert.AreEqual(ListaEsperado[0], ListaAtual[0]);
            Assert.AreEqual(ListaEsperado[2], ListaAtual[2]);
        }

        [TestMethod]
        public void BuscaRapidaTrazendo11Funcionarios()
        {
            BaseDeDados BaseDeDados = new BaseDeDados();
            var ListaDeFuncionarios = BaseDeDados.BuscaRapida();
            var ListaDeFuncionariosEsperado = ListaDeFuncionarios.Count;
            Assert.AreEqual(11, ListaDeFuncionariosEsperado);
        }

        [TestMethod]
        public void BuscaPorTurnoSemPassarNenhumTurno()
        {
            BaseDeDados BaseDeDados = new BaseDeDados();

            IList<Funcionario> Funcionarios = BaseDeDados.BuscarPorTurno();

            Assert.AreEqual(0, Funcionarios.Count);
        }

        [TestMethod]
        public void BuscaPorTurnoPassandoTurnoManha()
        {
            BaseDeDados BaseDeDados = new BaseDeDados();

            IList<Funcionario> Funcionarios = BaseDeDados.BuscarPorTurno(TurnoTrabalho.Manha);

            Assert.AreEqual(5, Funcionarios.Count);
        }

        [TestMethod]
        public void BuscarFuncionarioPorCargo()
        {
            var gerente = new Cargo("Gerente", 550.5);
            BaseDeDados BaseDeDados = new BaseDeDados();

            IList<Funcionario> funcionarios = BaseDeDados.BuscarPorCargo(gerente);

            Assert.AreEqual("Margarete Ricardo", funcionarios[0].Nome);
            Assert.AreEqual(1, funcionarios.Count);
        }
    }
}
