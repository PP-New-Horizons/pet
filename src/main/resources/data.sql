INSERT INTO gender (name) VALUES ('Мужской') ON CONFLICT (name) DO NOTHING;
INSERT INTO gender (name) VALUES ('Женский') ON CONFLICT (name) DO NOTHING;


INSERT INTO color (name) VALUES ('Блондин') ON CONFLICT (name) DO NOTHING;
INSERT INTO color (name) VALUES ('Брюнет') ON CONFLICT (name) DO NOTHING;
INSERT INTO color (name) VALUES ('Рыжий') ON CONFLICT (name) DO NOTHING;
INSERT INTO color (name) VALUES ('Шатен') ON CONFLICT (name) DO NOTHING;
INSERT INTO color (name) VALUES ('Пёстрый') ON CONFLICT (name) DO NOTHING;


INSERT INTO health_type (name) VALUES ('С ограниченными возможностями') ON CONFLICT (name) DO NOTHING;
INSERT INTO health_type (name) VALUES ('Требуется лечение') ON CONFLICT (name) DO NOTHING;
INSERT INTO health_type (name) VALUES ('Хорошее') ON CONFLICT (name) DO NOTHING;

INSERT INTO hair (name) VALUES ('Гладкошерстный') ON CONFLICT (name) DO NOTHING;
INSERT INTO hair (name) VALUES ('Длинношерстный') ON CONFLICT (name) DO NOTHING;
INSERT INTO hair (name) VALUES ('Лысый') ON CONFLICT (name) DO NOTHING;

INSERT INTO size (name) VALUES ('Большой') ON CONFLICT (name) DO NOTHING;
INSERT INTO size (name) VALUES ('Средний') ON CONFLICT (name) DO NOTHING;
INSERT INTO size (name) VALUES ('Маленький') ON CONFLICT (name) DO NOTHING;

INSERT INTO pet_type (name) VALUES ('Кошка') ON CONFLICT (name) DO NOTHING;
INSERT INTO pet_type (name) VALUES ('Собака') ON CONFLICT (name) DO NOTHING;
