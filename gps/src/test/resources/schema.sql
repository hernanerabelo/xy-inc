CREATE TABLE GPS_POI (
  ID      INTEGER auto_increment PRIMARY KEY,
  POINT_X LONG NOT NULL,
  POINT_Y LONG NOT NULL,
  NAME    VARCHAR(255) NOT NULL);

insert into GPS_POI (POINT_X, POINT_Y, NAME) values( 27, 12, 'Lanchonete' );
insert into GPS_POI (POINT_X, POINT_Y, NAME) values( 31, 18, 'Posto' );
insert into GPS_POI (POINT_X, POINT_Y, NAME) values( 15, 12, 'Joalheria' );
insert into GPS_POI (POINT_X, POINT_Y, NAME) values( 19, 21, 'Floricultura' );
insert into GPS_POI (POINT_X, POINT_Y, NAME) values( 12, 8, 'Pub' );
insert into GPS_POI (POINT_X, POINT_Y, NAME) values( 26, 6, 'Supermercado' );
insert into GPS_POI (POINT_X, POINT_Y, NAME) values( 28, 2, 'Churrascaria' );
