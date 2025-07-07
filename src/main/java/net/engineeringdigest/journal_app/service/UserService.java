package net.engineeringdigest.journal_app.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journal_app.entity.User;
import net.engineeringdigest.journal_app.repository.UserRepository;

@Component
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // save entry
    public void saveEntry(User entry) {
        userRepository.save(entry);
    }

    // get all
    public List<User> getAll() {
        return userRepository.findAll();
    }

    // find by id
    public Optional<User> findById(ObjectId id) {
        return userRepository.findById(id);
    }

    // delete by id
    // public void deleteById(ObjectId id) {
    //     userRepository.deleteById(id);
    // }

    // find by username
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
