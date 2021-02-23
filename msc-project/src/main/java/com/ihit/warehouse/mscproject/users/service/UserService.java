package com.ihit.warehouse.mscproject.users.service;

import com.ihit.warehouse.mscproject.auth.model.Role;
import com.ihit.warehouse.mscproject.auth.repo.RoleRepo;
import com.ihit.warehouse.mscproject.users.DataBind.User;
import com.ihit.warehouse.mscproject.users.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2/21/2021.
 */
@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    RoleRepo roleRepo;


    public User save(User user) {

        if (user.getRole() != null) {
            Role r = roleRepo.findByRoleName(user.getRole());
            List<Role> list = new ArrayList<>();
            list.add(r);
            user.setRoleList(list);
        }
        User userentry = userRepo.save(user);
        return userentry;
    }

    public List<User> findAll() {
        return userRepo.findAllByOrderByIdAsc();
    }

    public void deleteById(Integer id) {
        userRepo.deleteById(id);
    }
}
