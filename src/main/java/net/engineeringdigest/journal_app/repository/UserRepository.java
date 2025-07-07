package net.engineeringdigest.journal_app.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import net.engineeringdigest.journal_app.entity.User;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByUsername(String username);

}
