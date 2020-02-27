package com.company.repository;

import com.company.model.Alien;
import com.company.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class AlienRepo {
    private final Session _session = HibernateUtil.openSession();
    private List<Alien> aliens = new ArrayList<Alien>();

    public AlienRepo() {
    }

    public List<Alien> getAliens() {
        Query query = _session.createQuery("from Alien");
        query.setCacheable(true);
        this.aliens = query.list();
        return this.aliens;
    }

    public Alien getById(Integer alienId) {
        // Parametre geçilerek çalıştırılan HQL sorgusu
        /*Query query = _session.createQuery("from Alien  where id= :alienId").setParameter("alienId", alienId);
        Alien alien = (Alien) query.uniqueResult();
        return alien;*/
        return _session.get(Alien.class, alienId);
    }

    public void insert(Alien alien) {
        Transaction transaction = _session.beginTransaction();
        _session.save(alien);
        transaction.commit();
    }

    public void update(Alien alien) {
        Transaction transaction = _session.beginTransaction();
        _session.update(alien);
        transaction.commit();
    }

    public void delete(Integer id) {
        Alien alien = getById(id);
        Transaction transaction = _session.beginTransaction();
        _session.delete(alien);
        transaction.commit();
    }

    public void delete(Alien alien) {
        Transaction transaction = _session.beginTransaction();
        _session.delete(alien);
        transaction.commit();
    }
}
