# Student Management System

This project is a Student Management System built using Spring Boot, which follows a structured approach to separate concerns and maintain a clean architecture.

## Project Structure

### 1. **Entity: `Student`**
- **Role**: Represents the data structure of a student in the system.
- **Description**: Defines attributes like `id`, `firstName`, `lastName`, and `email`. These attributes are annotated to map them to the corresponding database table.

### 2. **Repository: `StudentRepository`**
- **Role**: Data access layer.
- **Description**: Provides methods to perform CRUD operations on the `Student` entity. It extends `JpaRepository`, which offers methods like `save()`, `findById()`, `findAll()`, and `deleteById()`.

### 3. **Service Interface: `StudentService`**
- **Role**: Service layer interface.
- **Description**: Declares the methods that will be implemented in the service implementation class. These methods define the business logic related to student operations.

### 4. **Service Implementation: `StudentServiceImpl`**
- **Role**: Service layer implementation.
- **Description**: Implements the methods declared in `StudentService`. This class contains the actual business logic and interacts with the `StudentRepository` to perform database operations.

### 5. **Controller: `StudentController`**
- **Role**: Presentation layer.
- **Description**: Handles HTTP requests and maps them to the appropriate service methods. It defines endpoints for operations like creating, updating, deleting, and retrieving students.

### 6. **Templates (Thymeleaf): `create_student.html`, `edit_student.html`, `students.html`**
- **Role**: View layer.
- **Description**: Defines the HTML templates for the web pages in the application. `create_student.html` is for adding a new student, `edit_student.html` is for editing an existing student, and `students.html` is for displaying the list of students.

## Flow of a Typical Request

1. **Client Request**: A user sends a request to the application (e.g., to add a new student).

2. **Controller Layer**:
   - The request is received by a method in the `StudentController`.
   - The controller processes the request, interacts with the service layer, and returns a view name.

3. **Service Layer**:
   - The controller calls a method in the `StudentServiceImpl` to perform the required business logic.
   - The service method may call methods from `StudentRepository` to interact with the database.

4. **Repository Layer**:
   - `StudentRepository` interacts with the database to perform CRUD operations.

5. **Response Generation**:
   - The result from the service layer is returned to the controller.
   - The controller returns the view name (e.g., `students.html`).

6. **View Rendering**:
   - Thymeleaf processes the view template and dynamically inserts data.
   - The rendered HTML page is sent back to the client.

---

By following this structure, the Student Management System ensures a clean separation of concerns, making it easier to maintain and extend the application.
