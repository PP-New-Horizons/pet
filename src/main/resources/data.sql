INSERT INTO gender (name) VALUES ('Мальчик') ON CONFLICT (name) DO NOTHING;
INSERT INTO gender (name) VALUES ('Девочка') ON CONFLICT (name) DO NOTHING;


INSERT INTO color (name) VALUES ('Блондин') ON CONFLICT (name) DO NOTHING;
INSERT INTO color (name) VALUES ('Брюнет') ON CONFLICT (name) DO NOTHING;
INSERT INTO color (name) VALUES ('Рыжий') ON CONFLICT (name) DO NOTHING;
INSERT INTO color (name) VALUES ('Шатен') ON CONFLICT (name) DO NOTHING;
INSERT INTO color (name) VALUES ('Пёстрый') ON CONFLICT (name) DO NOTHING;


INSERT INTO health_type (name) VALUES ('С особенностями') ON CONFLICT (name) DO NOTHING;
INSERT INTO health_type (name) VALUES ('Требуется лечение') ON CONFLICT (name) DO NOTHING;
INSERT INTO health_type (name) VALUES ('Здоровые') ON CONFLICT (name) DO NOTHING;

INSERT INTO hair (name) VALUES ('Гладкошерстный') ON CONFLICT (name) DO NOTHING;
INSERT INTO hair (name) VALUES ('Длинношерстный') ON CONFLICT (name) DO NOTHING;
INSERT INTO hair (name) VALUES ('Лысый') ON CONFLICT (name) DO NOTHING;

INSERT INTO size (name) VALUES ('Большой') ON CONFLICT (name) DO NOTHING;
INSERT INTO size (name) VALUES ('Средний') ON CONFLICT (name) DO NOTHING;
INSERT INTO size (name) VALUES ('Маленький') ON CONFLICT (name) DO NOTHING;

INSERT INTO pet_type (name) VALUES ('Кошка') ON CONFLICT (name) DO NOTHING;
INSERT INTO pet_type (name) VALUES ('Собака') ON CONFLICT (name) DO NOTHING;



-- Test data
-- Плюшик
INSERT INTO pet (breed, created_at, date_of_birth, description, history, is_adopted, is_booked, name, color_id, gender_id, hair_id, health_type, pet_type_id)
SELECT true, '2016-06-25 19:10:25', '2024-06-25', 'Любитель поспать в любое время суток', 'Это история', false, false, 'Сплюшик', 5, 1, 2, 3, 1
WHERE NOT EXISTS (SELECT 1 FROM pet WHERE name = 'Сплюшик');


INSERT INTO image (is_avatar, name, path, pet_id)
SELECT TRUE, 'cat1.jpg', '/images/cat1.jpg', pet.id
FROM pet
WHERE pet.name = 'Сплюшик' AND NOT EXISTS (
    SELECT 1 FROM image WHERE name = 'cat1.jpg' AND pet_id = pet.id
);

-- Изумруд
INSERT INTO pet (breed, created_at, date_of_birth, description, history, is_adopted, is_booked, name, color_id, gender_id, hair_id, health_type, pet_type_id)
SELECT true, '2016-06-25 19:10:25', '2023-06-25', 'Пронзительный взгляд, покоряющий сердца', 'Это история', false, false, 'Изумруд', 2, 1, 2, 2, 1
WHERE NOT EXISTS (SELECT 1 FROM pet WHERE name = 'Изумруд');

INSERT INTO image (is_avatar, name, path, pet_id)
SELECT TRUE, 'cat2.jpg', '/images/cat2.jpg', pet.id
FROM pet
WHERE pet.name = 'Изумруд' AND NOT EXISTS (
    SELECT 1 FROM image WHERE name = 'cat2.jpg' AND pet_id = pet.id
);

-- Бука
INSERT INTO pet (breed, created_at, date_of_birth, description, history, is_adopted, is_booked, name, color_id, gender_id, hair_id, health_type, pet_type_id)
SELECT true, '2016-06-25 19:10:25', '2021-06-25', 'Строгая мордочка, но ласковая душа', 'Это история', false, false, 'Бука', 3, 2, 1, 1, 1
WHERE NOT EXISTS (SELECT 1 FROM pet WHERE name = 'Бука');

INSERT INTO image (is_avatar, name, path, pet_id)
SELECT TRUE, 'cat3.jpg', '/images/cat3.jpg', pet.id
FROM pet
WHERE pet.name = 'Бука' AND NOT EXISTS (
    SELECT 1 FROM image WHERE name = 'cat3.jpg' AND pet_id = pet.id
);

-- Фотон
INSERT INTO pet (breed, created_at, date_of_birth, description, history, is_adopted, is_booked, name, color_id, gender_id, hair_id, health_type,  pet_type_id)
SELECT true, '2016-06-25 19:10:25', '2024-03-25', 'Самый быстрый кот, которого Вы только видели', 'Это история', false, false, 'Фотон', 4, 2, 2, 2, 1
WHERE NOT EXISTS (SELECT 1 FROM pet WHERE name = 'Фотон');

