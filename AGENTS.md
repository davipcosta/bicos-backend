# Bico Vagas API - Agent Guidelines

## Project Overview

This is a Spring Boot 3.2 REST API for the "Bico Vagas" platform (freelance job marketplace).
Java 21, PostgreSQL, Spring Security with JWT authentication.

## Architecture

- **Layered architecture**: Controller → Service → Repository → Entity
- **DTOs** in `controller/dto/` for API contracts (never expose entities directly)
- **Security** via JWT tokens, role-based access (FREELANCER, APROVADOR_N1/N2/N3)

## Package Structure

```
com.example.demo.bicos/
├── controller/     # @RestController classes
│   └── dto/        # Request/Response records
├── service/        # @Service classes with business logic
├── repo/           # JpaRepository interfaces
├── models/         # @Entity classes
└── infra/config/   # Security, Swagger, filters
```

## Conventions

- **Entities**: Singular names (e.g., `User`, `Bico`), use `@Entity` + `@Table`
- **Repositories**: Interface extending `JpaRepository<Entity, IdType>`
- **Services**: Constructor injection (not `@Autowired` on fields)
- **Controllers**: Use `@Tag` and `@Operation` for Swagger docs
- **DTOs**: Prefer Java `record` types for immutability

## Database

- PostgreSQL via Docker Compose (`docker-compose up -d`)
- Soft delete pattern on User entity (`deleted_at` column)
- Timestamps via `@CreationTimestamp` and `@UpdateTimestamp`

## Testing

```bash
./mvnw test
```

## Common Tasks

- **Add new endpoint**: Create DTO → Add Service method → Add Controller endpoint
- **Add new entity**: Create Entity → Create Repository → Create Service
- **Run locally**: `docker-compose up -d && ./mvnw spring-boot:run`
