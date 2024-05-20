package com.example.kurs6.service;


import com.example.kurs6.dto.UserDTO;
import com.example.kurs6.entity.User;
import com.example.kurs6.repository.UserRepository;
import lombok.AllArgsConstructor;


import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class UserService  {
    private final UserRepository userRepository;

    public User create(UserDTO dto){

        User user = User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
        return userRepository.save(user);
    }

    public List<User> readAll(){
        return userRepository.findAll();
    }

    public User readById(Long id){
        return userRepository.findById(id).orElseThrow( ()-> new RuntimeException("User not found " + id));
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User update(User user){
        return userRepository.save(user);
    }

   public void delete(Long id){
        userRepository.deleteById(id);
   }
}
