package park.inc.backend.service.Impl;



import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import park.inc.backend.domain.User;
import park.inc.backend.exception.UserNotFoundException;
import park.inc.backend.repository.UserRepository;
import park.inc.backend.service.UserService;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public User create(User user) {
        userRepository.save(user);
        return user;
    }

    public void update(Long id, User uUser) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        user.setUsername(uUser.getUsername());
        user.setFirstName(uUser.getFirstName());
        user.setMiddleName(uUser.getMiddleName());
        user.setLastName(uUser.getLastName());
        userRepository.save(user);
    }

    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        userRepository.delete(user);
    }
}