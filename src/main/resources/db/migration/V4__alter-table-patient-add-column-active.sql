ALTER TABLE patient ADD active BOOLEAN;

UPDATE patient SET active = true WHERE active IS NULL;