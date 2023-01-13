package com.pintbid.project.backend.repository;

import com.pintbid.project.backend.models.Role;
import com.pintbid.project.backend.utils.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
  Optional<Role> findByName(ERole name);
}
