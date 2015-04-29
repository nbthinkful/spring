package com.thinkful.spring.dao;


import java.util.List;

public interface CrudDao<TYPE,PK_TYPE> {

    TYPE findById(PK_TYPE id);

    List<TYPE> findAll();

    void create(TYPE entity);

    TYPE update(TYPE entity);

    void delete(TYPE entity);

    void deleteById(PK_TYPE id);
}
