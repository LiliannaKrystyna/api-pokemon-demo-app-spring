# Pokemon Manager API

A Spring Boot REST API for managing Pokemon data, with features for saving and retrieving Pokemon information.

## 🚀 Features

- Fetch Pokemon data from PokeAPI
- Save favorite Pokemon to local database
- List all saved Pokemon
- RESTful API endpoints
- CORS support for frontend integration
- Error handling and validation

## 🛠 Tech Stack

- **Java 21**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **PostgreSQL**
- **Gradle**
- **Spring Web**

## 📋 Prerequisites

- JDK 17 or later
- Gradle 7.x+
- PostgreSQL 12+
- IDE (IntelliJ IDEA recommended)

## 🔧 Configuration

1. Clone the repository:
```bash
git clone <https://github.com/LiliannaKrystyna/api-pokemon-demo-app-spring.git>
```

2. Configure database in `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/pokemon_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

3. Build the project:
```bash
./gradlew build
```

## 🚀 Running the Application

1. Start the application:
```bash
./gradlew bootRun
```

2. The API will be available at: `http://localhost:8080`

## 📍 API Endpoints

### Pokemon Management

```
GET /api/pokemon/allPokemons - Get all saved Pokemon
POST /api/pokemon - Save a new Pokemon
```

#### Save Pokemon
```json
POST /api/pokemon
{
    "id": 25,
    "name": "pikachu",
    "imageUrl": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png"
}
```

#### Get All Pokemon
```json
GET /api/pokemon/allPokemons
[
    {
        "id": 25,
        "name": "pikachu",
        "imageUrl": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png"
    }
]
```

## 🔒 Security

- CORS configuration enabled for frontend integration
- Input validation for Pokemon data
- Error handling for invalid requests

## 🧪 Testing

## 📦 Building for Production

1. Build the JAR file:
```bash
./gradlew build
```

2. The JAR will be available in `build/libs/`

3. Run the JAR:
```bash
java -jar build/libs/pokemon-manager-0.0.1-SNAPSHOT.jar
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request


## ✨ Acknowledgments

- [PokeAPI](https://pokeapi.co/) for Pokemon data
- Spring Boot team for the amazing framework
- The Pokemon Company for the inspiration