package com.vedha.service.impl;

import com.vedha.dto.RolesDTO;
import com.vedha.dto.UsersDTO;
import com.vedha.entity.Users;
import com.vedha.repository.RolesRepository;
import com.vedha.repository.UsersRepository;
import com.vedha.service.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    private final RolesRepository rolesRepository;

    private final ModelMapper modelMapper;

    private final JdbcClient jdbcClient;

    @Override
    public UsersDTO saveUser(UsersDTO usersDTO) {

        UsersDTO map = modelMapper.map(usersRepository.save(modelMapper.map(usersDTO, Users.class)), UsersDTO.class);

        int update = jdbcClient.sql("INSERT INTO users_roles (user_id, role_id) VALUES (?, ?)").params(map.getId(), 2).update();
        log.info("Update: {}", update);

        map.setRoles(Set.of(modelMapper.map(rolesRepository.findById(2L).orElseThrow(() -> new RuntimeException("Role Not Found: 2")), RolesDTO.class)));

        return modelMapper.map(map, UsersDTO.class);
    }

    @Override
    public UsersDTO updateUser(Long userId, UsersDTO usersDTO) {

        Users users = usersRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found: ".concat(String.valueOf(userId))));
        users.setUsername(usersDTO.getUsername());
        users.setPassword(usersDTO.getPassword());
        users.setEmail(usersDTO.getEmail());

        return modelMapper.map(usersRepository.save(users), UsersDTO.class);
    }

    @Override
    public Map<String, String> deleteUser(Long userId) {

        usersRepository.deleteById(userId);

        return Map.of("message", "User deleted successfully", "status", "success", "id", String.valueOf(userId));
    }

    @Override
    public List<UsersDTO> getAllUsers() {

        return usersRepository.findAll().stream().map(users -> modelMapper.map(users, UsersDTO.class)).toList();
    }

    @Override
    public UsersDTO getUserById(Long id) {
        return modelMapper.map(usersRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found: ".concat(String.valueOf(id)))), UsersDTO.class);
    }

}
