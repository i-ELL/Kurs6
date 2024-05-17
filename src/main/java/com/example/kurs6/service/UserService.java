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
    /*
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User u = findByUsername(name);
        if (Objects.isNull(u)) {
            throw new UsernameNotFoundException(String.format("User %s is not found", name));
        }
        return new org.springframework.security.core.userdetails.User(u.getName(), u.getPassword(), true, true, true, true, new HashSet<>());
    }

     */

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

    public User findByUsername(String name){
        return userRepository.findByName(name);
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
