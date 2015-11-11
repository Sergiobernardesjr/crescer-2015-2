ALTER TABLE dbo.Jogo
	ADD Descricao VARCHAR(MAX)

UPDATE Jogo SET Descricao = 'Sem descrição'

ALTER TABLE dbo.Jogo
	ALTER COLUMN IdSelo INT NOT NULL