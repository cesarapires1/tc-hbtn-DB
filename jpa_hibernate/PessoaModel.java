package models;

import entities.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class PessoaModel {
    public void create(Pessoa pessoa) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(pessoa);
            em.getTransaction().commit();
            System.out.println("Pessoa criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar o pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Pessoa pessoaNovo) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            Pessoa pessoa = em.find(entities.Pessoa.class, pessoaNovo.getId());
            em.merge(pessoa);
            em.getTransaction().commit();
            System.out.println("Pessoa: " + pessoa.toString() + " atualizado com sucesso!!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao alterar pessoa!!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Pessoa pessoa) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            Pessoa pessoaRemovido = em.find(entities.Pessoa.class, pessoa.getId());
            em.getTransaction().begin();
            em.remove(pessoaRemovido);
            em.getTransaction().commit();
            System.out.println("Pessoa: " + pessoa.toString() + " removido com sucesso!!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao remover pessoa!!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Pessoa findById(Pessoa pessoaBuscado) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        Pessoa pessoa = null;

        try {
            System.out.println("Iniciando a transação");
            pessoa = em.find(Pessoa.class, pessoaBuscado.getId());
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao obter pessoa por id!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
        return pessoa;
    }

    public List<Pessoa> findAll() {
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            pessoas = em.createQuery("from Pessoa pessoa", Pessoa.class).getResultList();
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao buscar todos os pessoas!!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
        return pessoas;
    }
}
