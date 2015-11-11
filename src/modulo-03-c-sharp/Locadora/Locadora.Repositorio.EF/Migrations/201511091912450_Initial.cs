namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;

    public partial class Initial : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.cliente",
                c => new
                {
                    Id = c.Int(nullable: false, identity: true),
                    Nome = c.String(nullable: false, maxLength: 250),
                })
                .PrimaryKey(t => t.Id);

            CreateTable(
                "dbo.jogo",
                c => new
                {
                    Id = c.Int(nullable: false, identity: true),
                    Nome = c.String(nullable: false, maxLength: 250),
                    Preco = c.Decimal(nullable: false, precision: 18, scale: 2),
                    IdCategoria = c.Int(nullable: false),
                    Descricao = c.String(nullable: false),
                    IdSelo = c.Int(nullable: false),
                    Imagem = c.String(),
                    Video = c.String(),
                    IdClienteLocacao = c.Int(),
                })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.cliente", t => t.IdClienteLocacao)
                .ForeignKey("dbo.Selo", t => t.IdSelo)
                .Index(t => t.IdClienteLocacao)
                .Index(t => t.IdSelo)
                .Index(t => t.IdCategoria);

            CreateTable(
                  "dbo.Selo",
                  c => new
                  {
                      IdSelo = c.Int(nullable: false, identity: true),
                      Nome = c.String(nullable: false, maxLength: 250)
                  })
                  .PrimaryKey(t => t.IdSelo);

           CreateTable(
                "dbo.Categoria",
                c => new
                {
                    Id = c.Int(nullable: false, identity: true),
                    Descricao = c.String(nullable: false, maxLength: 250)
                })
                .PrimaryKey(t => t.Id);


        }

        public override void Down()
        {
            DropForeignKey("dbo.jogo", "ClienteLocacao_Id", "dbo.cliente");
            DropIndex("dbo.jogo", new[] { "ClienteLocacao_Id" });
            DropTable("dbo.jogo");
            DropTable("dbo.cliente");
            DropTable("dbo.Selo");
            DropTable("dbo.Categoria");
        }
    }
}
