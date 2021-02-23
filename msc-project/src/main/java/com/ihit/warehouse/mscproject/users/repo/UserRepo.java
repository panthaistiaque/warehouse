package com.ihit.warehouse.mscproject.users.repo;

import com.ihit.warehouse.mscproject.users.DataBind.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 2/23/2021.
 */
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}
