package com.userservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dominik_Janiga
 */
@Repository
interface UserRepository extends JpaRepository<User, Long> {
}
