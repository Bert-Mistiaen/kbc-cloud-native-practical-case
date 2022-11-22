package com.ezgroceries.shoppinglist.repository;

import com.ezgroceries.shoppinglist.model.Cocktail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface CocktailsRepository extends CrudRepository<Cocktail, UUID>
{
    Set<Cocktail> findAll();


}
