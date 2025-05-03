package ZCWDelta.ZipTube.services;

import ZCWDelta.ZipTube.models.User;
import ZCWDelta.ZipTube.repos.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    public User createUser(User user) {
        // Logic to create a new user
        // This might involve saving the user to a database
        //return userRepository.save(user);
       return null; //I put this here to be able to push
    }
}
