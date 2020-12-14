package ru.geekbrains.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.entity.User;
import ru.geekbrains.repositories.UserTbl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @EJB
    private UserTbl userTbl;

    @TransactionAttribute
    public void merge(UserRepr user) {
        User merged = userTbl.merge(new User(user));
        user.setId(merged.getId());
    }

    @TransactionAttribute
    public void delete(int id) {
        userTbl.delete(id);
    }

    @TransactionAttribute
    public UserRepr findById(int id) {
        return new UserRepr(userTbl.findById(id));
    }

    @TransactionAttribute
    public boolean existsById(int id) {
        return userTbl.findById(id) != null;
    }

    @TransactionAttribute
    public List<UserRepr> getAllUsers() {
        return userTbl.getAllUsers().stream()
                .map(UserRepr::new)
                .collect(Collectors.toList());
    }
}
