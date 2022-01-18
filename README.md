# Spring Boot, H2, JPA, Hibernate Restful CRUD API Tutorial
* Spring Boot - 2.6.2
* JDK - 17
* Spring Data JPA
* Spring Web
* H2 Embedded Database
* Maven - 4
* IDE - Eclipse or Spring Tool Suite (STS)
* Lombok

### H2 Database Configuration 

        server.port=8081
            # H2 Database Configure
        spring.datasource.url=jdbc:h2:mem:testdb
        spring.datasource.driverClassName=org.h2.Driver
        spring.datasource.username=sa
            #spring.datasource.password=password
        spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
        spring.h2.console.enabled=true
            #hibernate
        spring.jpa.show-sql= true
        spring.jpa.hibernate.ddl-auto=update

## Spring REST Controller
#### Delete with DELETE

        @DeleteMapping("/products/{id}")
        public HttpStatus deleteProduct(@PathVariable long id) {

#### Update with PUT

        @PutMapping("/products/{id}")
        public ResponseEntity < Product > updateProduct(@PathVariable long id, @RequestBody Product product)

#### Create with POST      
        @PostMapping("/products")
        public ResponseEntity < Product > createProduct(@RequestBody Product product)

#### Read Data with  GET
        //all list
        @GetMapping("/products")
        public ResponseEntity < List < Product >> getAllProduct()

        //single item
        @GetMapping("/products/{id}")
        public ResponseEntity < Product > getProductById(@PathVariable long id)

### Custom Error

    #add application.properties
    server.error.include-message=always
.

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class NotFoundExceptionRuntiime extends RuntimeException

