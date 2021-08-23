package com.first.data;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.ValidationException;
import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class UserService {

    @Autowired
    public UserRepository repo;

    public List<UserEntity> findAll(){
        return repo.findAll();
    }

    public UserEntity create(UserEntity userEntity) throws ValidationException {
        if (userEntity.getId() != null){
            throw new ValidationException("Expected ID value is null instead of" + userEntity.getId());
        }
        return repo.save(userEntity);
    }


}
