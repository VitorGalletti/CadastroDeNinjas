-- V2: Migration para adicionar coluna de rank na tabela de cadasto

ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR(255);