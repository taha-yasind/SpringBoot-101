package org.example.sayhello;

import org.springframework.http.HttpStatus; //response entitiy ile alakalı
import org.springframework.http.ResponseEntity; // response entitiy ile alakalı
import org.springframework.web.bind.annotation.*; //spring framework'ü için gerekli kütüphaneleri ekliyoruz


@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Spring Boot'a Hoşgelidn...";
    }

    @GetMapping("/hello/{name}")
    public String sayHelloToName(@PathVariable String name) {
        return "Hoşgeldin, " + name + "!";
    }

    @PostMapping("/hello")
    public String sayHelloFromPost() {
        return "Hello from POST!";
    }

    @GetMapping("/hello-query")
    public String sayHelloWithQuery(@RequestParam String name) {
        return "Hello " + name;
    }

    @GetMapping("/hello-query-optional")
    public String sayHelloOptional(@RequestParam(defaultValue = "Guest") String name) {
        return "Hello " + name;
    }

    @PostMapping("/hello-body")
    public String helloFromBody(@RequestBody String name) {
        return "Hello " + name;
    }

    @PostMapping("/hello-json")
    public String helloFromJson(@RequestBody HelloRequest request) {
        return "Hello " + request.getName();
    }

    @PostMapping("/hello-json-response")
    public ResponseEntity<HelloResponse> helloJsonResponse() {

        HelloResponse response = new HelloResponse("Hello from JSON Response!");

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }


}
