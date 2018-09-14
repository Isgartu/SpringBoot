# ArtistSpringBootRestApi with Spring Boot, H2 and JPA

## Setup the Application

1. Input data in data-h2.sql

2. Type `mvn spring-boot:run` from the root directory of the project to run the application. Or automatic run with your favourite IDE

## Endpoints

### Arts

http://localhost:8085/arts
Shows all the contemplated arts, such as architecture, jewelry, painting, sculpture ...

http://localhost:8085/arts/{art_id}
Shows the detailed information of the specific artId

http://localhost:8085/arts/search?artName=fotografia
Search the arts that have that name

http://localhost:8085/arts/search?artCentury=S. IV a.C.
Search the arts of this century

http://localhost:8085/arts/search?artYear=c. 468 a.C.
Search the arts of this year

### Movements

http://localhost:8085/movements
Shows all the artistic movements contemplated, such as Surrealism, Cubism, Dadaism, Modernism ...

http://localhost:8085/movements/{movement_id}
Show the detailed information of the specific movementId

http://localhost:8085/movements/search?movementName=Surrealismo
Search the movements that have that name

http://localhost:8085/movements/search?movementCentury=S. XX
Search the movement of this century

http://localhost:8085/movements/search?movementYear=1920
Search the movement of this year

http://localhost:8085/movements/search?movementArt=1
Shows the detailed information of the specific movement that have artId

### Artists

http://localhost:8085/artists
Shows all artists with all their characteristics

http://localhost:8085/artists/{artist_id}
Shows the detailed information of the specific artistId

http://localhost:8085/artists/search?artistName=Salvador
Search the artists that have that name

http://localhost:8085/artists/search?artistSurnames=Dali
Search the artists that have that surname

http://localhost:8085/artists/search?artistNickname=El Bigotes
Search the artists that have that nickname

http://localhost:8085/artists/search?artistNationality=Espanol
Search the artists that have that nationality

http://localhost:8085/artists/search?artistBorn


http://localhost:8085/artists/search?artistDied


http://localhost:8085/artists/search?artistArt
Shows the detailed information of the specific artists that have artId

http://localhost:8085/artists/search?artistMovement
Shows the detailed information of the specific artists that have artistMovementId


Movimientos: Surrealismo, Cubismo, Dadaísmo, Modernismo, impresionismo...

	

Based in: https://www.callicoder.com/hibernate-spring-boot-jpa-one-to-many-mapping-example/