INSERT INTO image (is_avatar, name, path, pet_id)
SELECT TRUE, 'cat4.jpg', '/images/cat4.jpg', pet.id
FROM pet
WHERE pet.name = 'Фотон' AND NOT EXISTS (
    SELECT 1 FROM image WHERE name = 'cat4.jpg' AND pet_id = pet.id
);

-- Хлоя
INSERT INTO pet (breed, created_at, date_of_birth, description, history, is_adopted, is_booked, name, color_id, gender_id, hair_id, health_type,  pet_type_id)
SELECT false, '2016-06-25 19:10:25', '2013-06-25', 'Нежная и спокойная кошечка', 'Это история', false, false, 'Хлоя', 3, 2, 1, 3, 1
WHERE NOT EXISTS (SELECT 1 FROM pet WHERE name = 'Хлоя');

INSERT INTO image (is_avatar, name, path, pet_id)
SELECT TRUE, 'cat5.jpg', '/images/cat5.jpg', pet.id
FROM pet
WHERE pet.name = 'Хлоя' AND NOT EXISTS (
    SELECT 1 FROM image WHERE name = 'cat5.jpg' AND pet_id = pet.id
);

-- Баки
INSERT INTO pet (breed, created_at, date_of_birth, description, history, is_adopted, is_booked, name, color_id, gender_id, hair_id, health_type, size_id, pet_type_id)
SELECT false, '2016-06-25 19:10:25', '2014-10-25', 'С ним точно скучать не придётся', 'Это история', false, false, 'Баки', 1, 1, 2, 3, 2, 2
WHERE NOT EXISTS (SELECT 1 FROM pet WHERE name = 'Баки');

INSERT INTO image (is_avatar, name, path, pet_id)
SELECT TRUE, 'dog1.jpg', '/images/dog1.jpg', pet.id
FROM pet
WHERE pet.name = 'Баки' AND NOT EXISTS (
    SELECT 1 FROM image WHERE name = 'dog1.jpg' AND pet_id = pet.id
);

-- Лола
INSERT INTO pet (breed, created_at, date_of_birth, description, history, is_adopted, is_booked, name, color_id, gender_id, hair_id, health_type, size_id, pet_type_id)
SELECT true, '2016-06-25 19:10:25', '2021-01-25', 'Самые маленькие лапки в нашем приюте', 'Это история', false, false, 'Лола', 2, 2, 3, 3, 1, 2
WHERE NOT EXISTS (SELECT 1 FROM pet WHERE name = 'Лола');

INSERT INTO image (is_avatar, name, path, pet_id)
SELECT TRUE, 'dog2.jpg', '/images/dog2.jpg', pet.id
FROM pet
WHERE pet.name = 'Лола' AND NOT EXISTS (
    SELECT 1 FROM image WHERE name = 'dog2.jpg' AND pet_id = pet.id
);

-- Майк
INSERT INTO pet (breed, created_at, date_of_birth, description, history, is_adopted, is_booked, name, color_id, gender_id, hair_id, health_type, size_id, pet_type_id)
SELECT false, '2016-06-25 19:10:25', '2015-01-25', 'Озорной пёс, который не знает устали', 'Это история', false, false, 'Майк', 4, 1, 3, 2, 1, 2
WHERE NOT EXISTS (SELECT 1 FROM pet WHERE name = 'Майк');

INSERT INTO image (is_avatar, name, path, pet_id)
SELECT TRUE, 'dog3.jpg', '/images/dog3.jpg', pet.id
FROM pet
WHERE pet.name = 'Майк' AND NOT EXISTS (
    SELECT 1 FROM image WHERE name = 'dog3.jpg' AND pet_id = pet.id
);

-- Лика
INSERT INTO pet (breed, created_at, date_of_birth, description, history, is_adopted, is_booked, name, color_id, gender_id, hair_id, health_type, size_id, pet_type_id)
SELECT false, '2016-06-25 19:10:25', '2018-06-25', 'Самая добрая собака на целой планете', 'Это история', false, false, 'Лика', 1, 2, 2, 3, 1, 2
WHERE NOT EXISTS (SELECT 1 FROM pet WHERE name = 'Лика');

INSERT INTO image (is_avatar, name, path, pet_id)
SELECT TRUE, 'dog4.jpg', '/images/dog4.jpg', pet.id
FROM pet
WHERE pet.name = 'Лика' AND NOT EXISTS (
    SELECT 1 FROM image WHERE name = 'dog4.jpg' AND pet_id = pet.id
);

-- Брауни
INSERT INTO pet (breed, created_at, date_of_birth, description, history, is_adopted, is_booked, name, color_id, gender_id, hair_id, health_type, size_id, pet_type_id)
SELECT true, '2016-06-25 19:10:25', '2023-06-25', 'Ваш преданный друг и товарищ', 'Это история', false, false, 'Брауни', 4, 1, 2, 2, 3, 2
WHERE NOT EXISTS (SELECT 1 FROM pet WHERE name = 'Брауни');

INSERT INTO image (is_avatar, name, path, pet_id)
SELECT TRUE, 'dog5.jpg', '/images/dog5.jpg', pet.id
FROM pet
WHERE pet.name = 'Брауни' AND NOT EXISTS (
    SELECT 1 FROM image WHERE name = 'dog5.jpg' AND pet_id = pet.id
);
