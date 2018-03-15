package by.runets.voting.controller;


import by.runets.voting.dto.UserDTO;
import by.runets.voting.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Log4j2
public class UserController {
    private final UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> save(@RequestBody @Valid final UserDTO user) {
        log.debug("User from request: " + user);
        userService.save(user);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> users = userService.findAll();
        return ResponseEntity.ok(users);
    }
}
