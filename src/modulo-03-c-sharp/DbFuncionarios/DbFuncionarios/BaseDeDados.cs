using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DbFuncionarios
{
    public class BaseDeDados
    {
        public List<Funcionario> Funcionarios
        {
            get; private set;
        }

        public BaseDeDados()
        {
            CriarBase();
        }

        private void CriarBase()
        {
            Funcionarios = new List<Funcionario>();

            Cargo desenvolvedor = new Cargo("Desenvolvedor", 190);
            Cargo analista = new Cargo("Analista", 250);
            Cargo gerente = new Cargo("Gerente", 550.5);

            Funcionario lucasLeal = new Funcionario(1, "Lucas Leal", new DateTime(1995, 01, 24));
            lucasLeal.Cargo = desenvolvedor;
            lucasLeal.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(lucasLeal);

            Funcionario jeanPinzon = new Funcionario(2, "Jean Pinzon", new DateTime(1991, 04, 25));
            jeanPinzon.Cargo = desenvolvedor;
            jeanPinzon.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(jeanPinzon);

            Funcionario rafaelBenetti = new Funcionario(3, "Rafael Benetti", new DateTime(1991, 08, 15));
            rafaelBenetti.Cargo = desenvolvedor;
            rafaelBenetti.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(rafaelBenetti);

            Funcionario mauricioBorges = new Funcionario(4, "Maurício Borges", new DateTime(1996, 11, 30));
            mauricioBorges.Cargo = desenvolvedor;
            mauricioBorges.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(mauricioBorges);

            Funcionario leandroAndreolli = new Funcionario(5, "Leandro Andreolli", new DateTime(1990, 03, 07));
            leandroAndreolli.Cargo = desenvolvedor;
            leandroAndreolli.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(leandroAndreolli);

            Funcionario felipeNervo = new Funcionario(6, "Felipe Nervo", new DateTime(1994, 01, 12));
            felipeNervo.Cargo = desenvolvedor;
            felipeNervo.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(felipeNervo);

            Funcionario lucasKauer = new Funcionario(7, "Lucas Kauer", new DateTime(1997, 05, 10));
            lucasKauer.Cargo = desenvolvedor;
            lucasKauer.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(lucasKauer);

            Funcionario eduardoArnold = new Funcionario(8, "Eduardo Arnold", new DateTime(1989, 09, 16));
            eduardoArnold.Cargo = desenvolvedor;
            eduardoArnold.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(eduardoArnold);

            Funcionario gabrielAlboy = new Funcionario(9, "Gabriel Alboy", new DateTime(1990, 02, 25));
            gabrielAlboy.Cargo = analista;
            gabrielAlboy.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(gabrielAlboy);

            Funcionario carlosHenrique = new Funcionario(10, "Carlos Henrique", new DateTime(1965, 12, 02));
            carlosHenrique.Cargo = analista;
            carlosHenrique.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(carlosHenrique);

            Funcionario margareteRicardo = new Funcionario(11, "Margarete Ricardo", new DateTime(1980, 10, 10));
            margareteRicardo.Cargo = gerente;
            margareteRicardo.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(margareteRicardo);
        }

        public IList<Funcionario> OrdenadosPorCargo()
        {
            return Funcionarios.OrderBy(f => f.Cargo.Titulo).ToList();
        }

        public IList<Funcionario> BuscarPorNome(string nome)
        {
            return Funcionarios.Where(f => f.Nome.Contains(nome)).OrderBy(f => f.Nome).ToList();
        }

        public IList<dynamic> BuscaRapida()
        {
            var query = from f in Funcionarios
                        select new
                        {
                            f.Nome,
                            f.Cargo
                        };

            return query.ToList<dynamic>();
        }

        public IList<Funcionario> BuscarPorTurno(params TurnoTrabalho[] turno)
        {
            if (turno.Count() > 0)
            {
                var query = from f in Funcionarios
                            where turno.Contains(f.TurnoTrabalho)
                            select f;


                return query.ToList();
            }

            return new List<Funcionario>();
        }

        public IList<dynamic> QtdFuncionariosPorTurno()
        {
            var query = from f in Funcionarios
                        group f by f.TurnoTrabalho into f
                        select new
                        {
                            Turno = f.Key,
                            QtdFuncionarios = f.Count()
                        };

            return query.ToList<dynamic>();
        }

        public IList<Funcionario> BuscarPorCargo(Cargo cargo)
        {
            return Funcionarios.Where(f => f.Cargo.Titulo == cargo.Titulo).ToList();
        }

        public IList<Funcionario> FiltrarPorIdadeAproximada(int idade)
        {
            var DataNascimentoFuncionario = DateTime.Now.AddYears(-idade);
            var DataMenos5Anos = DataNascimentoFuncionario.AddYears(-5);
            var DataMais5Anos = DataNascimentoFuncionario.AddYears(5);

            return Funcionarios.
                                Where(f => f.DataNascimento < DataMenos5Anos &&
                                           f.DataNascimento > DataMais5Anos).ToList();
        }

        public double SalarioMedio(TurnoTrabalho? turno)
        {
            TurnoTrabalho[] Turnos = { TurnoTrabalho.Manha, TurnoTrabalho.Tarde, TurnoTrabalho.Noite };

            IList<Funcionario> FuncionariosPorTurno;

            if (turno.HasValue)
            {
                FuncionariosPorTurno = BuscarPorTurno(turno.Value);
            }
            else
            {
                FuncionariosPorTurno = BuscarPorTurno(Turnos);
            }

            return FuncionariosPorTurno.Average(funcionario => funcionario.Cargo.Salario);
        }

        public IList<Funcionario> AniversariantesDoMes()
        {
            return Funcionarios.Where(f => f.DataNascimento.Month == DateTime.Now.Month).ToList();
        }
    }
}