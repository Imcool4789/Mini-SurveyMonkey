package com.group5.MiniSurveyMonkey.Login;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<DBUser, Long> {
    DBUser findById(long id);

    DBUser findByRoles(String roles);

    DBUser findByUser(String user);
}
