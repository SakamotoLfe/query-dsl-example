package com.querydslexample.service;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydslexample.exception.RestRequestException;
import com.querydslexample.predicate.criteria.SearchPredicate;
import com.querydslexample.repository.GenericRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * Class created to make the generic services to the entire system.
 *
 * @author Alfredo Marin
 * @version ALPHA-0.0.1
 * @since 12/10/2019
 */

@Service
public abstract class GenericService<T> {

    private static final Logger LOGGER = Logger.getLogger(GenericService.class.getName());

    @Autowired
    protected abstract GenericRepository getGenericRepository();

    @Autowired
    protected abstract SearchPredicate<T> getSearchPredicate(String search);

    public List<T> findAll() {
        return getGenericRepository().findAll();
    }

    public Optional<T> findById(UUID id) {
        return getGenericRepository().findById(id);
    }

    public T save(T entity) {
        return (T) getGenericRepository().save(entity);
    }

    public Page<T> search(Pageable pageable, String search, Boolean isPageable) throws RestRequestException {
        if (isPageable) {
            if (search != null && !search.isEmpty()) {
                BooleanExpression expression = getSearchPredicate(search).getExpression();
                return new PageImpl<>((List<T>) getGenericRepository().findAll(expression));
            }
            return getGenericRepository().findAll(pageable);
        }
        return searchNonPaged(pageable, search);
    }

    private Page<T> searchNonPaged(Pageable pageable, String search) throws RestRequestException {
        if (search != null && !search.isEmpty()) {
            try {
                BooleanExpression expression = getSearchPredicate(search).getExpression();
                return getGenericRepository().findAll(expression, pageable);
            } catch (NullPointerException e) {
                LOGGER.log(Level.SEVERE, "ERROR! Stack: [{}]", e);
                throw new RestRequestException(HttpStatus.UNPROCESSABLE_ENTITY,
                        "An invalid search was received by the system!\nSearch: " + search + ". And the following exception was thrown: " + e.getStackTrace());
            }
        }
        return new PageImpl<>(getGenericRepository().findAll());
    }
}
