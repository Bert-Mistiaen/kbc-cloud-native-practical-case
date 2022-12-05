package com.ezgroceries.shoppinglist.repository;

import com.ezgroceries.shoppinglist.model.Cocktails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CocktailRepository extends CrudRepository<Cocktails, String>
{
    Set<Cocktails> findAll();

    Set<Cocktails> findByNameStartsWith(String search);
}
