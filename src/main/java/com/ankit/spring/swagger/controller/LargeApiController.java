package com.ankit.spring.swagger.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api/large")
public class LargeApiController {

    @GetMapping("/status")
    public ResponseEntity<Map<String, String>> getStatus() {
        return ResponseEntity.ok(Map.of("status", "API is running", "version", "1.0"));
    }

    @GetMapping("/users")
    public ResponseEntity<List<Map<String, Object>>> getUsers() {
        List<Map<String, Object>> users = IntStream.range(1, 51)
                .mapToObj(i -> {
                    Map<String, Object> user = new HashMap<>();
                    user.put("id", i);  // Integer
                    user.put("name", "User " + i);  // String
                    user.put("role", (i % 2 == 0) ? "Admin" : "User"); // String
                    return user;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(users);
    }

    @GetMapping("/items")
    public ResponseEntity<List<Map<String, Object>>> getItems() {
        List<Map<String, Object>> items = IntStream.range(1, 51)
                .mapToObj(i -> Map.<String, Object>of(
                        "id", (Object) i,
                        "name", "Item " + i,
                        "price", (Object) (i * 10.99)
                ))
                .collect(Collectors.toList());
        return ResponseEntity.ok(items);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Map<String, Object>> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(Map.of("id", id, "name", "User " + id, "role", id % 2 == 0 ? "Admin" : "User"));
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

    @DeleteMapping("/users")
    public ResponseEntity<String> deleteAllUsers() {
        return ResponseEntity.ok("All users deleted successfully.");
    }

    @PostMapping("/item")
    public ResponseEntity<String> createItem(@RequestBody Map<String, Object> item) {
        return ResponseEntity.ok("Item " + item.get("name") + " created successfully.");
    }

    @PutMapping("/item/{id}")
    public ResponseEntity<String> updateItem(@PathVariable int id, @RequestBody Map<String, Object> item) {
        return ResponseEntity.ok("Item ID " + id + " updated with new name: " + item.get("name"));
    }

    @DeleteMapping("/item/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable int id) {
        return ResponseEntity.ok("Item ID " + id + " deleted successfully.");
    }

    @DeleteMapping("/items")
    public ResponseEntity<String> deleteAllItems() {
        return ResponseEntity.ok("All items deleted successfully.");
    }
}

