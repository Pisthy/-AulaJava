package poo.dao;

import org.hibernate.query.Query;

import poo.model.Pessoa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PessoaDAO {

    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration().configure();
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void close() {
        sessionFactory.close();
    }

    public void salvarPessoa(Pessoa pessoa) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(pessoa);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Pessoa getPessoaByCPF(String cpf) {
        try (Session session = sessionFactory.openSession()) {
            Query<Pessoa> query = session.createQuery("FROM Pessoa WHERE cpf = :cpf", Pessoa.class);
            query.setParameter("cpf", cpf);
            return query.uniqueResult();
        }
    }

    public void atualizarPessoa(Pessoa pessoa) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(pessoa);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deletarPessoaByCPF(String cpf) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            Query<Pessoa> query = session.createQuery("FROM Pessoa WHERE cpf = :cpf", Pessoa.class);
            query.setParameter("cpf", cpf);
            Pessoa pessoa = query.uniqueResult();
            if (pessoa != null) {
                transaction = session.beginTransaction();
                session.delete(pessoa);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
