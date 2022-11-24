package com.ezgroceries.shoppinglist.repository;

import com.ezgroceries.shoppinglist.model.Cocktails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface CocktailRepository extends CrudRepository<Cocktails, UUID>
{
    Set<Cocktails> findAll();


}
