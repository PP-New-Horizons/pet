INSERT INTO gender (name) VALUES ('Мужской') ON CONFLICT (name) DO NOTHING;
INSERT INTO gender (name) VALUES ('Женский') ON CONFLICT (name) DO NOTHING;


INSERT INTO colour (name) VALUES ('Блондин') ON CONFLICT (name) DO NOTHING;
INSERT INTO colour (name) VALUES ('Брюнет') ON CONFLICT (name) DO NOTHING;
INSERT INTO colour (name) VALUES ('Рыжий') ON CONFLICT (name) DO NOTHING;
INSERT INTO colour (name) VALUES ('Шатен') ON CONFLICT (name) DO NOTHING;
INSERT INTO colour (name) VALUES ('Пёстрый') ON CONFLICT (name) DO NOTHING;


INSERT INTO health_type (name) VALUES ('С ограниченными возможностями') ON CONFLICT (name) DO NOTHING;
INSERT INTO health_type (name) VALUES ('Требуется лечение') ON CONFLICT (name) DO NOTHING;
INSERT INTO health_type (name) VALUES ('Хорошее') ON CONFLICT (name) DO NOTHING;

INSERT INTO health_type (name) VALUES ('Гладкошерстные') ON CONFLICT (name) DO NOTHING;
INSERT INTO health_type (name) VALUES ('Длинношерстные') ON CONFLICT (name) DO NOTHING;
INSERT INTO health_type (name) VALUES ('Лысые') ON CONFLICT (name) DO NOTHING;

INSERT INTO size (name) VALUES ('Большие') ON CONFLICT (name) DO NOTHING;
INSERT INTO size (name) VALUES ('Средние') ON CONFLICT (name) DO NOTHING;
INSERT INTO size (name) VALUES ('Маленькие') ON CONFLICT (name) DO NOTHING;
