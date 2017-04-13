package org.poc.aop.repository;

import org.poc.aop.model.User;

public interface FakeJpaRepository {
    User findByUserName(String username);
}
