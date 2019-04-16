package com.csharp.bikerental.controller;

import com.csharp.bikerental.persistence.model.User;
import com.csharp.bikerental.persistence.model.UserEdit;
import com.csharp.bikerental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/EditUser")
    public ResponseEntity<?> EditUser(UserEdit user){
        String username = user.getUserName();
        try {
            userService.editUser(username);
            return ResponseEntity.ok().body(user);

        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }

    }

    @PostMapping("/UndoUser")
    public ResponseEntity<?> UndoEditUser(UserEdit user){
        String username = user.getUserName();
        try {
            userService.undoEdit(username);
            return ResponseEntity.ok().body(user);

        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }

    }
}
