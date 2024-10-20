package com.jwt.service;

import com.jwt.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

   private List<User> users = new ArrayList<User>();

   public UserService() {

       users.add(new User(UUID.randomUUID().toString(), "pradeep", "bamn@gmail.com", "123" ));
       users.add(new User(UUID.randomUUID().toString(), "sahdev", "sahdev@gmail.com", "1234" ));
       users.add(new User(UUID.randomUUID().toString(), "radhe", "radhe@gmail.com", "12345" ));


   }

   public List<User> getUsers() {
       return users;
   }
}
