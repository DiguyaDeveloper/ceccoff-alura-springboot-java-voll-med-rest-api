ALTER TABLE doctor ADD active BOOLEAN;

UPDATE doctor SET active = true WHERE active IS NULL;