package com.vedha.service;

import com.vedha.dto.UsersDTO;

import java.util.List;
import java.util.Map;

public interface UsersService {

    List<UsersDTO> getAllUsers();

    UsersDTO saveUser(UsersDTO usersDTO);

    UsersDTO updateUser(Long userId, UsersDTO usersDTO);

    Map<String, String> deleteUser(Long userId);

    UsersDTO getUserById(Long id);
}
