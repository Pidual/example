package org.distributed.citizens.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping //annotation to help spring understand
    public List<UserDTO> getEverything(@RequestParam(required = false) String filter){
        return userService.findEverything(filter);
    }

    @GetMapping("/generate")
    public UserDTO getRandomPerson(){
        return new UserDTO("example program 22222 "+Math.random());
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserDTO dto, String mail){
        userService.createUser(dto,mail);
    }

    @PostMapping("/test")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUserForTest(){
        userService.createUserForTest();
    }

    @GetMapping("/{usuarioId}")
    public UserDTO encontrarPorId(@PathVariable UUID usuarioId){
        return userService.encontrarPorId(usuarioId);
    }

    @DeleteMapping("/delete/{usuarioId}")
    public void deleteUser(@PathVariable UUID usuarioId){
        userService.delete(usuarioId);
    }

}
