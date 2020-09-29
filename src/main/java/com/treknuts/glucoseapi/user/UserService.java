package com.treknuts.glucoseapi.user;

import com.treknuts.glucoseapi.models.User;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserRepository userRepository;
    private EmailService emailSenderService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        final Optional<User> optionalUser = userRepository.findByUsername(username);

        if(optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new UsernameNotFoundException(
                    MessageFormat.format("User with email {0} cannot be found.", username)
            );
        }
    }

    void sendConfirmationEmail(String userMail, String token) {
        final SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(userMail);
        mailMessage.setSubject("Glucose Diary Confirmation Link!");
        mailMessage.setFrom("trevorknutson.complete@gmail.com");
        mailMessage.setText(
                "Thank you for registering! Please click the link below to activate your account."
                        + "http://localhost:8080/sign-up/confirm?token=" + token
        );
        emailSenderService.sendEmail(mailMessage);
    }

}
