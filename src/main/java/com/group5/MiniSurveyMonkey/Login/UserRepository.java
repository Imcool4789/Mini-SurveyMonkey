package com.group5.MiniSurveyMonkey.Login;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<LocalUser, Long> {
    @Query("{id:'?0'}")
    LocalUser findById (long id);
    LocalUser findByUser(String user);
    LocalUser findByAccessType(String accessType);
}
