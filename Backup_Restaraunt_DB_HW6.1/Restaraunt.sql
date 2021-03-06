toc.dat                                                                                             0000600 0004000 0002000 00000050205 12723265601 0014445 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        PGDMP           .                t        
   Restaraunt    9.5.3    9.5.3 Q    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false         �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false         �           1262    24603 
   Restaraunt    DATABASE     �   CREATE DATABASE "Restaraunt" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';
    DROP DATABASE "Restaraunt";
             user    false                     2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false         �           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    6         �           0    0    public    ACL     �   REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;
                  postgres    false    6                     3079    12355    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false         �           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1         �            1259    24654    booking    TABLE     �   CREATE TABLE booking (
    id integer NOT NULL,
    order_no integer NOT NULL,
    employee_id integer NOT NULL,
    table_no integer NOT NULL,
    date date NOT NULL
);
    DROP TABLE public.booking;
       public         user    false    6         �            1259    24739    booking_history    TABLE     �   CREATE TABLE booking_history (
    id integer NOT NULL,
    dish_id integer NOT NULL,
    employee_id integer NOT NULL,
    booking_id integer NOT NULL,
    date date NOT NULL
);
 #   DROP TABLE public.booking_history;
       public         user    false    6         �            1259    24737    booking_history_id_seq    SEQUENCE     x   CREATE SEQUENCE booking_history_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.booking_history_id_seq;
       public       user    false    6    198         �           0    0    booking_history_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE booking_history_id_seq OWNED BY booking_history.id;
            public       user    false    197         �            1259    24652    booking_id_seq    SEQUENCE     p   CREATE SEQUENCE booking_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.booking_id_seq;
       public       user    false    6    186         �           0    0    booking_id_seq    SEQUENCE OWNED BY     3   ALTER SEQUENCE booking_id_seq OWNED BY booking.id;
            public       user    false    185         �            1259    24698    category    TABLE     ]   CREATE TABLE category (
    id integer NOT NULL,
    name character varying(100) NOT NULL
);
    DROP TABLE public.category;
       public         user    false    6         �            1259    24696    category_id_seq    SEQUENCE     q   CREATE SEQUENCE category_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.category_id_seq;
       public       user    false    192    6         �           0    0    category_id_seq    SEQUENCE OWNED BY     5   ALTER SEQUENCE category_id_seq OWNED BY category.id;
            public       user    false    191         �            1259    24706    dish    TABLE     B  CREATE TABLE dish (
    id integer NOT NULL,
    name character varying(200) NOT NULL,
    category_id integer NOT NULL,
    price real NOT NULL,
    weight real NOT NULL,
    CONSTRAINT dish_price_check CHECK ((price > (0)::double precision)),
    CONSTRAINT dish_weight_check CHECK ((weight > (0)::double precision))
);
    DROP TABLE public.dish;
       public         user    false    6         �            1259    24704    dish_id_seq    SEQUENCE     m   CREATE SEQUENCE dish_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.dish_id_seq;
       public       user    false    6    194         �           0    0    dish_id_seq    SEQUENCE OWNED BY     -   ALTER SEQUENCE dish_id_seq OWNED BY dish.id;
            public       user    false    193         �            1259    24630    employee    TABLE     Y  CREATE TABLE employee (
    id integer NOT NULL,
    name character varying(50) NOT NULL,
    surname character varying(50) NOT NULL,
    birth_date date NOT NULL,
    phone_number character varying(20) NOT NULL,
    position_id integer NOT NULL,
    salary real,
    CONSTRAINT employee_salary_check CHECK ((salary > (0)::double precision))
);
    DROP TABLE public.employee;
       public         user    false    6         �            1259    24628    employee_id_seq    SEQUENCE     q   CREATE SEQUENCE employee_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.employee_id_seq;
       public       user    false    184    6         �           0    0    employee_id_seq    SEQUENCE OWNED BY     5   ALTER SEQUENCE employee_id_seq OWNED BY employee.id;
            public       user    false    183         �            1259    24669 
   ingridient    TABLE     _   CREATE TABLE ingridient (
    id integer NOT NULL,
    name character varying(100) NOT NULL
);
    DROP TABLE public.ingridient;
       public         user    false    6         �            1259    24667    ingridient_id_seq    SEQUENCE     s   CREATE SEQUENCE ingridient_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.ingridient_id_seq;
       public       user    false    188    6         �           0    0    ingridient_id_seq    SEQUENCE OWNED BY     9   ALTER SEQUENCE ingridient_id_seq OWNED BY ingridient.id;
            public       user    false    187         �            1259    24622    position    TABLE     ^   CREATE TABLE "position" (
    id integer NOT NULL,
    name character varying(50) NOT NULL
);
    DROP TABLE public."position";
       public         user    false    6         �            1259    24620    position_id_seq    SEQUENCE     q   CREATE SEQUENCE position_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.position_id_seq;
       public       user    false    182    6         �           0    0    position_id_seq    SEQUENCE OWNED BY     7   ALTER SEQUENCE position_id_seq OWNED BY "position".id;
            public       user    false    181         �            1259    24721    recepy    TABLE     s   CREATE TABLE recepy (
    id integer NOT NULL,
    dish_id integer NOT NULL,
    ingridient_id integer NOT NULL
);
    DROP TABLE public.recepy;
       public         user    false    6         �            1259    24719    recepy_id_seq    SEQUENCE     o   CREATE SEQUENCE recepy_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.recepy_id_seq;
       public       user    false    196    6         �           0    0    recepy_id_seq    SEQUENCE OWNED BY     1   ALTER SEQUENCE recepy_id_seq OWNED BY recepy.id;
            public       user    false    195         �            1259    24685 	   warehouse    TABLE     u   CREATE TABLE warehouse (
    id integer NOT NULL,
    ingridient_id integer NOT NULL,
    number integer NOT NULL
);
    DROP TABLE public.warehouse;
       public         user    false    6         �            1259    24683    warehouse_id_seq    SEQUENCE     r   CREATE SEQUENCE warehouse_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.warehouse_id_seq;
       public       user    false    6    190         �           0    0    warehouse_id_seq    SEQUENCE OWNED BY     7   ALTER SEQUENCE warehouse_id_seq OWNED BY warehouse.id;
            public       user    false    189         �           2604    24657    id    DEFAULT     Z   ALTER TABLE ONLY booking ALTER COLUMN id SET DEFAULT nextval('booking_id_seq'::regclass);
 9   ALTER TABLE public.booking ALTER COLUMN id DROP DEFAULT;
       public       user    false    185    186    186         �           2604    24742    id    DEFAULT     j   ALTER TABLE ONLY booking_history ALTER COLUMN id SET DEFAULT nextval('booking_history_id_seq'::regclass);
 A   ALTER TABLE public.booking_history ALTER COLUMN id DROP DEFAULT;
       public       user    false    198    197    198         �           2604    24701    id    DEFAULT     \   ALTER TABLE ONLY category ALTER COLUMN id SET DEFAULT nextval('category_id_seq'::regclass);
 :   ALTER TABLE public.category ALTER COLUMN id DROP DEFAULT;
       public       user    false    191    192    192         �           2604    24709    id    DEFAULT     T   ALTER TABLE ONLY dish ALTER COLUMN id SET DEFAULT nextval('dish_id_seq'::regclass);
 6   ALTER TABLE public.dish ALTER COLUMN id DROP DEFAULT;
       public       user    false    193    194    194         �           2604    24633    id    DEFAULT     \   ALTER TABLE ONLY employee ALTER COLUMN id SET DEFAULT nextval('employee_id_seq'::regclass);
 :   ALTER TABLE public.employee ALTER COLUMN id DROP DEFAULT;
       public       user    false    184    183    184         �           2604    24672    id    DEFAULT     `   ALTER TABLE ONLY ingridient ALTER COLUMN id SET DEFAULT nextval('ingridient_id_seq'::regclass);
 <   ALTER TABLE public.ingridient ALTER COLUMN id DROP DEFAULT;
       public       user    false    187    188    188         �           2604    24625    id    DEFAULT     ^   ALTER TABLE ONLY "position" ALTER COLUMN id SET DEFAULT nextval('position_id_seq'::regclass);
 <   ALTER TABLE public."position" ALTER COLUMN id DROP DEFAULT;
       public       user    false    182    181    182         �           2604    24724    id    DEFAULT     X   ALTER TABLE ONLY recepy ALTER COLUMN id SET DEFAULT nextval('recepy_id_seq'::regclass);
 8   ALTER TABLE public.recepy ALTER COLUMN id DROP DEFAULT;
       public       user    false    196    195    196         �           2604    24688    id    DEFAULT     ^   ALTER TABLE ONLY warehouse ALTER COLUMN id SET DEFAULT nextval('warehouse_id_seq'::regclass);
 ;   ALTER TABLE public.warehouse ALTER COLUMN id DROP DEFAULT;
       public       user    false    190    189    190         �          0    24654    booking 
   TABLE DATA                     public       user    false    186       2189.dat �          0    24739    booking_history 
   TABLE DATA                     public       user    false    198       2201.dat �           0    0    booking_history_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('booking_history_id_seq', 1, false);
            public       user    false    197         �           0    0    booking_id_seq    SEQUENCE SET     6   SELECT pg_catalog.setval('booking_id_seq', 1, false);
            public       user    false    185         �          0    24698    category 
   TABLE DATA                     public       user    false    192       2195.dat �           0    0    category_id_seq    SEQUENCE SET     7   SELECT pg_catalog.setval('category_id_seq', 11, true);
            public       user    false    191         �          0    24706    dish 
   TABLE DATA                     public       user    false    194       2197.dat �           0    0    dish_id_seq    SEQUENCE SET     3   SELECT pg_catalog.setval('dish_id_seq', 41, true);
            public       user    false    193         �          0    24630    employee 
   TABLE DATA                     public       user    false    184       2187.dat �           0    0    employee_id_seq    SEQUENCE SET     6   SELECT pg_catalog.setval('employee_id_seq', 5, true);
            public       user    false    183         �          0    24669 
   ingridient 
   TABLE DATA                     public       user    false    188       2191.dat �           0    0    ingridient_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('ingridient_id_seq', 33, true);
            public       user    false    187         �          0    24622    position 
   TABLE DATA                     public       user    false    182       2185.dat �           0    0    position_id_seq    SEQUENCE SET     6   SELECT pg_catalog.setval('position_id_seq', 2, true);
            public       user    false    181         �          0    24721    recepy 
   TABLE DATA                     public       user    false    196       2199.dat �           0    0    recepy_id_seq    SEQUENCE SET     5   SELECT pg_catalog.setval('recepy_id_seq', 52, true);
            public       user    false    195         �          0    24685 	   warehouse 
   TABLE DATA                     public       user    false    190       2193.dat �           0    0    warehouse_id_seq    SEQUENCE SET     8   SELECT pg_catalog.setval('warehouse_id_seq', 22, true);
            public       user    false    189                    2606    24744    booking_history_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY booking_history
    ADD CONSTRAINT booking_history_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.booking_history DROP CONSTRAINT booking_history_pkey;
       public         user    false    198    198         �           2606    24661    booking_order_no_key 
   CONSTRAINT     T   ALTER TABLE ONLY booking
    ADD CONSTRAINT booking_order_no_key UNIQUE (order_no);
 F   ALTER TABLE ONLY public.booking DROP CONSTRAINT booking_order_no_key;
       public         user    false    186    186                     2606    24659    booking_pkey 
   CONSTRAINT     K   ALTER TABLE ONLY booking
    ADD CONSTRAINT booking_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.booking DROP CONSTRAINT booking_pkey;
       public         user    false    186    186                    2606    24703    category_pkey 
   CONSTRAINT     M   ALTER TABLE ONLY category
    ADD CONSTRAINT category_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.category DROP CONSTRAINT category_pkey;
       public         user    false    192    192                    2606    24713 	   dish_pkey 
   CONSTRAINT     E   ALTER TABLE ONLY dish
    ADD CONSTRAINT dish_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.dish DROP CONSTRAINT dish_pkey;
       public         user    false    194    194         �           2606    24636    employee_pkey 
   CONSTRAINT     M   ALTER TABLE ONLY employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.employee DROP CONSTRAINT employee_pkey;
       public         user    false    184    184                    2606    24674    ingridient_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY ingridient
    ADD CONSTRAINT ingridient_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.ingridient DROP CONSTRAINT ingridient_pkey;
       public         user    false    188    188         �           2606    24627    position_pkey 
   CONSTRAINT     O   ALTER TABLE ONLY "position"
    ADD CONSTRAINT position_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public."position" DROP CONSTRAINT position_pkey;
       public         user    false    182    182         
           2606    24726    recepy_pkey 
   CONSTRAINT     I   ALTER TABLE ONLY recepy
    ADD CONSTRAINT recepy_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.recepy DROP CONSTRAINT recepy_pkey;
       public         user    false    196    196                    2606    24690    warehouse_pkey 
   CONSTRAINT     O   ALTER TABLE ONLY warehouse
    ADD CONSTRAINT warehouse_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.warehouse DROP CONSTRAINT warehouse_pkey;
       public         user    false    190    190                    2606    24662    booking_employee_id_fkey    FK CONSTRAINT     x   ALTER TABLE ONLY booking
    ADD CONSTRAINT booking_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES employee(id);
 J   ALTER TABLE ONLY public.booking DROP CONSTRAINT booking_employee_id_fkey;
       public       user    false    2044    184    186                    2606    24755    booking_history_booking_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY booking_history
    ADD CONSTRAINT booking_history_booking_id_fkey FOREIGN KEY (booking_id) REFERENCES booking(id);
 Y   ALTER TABLE ONLY public.booking_history DROP CONSTRAINT booking_history_booking_id_fkey;
       public       user    false    2048    198    186                    2606    24745    booking_history_dish_id_fkey    FK CONSTRAINT     |   ALTER TABLE ONLY booking_history
    ADD CONSTRAINT booking_history_dish_id_fkey FOREIGN KEY (dish_id) REFERENCES dish(id);
 V   ALTER TABLE ONLY public.booking_history DROP CONSTRAINT booking_history_dish_id_fkey;
       public       user    false    198    2056    194                    2606    24750     booking_history_employee_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY booking_history
    ADD CONSTRAINT booking_history_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES employee(id);
 Z   ALTER TABLE ONLY public.booking_history DROP CONSTRAINT booking_history_employee_id_fkey;
       public       user    false    198    2044    184                    2606    24714    dish_category_id_fkey    FK CONSTRAINT     r   ALTER TABLE ONLY dish
    ADD CONSTRAINT dish_category_id_fkey FOREIGN KEY (category_id) REFERENCES category(id);
 D   ALTER TABLE ONLY public.dish DROP CONSTRAINT dish_category_id_fkey;
       public       user    false    194    192    2054                    2606    24637    employee_position_id_fkey    FK CONSTRAINT     |   ALTER TABLE ONLY employee
    ADD CONSTRAINT employee_position_id_fkey FOREIGN KEY (position_id) REFERENCES "position"(id);
 L   ALTER TABLE ONLY public.employee DROP CONSTRAINT employee_position_id_fkey;
       public       user    false    184    182    2042                    2606    24727    recepy_dish_id_fkey    FK CONSTRAINT     j   ALTER TABLE ONLY recepy
    ADD CONSTRAINT recepy_dish_id_fkey FOREIGN KEY (dish_id) REFERENCES dish(id);
 D   ALTER TABLE ONLY public.recepy DROP CONSTRAINT recepy_dish_id_fkey;
       public       user    false    2056    194    196                    2606    24732    recepy_ingridient_id_fkey    FK CONSTRAINT     |   ALTER TABLE ONLY recepy
    ADD CONSTRAINT recepy_ingridient_id_fkey FOREIGN KEY (ingridient_id) REFERENCES ingridient(id);
 J   ALTER TABLE ONLY public.recepy DROP CONSTRAINT recepy_ingridient_id_fkey;
       public       user    false    2050    188    196                    2606    24691    warehouse_ingridient_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY warehouse
    ADD CONSTRAINT warehouse_ingridient_id_fkey FOREIGN KEY (ingridient_id) REFERENCES ingridient(id);
 P   ALTER TABLE ONLY public.warehouse DROP CONSTRAINT warehouse_ingridient_id_fkey;
       public       user    false    188    2050    190                                                                                                                                                                                                                                                                                                                                                                                                   2189.dat                                                                                            0000600 0004000 0002000 00000000002 12723265601 0014251 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              2201.dat                                                                                            0000600 0004000 0002000 00000000002 12723265601 0014232 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              2195.dat                                                                                            0000600 0004000 0002000 00000001156 12723265601 0014261 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        INSERT INTO category (id, name) VALUES (1, 'SALAD');
INSERT INTO category (id, name) VALUES (2, 'Bread_doughs');
INSERT INTO category (id, name) VALUES (5, 'Soup');
INSERT INTO category (id, name) VALUES (6, 'Antipasti');
INSERT INTO category (id, name) VALUES (9, 'Drinks');
INSERT INTO category (id, name) VALUES (10, 'Desserts');
INSERT INTO category (id, name) VALUES (11, 'Sauces');
INSERT INTO category (id, name) VALUES (8, 'Meat');
INSERT INTO category (id, name) VALUES (4, 'Garnish');
INSERT INTO category (id, name) VALUES (7, 'Fish');
INSERT INTO category (id, name) VALUES (3, 'Dishes from domestic eggs');


                                                                                                                                                                                                                                                                                                                                                                                                                  2197.dat                                                                                            0000600 0004000 0002000 00000006753 12723265601 0014273 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        INSERT INTO dish (id, name, category_id, price, weight) VALUES (1, 'SALMON', 1, 55, 250);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (2, 'GREECE SALAD', 1, 47, 230);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (3, 'SUMMER', 1, 40, 280);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (4, 'Coconut bread', 2, 35, 180);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (5, 'BATH BUNS', 2, 20, 150);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (6, 'ENGLISH MUFFINS', 2, 37, 150);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (7, 'Sourdough bread', 2, 15, 200);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (12, 'Cutlets ', 8, 93, 200);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (13, 'Meatballs', 8, 93, 235);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (14, 'Stew', 8, 117, 240);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (15, 'Borsch', 5, 67, 400);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (16, 'Chicken soup', 5, 65, 435);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (17, 'Pea soup', 5, 65, 420);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (18, 'Apple & pear strudel', 10, 59, 160);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (19, 'Napoleon cake', 10, 45, 160);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (20, 'Cherry strudel', 10, 62, 165);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (21, 'Cheesecake140', 10, 57, 140);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (22, 'Ice cream', 10, 42, 150);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (23, 'Milk shake', 9, 42, 300);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (24, 'Espresso', 9, 19, 40);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (25, 'Americano', 9, 19, 110);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (26, 'Cappuccino', 9, 27, 180);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (27, 'Latte', 9, 35, 300);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (28, 'Black tea', 9, 27, 400);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (29, 'Salsa', 11, 25, 50);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (30, 'Lemon pickle', 11, 27, 35);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (31, 'Classic guacamole', 11, 30, 70);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (32, 'Oysters rockefeller', 6, 79, 150);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (33, 'Involtini', 6, 56, 170);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (34, 'Clams casino', 6, 89, 200);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (35, 'Potatoes', 4, 25, 250);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (36, 'Boiled buckwheat with butter', 4, 25, 230);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (37, 'Fried gobies', 7, 98, 250);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (38, 'Pike and zander cutlets', 7, 135, 165);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (39, 'Omelette', 3, 88, 200);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (40, 'Fried egg', 3, 72, 130);
INSERT INTO dish (id, name, category_id, price, weight) VALUES (41, '3 egg omelet', 3, 72, 150);


                     2187.dat                                                                                            0000600 0004000 0002000 00000001452 12723265601 0014261 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        INSERT INTO employee (id, name, surname, birth_date, phone_number, position_id, salary) VALUES (1, 'John', 'Doe', '1980-01-01', '+38(063)123-45-67', 1, 2000);
INSERT INTO employee (id, name, surname, birth_date, phone_number, position_id, salary) VALUES (2, 'Kim', 'Vasovsky', '1978-06-07', '+38(093)453-45-77', 2, 7000);
INSERT INTO employee (id, name, surname, birth_date, phone_number, position_id, salary) VALUES (3, 'Simon', 'McCat', '1982-11-21', '+38(050)784-75-46', 2, 5000);
INSERT INTO employee (id, name, surname, birth_date, phone_number, position_id, salary) VALUES (4, 'Jake', 'Green', '1990-04-28', '+38(063)363-76-02', 1, 1800);
INSERT INTO employee (id, name, surname, birth_date, phone_number, position_id, salary) VALUES (5, 'Andrew', 'Smith', '1992-07-14', '+38(066)153-36-56', 1, 1650);


                                                                                                                                                                                                                      2191.dat                                                                                            0000600 0004000 0002000 00000003507 12723265601 0014257 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        INSERT INTO ingridient (id, name) VALUES (1, 'WATER');
INSERT INTO ingridient (id, name) VALUES (2, 'POTATO');
INSERT INTO ingridient (id, name) VALUES (3, 'SUGAR');
INSERT INTO ingridient (id, name) VALUES (4, 'SOLT');
INSERT INTO ingridient (id, name) VALUES (5, 'CARROT');
INSERT INTO ingridient (id, name) VALUES (6, 'RICE');
INSERT INTO ingridient (id, name) VALUES (7, 'TOMATO');
INSERT INTO ingridient (id, name) VALUES (8, 'PEPPER');
INSERT INTO ingridient (id, name) VALUES (9, 'ONION');
INSERT INTO ingridient (id, name) VALUES (10, 'CUCUMBER');
INSERT INTO ingridient (id, name) VALUES (11, 'FLOUR');
INSERT INTO ingridient (id, name) VALUES (12, 'COFFEE');
INSERT INTO ingridient (id, name) VALUES (13, 'TEA');
INSERT INTO ingridient (id, name) VALUES (14, 'MILK');
INSERT INTO ingridient (id, name) VALUES (15, 'LEMON');
INSERT INTO ingridient (id, name) VALUES (16, 'EGG');
INSERT INTO ingridient (id, name) VALUES (17, 'OIL');
INSERT INTO ingridient (id, name) VALUES (18, 'CHICKEN');
INSERT INTO ingridient (id, name) VALUES (19, 'PORK');
INSERT INTO ingridient (id, name) VALUES (20, 'BEEF');
INSERT INTO ingridient (id, name) VALUES (21, 'MUSHROOMS');
INSERT INTO ingridient (id, name) VALUES (22, 'SPINACH');
INSERT INTO ingridient (id, name) VALUES (23, 'APPLE');
INSERT INTO ingridient (id, name) VALUES (24, 'BANANA');
INSERT INTO ingridient (id, name) VALUES (25, 'STRAWBERRY');
INSERT INTO ingridient (id, name) VALUES (26, 'ORANGE');
INSERT INTO ingridient (id, name) VALUES (27, 'CHERRY');
INSERT INTO ingridient (id, name) VALUES (28, 'KIWI');
INSERT INTO ingridient (id, name) VALUES (29, 'CHICKEN');
INSERT INTO ingridient (id, name) VALUES (30, 'CHEESE');
INSERT INTO ingridient (id, name) VALUES (31, 'BUTTER');
INSERT INTO ingridient (id, name) VALUES (32, 'VANILLA');
INSERT INTO ingridient (id, name) VALUES (33, 'BUCKWHEAT');


                                                                                                                                                                                         2185.dat                                                                                            0000600 0004000 0002000 00000000160 12723265601 0014252 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        INSERT INTO "position" (id, name) VALUES (1, 'waiter');
INSERT INTO "position" (id, name) VALUES (2, 'cook');


                                                                                                                                                                                                                                                                                                                                                                                                                2199.dat                                                                                            0000600 0004000 0002000 00000006733 12723265601 0014273 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (1, 6, 1);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (2, 6, 4);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (3, 6, 3);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (4, 6, 17);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (5, 6, 14);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (6, 6, 11);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (7, 6, 16);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (8, 7, 1);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (9, 7, 11);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (10, 7, 16);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (11, 7, 4);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (12, 7, 17);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (13, 18, 23);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (14, 18, 1);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (15, 18, 11);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (16, 18, 16);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (17, 18, 4);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (18, 18, 3);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (19, 18, 32);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (20, 21, 1);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (21, 21, 4);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (22, 21, 3);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (23, 21, 31);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (24, 21, 30);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (25, 21, 15);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (26, 20, 27);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (27, 20, 1);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (28, 20, 11);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (29, 20, 16);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (30, 20, 4);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (31, 20, 3);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (32, 20, 32);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (33, 22, 32);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (34, 22, 27);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (35, 22, 3);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (36, 22, 14);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (37, 19, 1);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (38, 19, 3);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (39, 19, 4);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (40, 19, 14);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (41, 19, 11);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (42, 19, 31);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (43, 19, 16);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (44, 39, 16);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (45, 39, 14);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (46, 39, 4);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (47, 28, 13);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (48, 28, 1);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (49, 26, 12);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (50, 26, 14);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (51, 26, 1);
INSERT INTO recepy (id, dish_id, ingridient_id) VALUES (52, 26, 3);


                                     2193.dat                                                                                            0000600 0004000 0002000 00000001407 12723265601 0014256 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        INSERT INTO warehouse (id, ingridient_id, number) VALUES (12, 1, 300);
INSERT INTO warehouse (id, ingridient_id, number) VALUES (13, 2, 55);
INSERT INTO warehouse (id, ingridient_id, number) VALUES (14, 3, 50);
INSERT INTO warehouse (id, ingridient_id, number) VALUES (15, 4, 25);
INSERT INTO warehouse (id, ingridient_id, number) VALUES (16, 5, 30);
INSERT INTO warehouse (id, ingridient_id, number) VALUES (17, 6, 20);
INSERT INTO warehouse (id, ingridient_id, number) VALUES (18, 7, 22);
INSERT INTO warehouse (id, ingridient_id, number) VALUES (19, 8, 15);
INSERT INTO warehouse (id, ingridient_id, number) VALUES (20, 9, 10);
INSERT INTO warehouse (id, ingridient_id, number) VALUES (21, 10, 12);
INSERT INTO warehouse (id, ingridient_id, number) VALUES (22, 11, 46);


                                                                                                                                                                                                                                                         restore.sql                                                                                         0000600 0004000 0002000 00000041206 12723265601 0015373 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        --
-- NOTE:
--
-- File paths need to be edited. Search for $$PATH$$ and
-- replace it with the path to the directory containing
-- the extracted data files.
--
--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.3
-- Dumped by pg_dump version 9.5.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

ALTER TABLE ONLY public.warehouse DROP CONSTRAINT warehouse_ingridient_id_fkey;
ALTER TABLE ONLY public.recepy DROP CONSTRAINT recepy_ingridient_id_fkey;
ALTER TABLE ONLY public.recepy DROP CONSTRAINT recepy_dish_id_fkey;
ALTER TABLE ONLY public.employee DROP CONSTRAINT employee_position_id_fkey;
ALTER TABLE ONLY public.dish DROP CONSTRAINT dish_category_id_fkey;
ALTER TABLE ONLY public.booking_history DROP CONSTRAINT booking_history_employee_id_fkey;
ALTER TABLE ONLY public.booking_history DROP CONSTRAINT booking_history_dish_id_fkey;
ALTER TABLE ONLY public.booking_history DROP CONSTRAINT booking_history_booking_id_fkey;
ALTER TABLE ONLY public.booking DROP CONSTRAINT booking_employee_id_fkey;
ALTER TABLE ONLY public.warehouse DROP CONSTRAINT warehouse_pkey;
ALTER TABLE ONLY public.recepy DROP CONSTRAINT recepy_pkey;
ALTER TABLE ONLY public."position" DROP CONSTRAINT position_pkey;
ALTER TABLE ONLY public.ingridient DROP CONSTRAINT ingridient_pkey;
ALTER TABLE ONLY public.employee DROP CONSTRAINT employee_pkey;
ALTER TABLE ONLY public.dish DROP CONSTRAINT dish_pkey;
ALTER TABLE ONLY public.category DROP CONSTRAINT category_pkey;
ALTER TABLE ONLY public.booking DROP CONSTRAINT booking_pkey;
ALTER TABLE ONLY public.booking DROP CONSTRAINT booking_order_no_key;
ALTER TABLE ONLY public.booking_history DROP CONSTRAINT booking_history_pkey;
ALTER TABLE public.warehouse ALTER COLUMN id DROP DEFAULT;
ALTER TABLE public.recepy ALTER COLUMN id DROP DEFAULT;
ALTER TABLE public."position" ALTER COLUMN id DROP DEFAULT;
ALTER TABLE public.ingridient ALTER COLUMN id DROP DEFAULT;
ALTER TABLE public.employee ALTER COLUMN id DROP DEFAULT;
ALTER TABLE public.dish ALTER COLUMN id DROP DEFAULT;
ALTER TABLE public.category ALTER COLUMN id DROP DEFAULT;
ALTER TABLE public.booking_history ALTER COLUMN id DROP DEFAULT;
ALTER TABLE public.booking ALTER COLUMN id DROP DEFAULT;
DROP SEQUENCE public.warehouse_id_seq;
DROP TABLE public.warehouse;
DROP SEQUENCE public.recepy_id_seq;
DROP TABLE public.recepy;
DROP SEQUENCE public.position_id_seq;
DROP TABLE public."position";
DROP SEQUENCE public.ingridient_id_seq;
DROP TABLE public.ingridient;
DROP SEQUENCE public.employee_id_seq;
DROP TABLE public.employee;
DROP SEQUENCE public.dish_id_seq;
DROP TABLE public.dish;
DROP SEQUENCE public.category_id_seq;
DROP TABLE public.category;
DROP SEQUENCE public.booking_id_seq;
DROP SEQUENCE public.booking_history_id_seq;
DROP TABLE public.booking_history;
DROP TABLE public.booking;
DROP EXTENSION plpgsql;
DROP SCHEMA public;
--
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: booking; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE booking (
    id integer NOT NULL,
    order_no integer NOT NULL,
    employee_id integer NOT NULL,
    table_no integer NOT NULL,
    date date NOT NULL
);


ALTER TABLE booking OWNER TO "user";

--
-- Name: booking_history; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE booking_history (
    id integer NOT NULL,
    dish_id integer NOT NULL,
    employee_id integer NOT NULL,
    booking_id integer NOT NULL,
    date date NOT NULL
);


ALTER TABLE booking_history OWNER TO "user";

--
-- Name: booking_history_id_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE booking_history_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE booking_history_id_seq OWNER TO "user";

--
-- Name: booking_history_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: user
--

ALTER SEQUENCE booking_history_id_seq OWNED BY booking_history.id;


--
-- Name: booking_id_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE booking_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE booking_id_seq OWNER TO "user";

--
-- Name: booking_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: user
--

ALTER SEQUENCE booking_id_seq OWNED BY booking.id;


--
-- Name: category; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE category (
    id integer NOT NULL,
    name character varying(100) NOT NULL
);


ALTER TABLE category OWNER TO "user";

--
-- Name: category_id_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE category_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE category_id_seq OWNER TO "user";

--
-- Name: category_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: user
--

ALTER SEQUENCE category_id_seq OWNED BY category.id;


--
-- Name: dish; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE dish (
    id integer NOT NULL,
    name character varying(200) NOT NULL,
    category_id integer NOT NULL,
    price real NOT NULL,
    weight real NOT NULL,
    CONSTRAINT dish_price_check CHECK ((price > (0)::double precision)),
    CONSTRAINT dish_weight_check CHECK ((weight > (0)::double precision))
);


ALTER TABLE dish OWNER TO "user";

--
-- Name: dish_id_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE dish_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE dish_id_seq OWNER TO "user";

--
-- Name: dish_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: user
--

ALTER SEQUENCE dish_id_seq OWNED BY dish.id;


--
-- Name: employee; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE employee (
    id integer NOT NULL,
    name character varying(50) NOT NULL,
    surname character varying(50) NOT NULL,
    birth_date date NOT NULL,
    phone_number character varying(20) NOT NULL,
    position_id integer NOT NULL,
    salary real,
    CONSTRAINT employee_salary_check CHECK ((salary > (0)::double precision))
);


ALTER TABLE employee OWNER TO "user";

--
-- Name: employee_id_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE employee_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE employee_id_seq OWNER TO "user";

--
-- Name: employee_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: user
--

ALTER SEQUENCE employee_id_seq OWNED BY employee.id;


--
-- Name: ingridient; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE ingridient (
    id integer NOT NULL,
    name character varying(100) NOT NULL
);


ALTER TABLE ingridient OWNER TO "user";

--
-- Name: ingridient_id_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE ingridient_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ingridient_id_seq OWNER TO "user";

--
-- Name: ingridient_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: user
--

ALTER SEQUENCE ingridient_id_seq OWNED BY ingridient.id;


--
-- Name: position; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE "position" (
    id integer NOT NULL,
    name character varying(50) NOT NULL
);


ALTER TABLE "position" OWNER TO "user";

--
-- Name: position_id_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE position_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE position_id_seq OWNER TO "user";

--
-- Name: position_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: user
--

ALTER SEQUENCE position_id_seq OWNED BY "position".id;


--
-- Name: recepy; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE recepy (
    id integer NOT NULL,
    dish_id integer NOT NULL,
    ingridient_id integer NOT NULL
);


ALTER TABLE recepy OWNER TO "user";

--
-- Name: recepy_id_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE recepy_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE recepy_id_seq OWNER TO "user";

--
-- Name: recepy_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: user
--

ALTER SEQUENCE recepy_id_seq OWNED BY recepy.id;


--
-- Name: warehouse; Type: TABLE; Schema: public; Owner: user
--

CREATE TABLE warehouse (
    id integer NOT NULL,
    ingridient_id integer NOT NULL,
    number integer NOT NULL
);


ALTER TABLE warehouse OWNER TO "user";

--
-- Name: warehouse_id_seq; Type: SEQUENCE; Schema: public; Owner: user
--

CREATE SEQUENCE warehouse_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE warehouse_id_seq OWNER TO "user";

--
-- Name: warehouse_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: user
--

ALTER SEQUENCE warehouse_id_seq OWNED BY warehouse.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: user
--

ALTER TABLE ONLY booking ALTER COLUMN id SET DEFAULT nextval('booking_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: user
--

ALTER TABLE ONLY booking_history ALTER COLUMN id SET DEFAULT nextval('booking_history_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: user
--

ALTER TABLE ONLY category ALTER COLUMN id SET DEFAULT nextval('category_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: user
--

ALTER TABLE ONLY dish ALTER COLUMN id SET DEFAULT nextval('dish_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: user
--

ALTER TABLE ONLY employee ALTER COLUMN id SET DEFAULT nextval('employee_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: user
--

ALTER TABLE ONLY ingridient ALTER COLUMN id SET DEFAULT nextval('ingridient_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: user
--

ALTER TABLE ONLY "position" ALTER COLUMN id SET DEFAULT nextval('position_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: user
--

ALTER TABLE ONLY recepy ALTER COLUMN id SET DEFAULT nextval('recepy_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: user
--

ALTER TABLE ONLY warehouse ALTER COLUMN id SET DEFAULT nextval('warehouse_id_seq'::regclass);


--
-- Data for Name: booking; Type: TABLE DATA; Schema: public; Owner: user
--

\i $$PATH$$/2189.dat

--
-- Data for Name: booking_history; Type: TABLE DATA; Schema: public; Owner: user
--

\i $$PATH$$/2201.dat

--
-- Name: booking_history_id_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('booking_history_id_seq', 1, false);


--
-- Name: booking_id_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('booking_id_seq', 1, false);


--
-- Data for Name: category; Type: TABLE DATA; Schema: public; Owner: user
--

\i $$PATH$$/2195.dat

--
-- Name: category_id_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('category_id_seq', 11, true);


--
-- Data for Name: dish; Type: TABLE DATA; Schema: public; Owner: user
--

\i $$PATH$$/2197.dat

--
-- Name: dish_id_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('dish_id_seq', 41, true);


--
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: user
--

\i $$PATH$$/2187.dat

--
-- Name: employee_id_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('employee_id_seq', 5, true);


--
-- Data for Name: ingridient; Type: TABLE DATA; Schema: public; Owner: user
--

\i $$PATH$$/2191.dat

--
-- Name: ingridient_id_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('ingridient_id_seq', 33, true);


--
-- Data for Name: position; Type: TABLE DATA; Schema: public; Owner: user
--

\i $$PATH$$/2185.dat

--
-- Name: position_id_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('position_id_seq', 2, true);


--
-- Data for Name: recepy; Type: TABLE DATA; Schema: public; Owner: user
--

\i $$PATH$$/2199.dat

--
-- Name: recepy_id_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('recepy_id_seq', 52, true);


--
-- Data for Name: warehouse; Type: TABLE DATA; Schema: public; Owner: user
--

\i $$PATH$$/2193.dat

--
-- Name: warehouse_id_seq; Type: SEQUENCE SET; Schema: public; Owner: user
--

SELECT pg_catalog.setval('warehouse_id_seq', 22, true);


--
-- Name: booking_history_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY booking_history
    ADD CONSTRAINT booking_history_pkey PRIMARY KEY (id);


--
-- Name: booking_order_no_key; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY booking
    ADD CONSTRAINT booking_order_no_key UNIQUE (order_no);


--
-- Name: booking_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY booking
    ADD CONSTRAINT booking_pkey PRIMARY KEY (id);


--
-- Name: category_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY category
    ADD CONSTRAINT category_pkey PRIMARY KEY (id);


--
-- Name: dish_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY dish
    ADD CONSTRAINT dish_pkey PRIMARY KEY (id);


--
-- Name: employee_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (id);


--
-- Name: ingridient_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY ingridient
    ADD CONSTRAINT ingridient_pkey PRIMARY KEY (id);


--
-- Name: position_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY "position"
    ADD CONSTRAINT position_pkey PRIMARY KEY (id);


--
-- Name: recepy_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY recepy
    ADD CONSTRAINT recepy_pkey PRIMARY KEY (id);


--
-- Name: warehouse_pkey; Type: CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY warehouse
    ADD CONSTRAINT warehouse_pkey PRIMARY KEY (id);


--
-- Name: booking_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY booking
    ADD CONSTRAINT booking_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES employee(id);


--
-- Name: booking_history_booking_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY booking_history
    ADD CONSTRAINT booking_history_booking_id_fkey FOREIGN KEY (booking_id) REFERENCES booking(id);


--
-- Name: booking_history_dish_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY booking_history
    ADD CONSTRAINT booking_history_dish_id_fkey FOREIGN KEY (dish_id) REFERENCES dish(id);


--
-- Name: booking_history_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY booking_history
    ADD CONSTRAINT booking_history_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES employee(id);


--
-- Name: dish_category_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY dish
    ADD CONSTRAINT dish_category_id_fkey FOREIGN KEY (category_id) REFERENCES category(id);


--
-- Name: employee_position_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY employee
    ADD CONSTRAINT employee_position_id_fkey FOREIGN KEY (position_id) REFERENCES "position"(id);


--
-- Name: recepy_dish_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY recepy
    ADD CONSTRAINT recepy_dish_id_fkey FOREIGN KEY (dish_id) REFERENCES dish(id);


--
-- Name: recepy_ingridient_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY recepy
    ADD CONSTRAINT recepy_ingridient_id_fkey FOREIGN KEY (ingridient_id) REFERENCES ingridient(id);


--
-- Name: warehouse_ingridient_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: user
--

ALTER TABLE ONLY warehouse
    ADD CONSTRAINT warehouse_ingridient_id_fkey FOREIGN KEY (ingridient_id) REFERENCES ingridient(id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          