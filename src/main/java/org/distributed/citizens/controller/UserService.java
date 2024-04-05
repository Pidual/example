package org.distributed.citizens.controller;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
@Service
public class UserService {
    private final Map<UUID, UserDTO> users = new HashMap<>();

    public List<UserDTO> findEverything(String filter) {
        return users.keySet().stream().map(users::get).toList();
    }

    public void createUser(UserDTO dto, String mail) {
        users.put(UUID.randomUUID(), dto);
    }

    public UserDTO encontrarPorId(final UUID id) {
        return users.get(id);
    }

    public void delete(final UUID id) {
        users.remove(id);
    }

    public void createUserForTest() {
        users.put(UUID.fromString("550e8400-e29b-41d4-a716-446655440000"), new UserDTO("akira pepe"));
    }
}
