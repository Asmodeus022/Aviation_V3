package com.barcode.aviation.tool.inventory.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.barcode.aviation.tool.inventory.dto.UserDto;
import com.barcode.aviation.tool.inventory.entities.UserEntity;
import com.barcode.aviation.tool.inventory.repository.UserRepository;
import com.barcode.aviation.tool.inventory.exception.ResourceNotFoundException;
import com.barcode.aviation.tool.inventory.mapper.UserMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto addUser(UserDto userDto) {
        UserEntity user = UserMapper.maptoUser(userDto);
        UserEntity savedUser = userRepository.save(user);
        return UserMapper.maptoUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        UserEntity user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User is note exists with given id: "+ userId));
        return UserMapper.maptoUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map((user)
        ->UserMapper.maptoUserDto(user))
        .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long userId, UserDto updatedUser) {
        UserEntity user = userRepository.findById(userId).orElseThrow(
            () -> new ResourceNotFoundException("User is not exists with given id:" + userId)
        );

        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
        user.setFullname(updatedUser.getFullname());
        user.setRole(updatedUser.getRole());
        
        UserEntity updatedUserObj =userRepository.save(user);

        return UserMapper.maptoUserDto(updatedUserObj);
    }

    @Override
    public void deleteUser(Long userId) {
        @SuppressWarnings("unused") 
        UserEntity user = userRepository.findById(userId).orElseThrow(
            () -> new ResourceNotFoundException("User is not exists with given id:" + userId)
        );
        userRepository.deleteById(userId);
    }

}
