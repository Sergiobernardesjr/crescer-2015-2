using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Transactions;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["URNA"].ConnectionString;

            using (TransactionScope transacao = new TransactionScope())
                using (IDbConnection connection = new SqlConnection(connectionString))
                {
                    IDbCommand comando = connection.CreateCommand();
                    comando.CommandText =
                        "UPDATE Cargo SET Nome = @paramNome WHERE IDCargo = @paramIdCargo";

                    comando.AddParameter("paramNome", "Prefeito");
                    comando.AddParameter("paramIdCargo", "0 OR 1=1 --");

                    connection.Open();

                    int linhasAfetadas = comando.ExecuteNonQuery();

                    transacao.Complete();

                    connection.Close();
                }



                Console.Read();
            }
        }
    }

