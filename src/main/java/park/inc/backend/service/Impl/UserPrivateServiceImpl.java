package park.inc.backend.service.Impl;



import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import park.inc.backend.domain.UserPrivate;
import park.inc.backend.exception.UserPrivateNotFoundException;
import park.inc.backend.repository.UserPrivateRepository;
import park.inc.backend.service.UserPrivateService;

import java.util.List;

@Service
@Transactional
public class UserPrivateServiceImpl implements UserPrivateService {

    @Autowired
    UserPrivateRepository userPrivateRepository;

    public List<UserPrivate> findAll() {
        return userPrivateRepository.findAll();
    }

    public UserPrivate findById(Long id) {
        return userPrivateRepository.findById(id)
                .orElseThrow(() -> new UserPrivateNotFoundException(id));
    }

    public UserPrivate create(UserPrivate userPrivate) {
        userPrivateRepository.save(userPrivate);
        return userPrivate;
    }

    public void update(Long id, UserPrivate uUserPrivate) {
        UserPrivate userPrivate = userPrivateRepository.findById(id)
                .orElseThrow(() -> new UserPrivateNotFoundException(id));
        userPrivate.setEmail(uUserPrivate.getEmail());
        userPrivate.setPassword(uUserPrivate.getPassword());
        userPrivate.setPhoneNumber(uUserPrivate.getPhoneNumber());
        userPrivateRepository.save(userPrivate);
    }

    public void delete(Long id) {
        UserPrivate userPrivate = userPrivateRepository.findById(id)
                .orElseThrow(() -> new UserPrivateNotFoundException(id));
        userPrivateRepository.delete(userPrivate);
    }
}