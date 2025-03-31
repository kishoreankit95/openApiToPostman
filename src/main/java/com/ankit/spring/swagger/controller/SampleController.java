package com.ankit.spring.swagger.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sample")
public class SampleController {

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello, Ankit! Welcome to Swagger.");
    }

    @GetMapping("/users")
    public ResponseEntity<List<String>> getUsers() {
        List<String> users = List.of("Ankit", "John", "Alice", "Bob");
        return ResponseEntity.ok(users);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Map<String, Object>> getUserById(@PathVariable int id) {
        Map<String, Object> user = Map.of(
                "id", id,
                "name", "User " + id,
                "role", id % 2 == 0 ? "Admin" : "User"
        );
        return ResponseEntity.ok(user);
    }

    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody Map<String, Object> user) {
        return ResponseEntity.ok("User " + user.get("name") + " created successfully.");
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody Map<String, Object> user) {
        return ResponseEntity.ok("User ID " + id + " updated with new name: " + user.get("name"));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        return ResponseEntity.ok("User ID " + id + " deleted successfully.");
    }

    @GetMapping("/status")
    public ResponseEntity<Map<String, String>> getStatus() {
        return ResponseEntity.ok(Map.of("status", "API is running", "version", "1.0"));
    }

    @GetMapping("/items")
    public ResponseEntity<List<Map<String, Object>>> getItems() {
        List<Map<String, Object>> items = List.of(
                Map.of("id", 1, "name", "Item A", "price", 99.99),
                Map.of("id", 2, "name", "Item B", "price", 149.99),
                Map.of("id", 3, "name", "Item C", "price", 199.99)
        );
        return ResponseEntity.ok(items);
    }
}
