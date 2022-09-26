package com.integrador.odonto.backendquintobimestre.service.impl;

import com.integrador.odonto.backendquintobimestre.entity.UserEntity;
import com.integrador.odonto.backendquintobimestre.entity.dto.UserDTO;
import com.integrador.odonto.backendquintobimestre.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository   .findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }

    public Boolean create(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity(userDTO);
        String password = passwordEncoder.encode(userEntity.getPassword());
        userEntity.setPassword(password);
        try {
            userRepository.save(userEntity);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
