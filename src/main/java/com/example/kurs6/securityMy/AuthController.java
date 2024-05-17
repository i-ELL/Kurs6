//package com.example.kurs6.securityMy;
//
//import com.example.kurs6.service.UserService;
//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
//import org.springframework.boot.autoconfigure.security.SecurityProperties;
//import org.springframework.http.MediaType;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Objects;
//
//@RestController
//@RequestMapping("/auth")
//public class AuthController {
//
//    private UserService service;
//
//    public AuthController(UserService service) {
//        this.service = service;
//    }
//
//    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody com.example.kurs6.entity.User getAuthUser() {
//        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//
//        //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth == null) {
//            return null;
//        }
//        Object principal = auth.getPrincipal();
//        User user = (principal instanceof User) ? (User) principal : null;
//        return Objects.nonNull(user) ? this.service.findByUsername(user.getUsername()) : null;
//    }
//
//}