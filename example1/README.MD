# UserManagement

## Description
A brief description of your project, its purpose, and what it does.

## Important Points

### Status Codes
- **200 OK**: Indicates that the request has succeeded.
- **404 Not Found**: Indicates that the requested resource could not be found.
- **500 Internal Server Error**: Indicates that the server encountered an unexpected condition.

### Alternative Status Codes
- **204 No Content**: Use this when the request was successful but there is no content to return.
- **400 Bad Request**: Use this when the server cannot process the request due to client error.

### Use of `Optional`
- `Optional<T>` is used to represent a value that may or may not be present. It helps avoid `NullPointerExceptions` and makes the code more readable.

### Annotations Used
- `@GetMapping`: Used to map HTTP GET requests onto specific handler methods.
- `@PostMapping`: Used to map HTTP POST requests onto specific handler methods.
- `@RequestParam`: Used to extract query parameters from the URL.


