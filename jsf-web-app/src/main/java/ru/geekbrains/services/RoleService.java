package ru.geekbrains.services;

import ru.geekbrains.repositories.RoleTbl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class RoleService implements Serializable {

    @Inject
    private RoleTbl roleTbl;

    @TransactionAttribute
    public List<RoleRepr> getAllRoles() {
        return roleTbl.getAllRoles().stream()
                .map(RoleRepr::new)
                .collect(Collectors.toList());
    }
}
