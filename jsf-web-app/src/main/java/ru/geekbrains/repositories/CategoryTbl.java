package ru.geekbrains.repositories;

import ru.geekbrains.entity.Category;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CategoryTbl {

    Category findById(long id);
    List<Category> findAll();
}
