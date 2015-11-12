namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Selo : DbMigration
    {
        public override void Up()
        {
            CreateTable(
            "dbo.Selo",
            c => new
            {
                IdSelo = c.Int(nullable: false, identity: true),
                Nome = c.String(nullable: false, maxLength: 200)
            })
            .PrimaryKey(t => t.IdSelo);

        }

        public override void Down()
        {
            DropTable("dbo.Selo");
        }
    }
}
