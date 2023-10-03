package com.marcus.desafiodioapi.services;

import com.marcus.desafiodioapi.domain.model.User;
import com.marcus.desafiodioapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        // Implemente a lógica para criar um usuário no banco de dados
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        // Implemente a lógica para buscar um usuário por ID
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(Long id, User user) {
        // Implemente a lógica para atualizar um usuário por ID
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            // Atualize os campos do usuário com base nos dados fornecidos
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            // Salve as alterações no banco de dados
            return userRepository.save(existingUser);
        }
        return null;
    }

    public boolean deleteUser(Long id) {
        // Implemente a lógica para excluir um usuário por ID
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            userRepository.delete(existingUser);
            return true;
        }
        return false;
    }
}