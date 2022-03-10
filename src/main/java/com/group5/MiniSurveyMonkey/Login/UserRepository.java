package com.group5.MiniSurveyMonkey.Login;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<LocalUser, Long> {
    LocalUser findById (long id);
    LocalUser findByUser(String user);
    LocalUser findByAccessType(String accessType);
}
