package com.querydslexample.repository;

import com.querydslexample.model.GenericEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * This class is created to make a generic com.qbcentral.repository entity for the entire system.
 *
 * @author Alfredo Marin
 * @version ALPHA-0.0.1
 * @since 12/10/2019
 */

@NoRepositoryBean
public interface GenericRepository<T extends GenericEntity>
        extends JpaRepository<T, Long>, PagingAndSortingRepository<T, Long>, QuerydslPredicateExecutor<T> {
}
