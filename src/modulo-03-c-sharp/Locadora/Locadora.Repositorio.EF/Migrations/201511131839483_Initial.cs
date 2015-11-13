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
   "dbo.Selo",
   c => new
   {
       IdSelo = c.Int(nullable: false, identity: true),
       Descricao = c.String(nullable: false, maxLength: 200),
   })
   .PrimaryKey(t => t.IdSelo);


            CreateTable(
                "dbo.Categoria",
                c => new
                {
                    IdCategoria = c.Int(nullable: false, identity: true),
                    Nome = c.String(nullable: false, maxLength: 200),
                })
                .PrimaryKey(t => t.IdCategoria);



            CreateTable(
                "dbo.jogo",
                c => new
                {
                    Id = c.Int(nullable: false, identity: true),
                    Nome = c.String(nullable: false, maxLength: 250),
                    IdCategoria = c.Int(nullable: false),
                    Descricao = c.String(nullable: false),
                    IdSelo = c.Int(nullable: false),
                    Imagem = c.String(),
                    Video = c.String(),
                    Cliente_Id = c.Int(),
                })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.cliente", t => t.Cliente_Id)
                .Index(t => t.Cliente_Id);

           
            CreateTable(
                "dbo.Locacao",
                c => new
                {
                    Id = c.Int(nullable: false, identity: true),
                    IdJogo = c.Int(nullable: false),
                    IdCliente = c.Int(nullable: false),
                    PrecoLocacao = c.Decimal(nullable: false, precision: 18, scale: 2),
                    DataEntregaLocacao = c.DateTime(nullable: false),
                    Cliente_Id = c.Int(),
                    Jogo_Id = c.Int(),
                })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.cliente", t => t.Cliente_Id)
                .ForeignKey("dbo.jogo", t => t.Jogo_Id)
                .Index(t => t.Cliente_Id)
                .Index(t => t.Jogo_Id);

            CreateTable(
                "dbo.Permissao",
                c => new
                {
                    Id = c.Int(nullable: false, identity: true),
                    Nome = c.String(nullable: false, maxLength: 200),
                })
                .PrimaryKey(t => t.Id);

            CreateTable(
                "dbo.Usuario",
                c => new
                {
                    Id = c.Int(nullable: false, identity: true),
                    NomeCompleto = c.String(nullable: false, maxLength: 200),
                    Email = c.String(nullable: false, maxLength: 200),
                    Senha = c.String(nullable: false, maxLength: 200),
                })
                .PrimaryKey(t => t.Id);

            CreateTable(
                "dbo.Usuario_Permissao",
                c => new
                {
                    IdUsuario = c.Int(nullable: false),
                    IdPermissao = c.Int(nullable: false),
                })
                .PrimaryKey(t => new { t.IdUsuario, t.IdPermissao })
                .ForeignKey("dbo.Usuario", t => t.IdUsuario, cascadeDelete: true)
                .ForeignKey("dbo.Permissao", t => t.IdPermissao, cascadeDelete: true)
                .Index(t => t.IdUsuario)
                .Index(t => t.IdPermissao);

        }

        public override void Down()
        {
            DropForeignKey("dbo.Usuario_Permissao", "IdPermissao", "dbo.Permissao");
            DropForeignKey("dbo.Usuario_Permissao", "IdUsuario", "dbo.Usuario");
            DropForeignKey("dbo.Locacaos", "Jogo_Id", "dbo.jogo");
            DropForeignKey("dbo.Locacaos", "Cliente_Id", "dbo.cliente");
            DropForeignKey("dbo.jogo", "Cliente_Id", "dbo.cliente");
            DropIndex("dbo.Usuario_Permissao", new[] { "IdPermissao" });
            DropIndex("dbo.Usuario_Permissao", new[] { "IdUsuario" });
            DropIndex("dbo.Locacaos", new[] { "Jogo_Id" });
            DropIndex("dbo.Locacaos", new[] { "Cliente_Id" });
            DropIndex("dbo.jogo", new[] { "Cliente_Id" });
            DropTable("dbo.Usuario_Permissao");
            DropTable("dbo.Usuario");
            DropTable("dbo.Permissao");
            DropTable("dbo.Locacaos");
            DropTable("dbo.jogo");
            DropTable("dbo.cliente");
        }
    }
}
