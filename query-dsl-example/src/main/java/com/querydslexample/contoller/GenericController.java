package com.querydslexample.contoller;

import com.querydslexample.exception.RestRequestException;
import com.querydslexample.service.GenericService;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class created to make the generic services to the entire system.
 *
 * @author Alfredo Marin
 * @version ALPHA-0.0.1
 * @since 12/10/2019
 */

@RestController
public abstract class GenericController<T> {

    @Autowired
    protected abstract GenericService<T> getGenericService();

    /**
     * Method that returns all the generic entities.
     *
     * @return {@link ResponseEntity<List<T>>}
     */
    @GetMapping
    public ResponseEntity<Page<T>> search(final Pageable pageable,
                                          final @RequestParam(required = false, value = "search") String search,
                                          final @RequestParam(value = "isPageable", defaultValue = "false")
                                                     Boolean isPageable) throws RestRequestException {
        return new ResponseEntity<>(getGenericService().search(pageable, search, isPageable), HttpStatus.OK);
    }

    /**
     * Method that returns a generic entity by his id.
     *
     * @param id
     * @return {@link ResponseEntity<T>}
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<T> loadById(@PathVariable("id") UUID id) {
        System.out.println(new Date() + " Called LOAD-BY-ID.");
        return new ResponseEntity<>((T) getGenericService().findById(id), HttpStatus.CREATED);
    }

    /**
     * Method to save a generic entity.
     *
     * @param object
     */
    @PostMapping
    public ResponseEntity<T> save(@RequestBody T object) {
        System.out.println(new Date() + " Called SAVE.");
        return new ResponseEntity<>(getGenericService().save(object), HttpStatus.CREATED);
    }

    /**
     * Method to update a generic entity.
     *
     * @param object
     */
    @PutMapping
    public ResponseEntity<T> update(@RequestBody T object) {
        System.out.println(new Date() + " Called UPDATE.");
        return new ResponseEntity<>(getGenericService().save(object), HttpStatus.OK);
    }

    /**
     * Method that delete a generic entity. Not remove from Database, just deactivate it.
     *
     * @param object
     */
    @DeleteMapping
    public ResponseEntity<T> delete(@RequestBody T object) {
        System.out.println(new Date() + " Called DELETE.");
        return new ResponseEntity<>(getGenericService().save(object), HttpStatus.OK);
    }
}
