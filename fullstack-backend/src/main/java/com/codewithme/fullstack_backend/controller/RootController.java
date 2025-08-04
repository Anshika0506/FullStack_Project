//package com.codewithme.fullstack_backend.controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class RootController {
//    @GetMapping("/")
//    public String home() {
//        return "Backend is up and running";
//    }
//}

//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class RootController {
//
//    @GetMapping("/")
//    public String home() {
//        return "Backend is up and running";
//    }
//
//    // Example API jo frontend se data le sake
//    public static class EchoRequest {
//        public String message;
//    }
//
//    public static class EchoResponse {
//        public String echo;
//        public EchoResponse(String echo) { this.echo = echo; }
//    }
//
//    @PostMapping("/api/echo")
//    public EchoResponse echo(@RequestBody EchoRequest req) {
//        return new EchoResponse("Got: " + req.message);
//    }
//}


package com.codewithme.fullstack_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @GetMapping("/")
    public String home() {
        return "Backend is up and running";
    }

    public static class EchoRequest {
        public String message;
    }

    public static class EchoResponse {
        public String echo;
        public EchoResponse(String echo) { this.echo = echo; }
    }

    @PostMapping("/api/echo")
    public EchoResponse echo(@RequestBody EchoRequest req) {
        return new EchoResponse("Got: " + req.message);
    }
}

