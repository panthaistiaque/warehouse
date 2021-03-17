package com.ihit.warehouse.mscproject.auth.repo;

import com.ihit.warehouse.mscproject.auth.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by User on 2/23/2021.
 */
@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {
    Role findByRoleName(String roleName);
}
