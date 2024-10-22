package com.moseoh.unio.api;

import com.moseoh.unio.entity.user.User;
import com.moseoh.unio.entity.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

}
