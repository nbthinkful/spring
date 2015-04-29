package com.thinkful.spring.dao.impl;

import com.googlecode.genericdao.dao.DAOUtil;
import com.thinkful.spring.dao.CrudDao;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class AbstractCrudDao<TYPE, PK_TYPE> implements CrudDao<TYPE, PK_TYPE> {

    private Class<TYPE> clazz;

    @PersistenceContext
    private EntityManager entityManager;

    protected AbstractCrudDao() {
        clazz = (Class<TYPE>)DAOUtil.getTypeArguments(AbstractCrudDao.class, this.getClass()).get(0);
    }

    @Override
    public TYPE findById(PK_TYPE id) {
        return entityManager.find(clazz, id);
    }

    @Override
    public List<TYPE> findAll() {
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }

    @Override
    public void create(TYPE entity) {
        entityManager.persist(entity);
    }

    @Override
    public TYPE update(TYPE entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void delete(TYPE entity) {
        entityManager.remove(entity);
    }

    @Override
    public void deleteById(PK_TYPE id) {
        delete(findById(id));
    }
}
