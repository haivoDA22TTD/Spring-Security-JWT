package spring.security.token.services.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import spring.security.token.repository.UserRepository;
import spring.security.token.services.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
        public UserDetailsService userDetailsService(){
            return new UserDetailsService() {
                    @SuppressWarnings("unused")
                    public UserDetails loadUserByUser( String username){
                        return (UserDetails) userRepository.findByEmail(username)
                            .orElseThrow(()->new UsernameNotFoundException("User not found"));
                    }

                @Override
                public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                    // TODO Auto-generated method stub
                    throw new UnsupportedOperationException("Unimplemented method 'loadUserByUsername'");
                }
            };
        }
    }
