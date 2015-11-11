namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Permissoes_Usuario : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Permissaos",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Usuarios",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        NomeCompleto = c.String(),
                        Email = c.String(),
                        Senha = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.UsuarioPermissaos",
                c => new
                    {
                        Usuario_Id = c.Int(nullable: false),
                        Permissao_Id = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.Usuario_Id, t.Permissao_Id })
                .ForeignKey("dbo.Usuarios", t => t.Usuario_Id, cascadeDelete: true)
                .ForeignKey("dbo.Permissaos", t => t.Permissao_Id, cascadeDelete: true)
                .Index(t => t.Usuario_Id)
                .Index(t => t.Permissao_Id);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.UsuarioPermissaos", "Permissao_Id", "dbo.Permissaos");
            DropForeignKey("dbo.UsuarioPermissaos", "Usuario_Id", "dbo.Usuarios");
            DropIndex("dbo.UsuarioPermissaos", new[] { "Permissao_Id" });
            DropIndex("dbo.UsuarioPermissaos", new[] { "Usuario_Id" });
            DropTable("dbo.UsuarioPermissaos");
            DropTable("dbo.Usuarios");
            DropTable("dbo.Permissaos");
        }
    }
}
