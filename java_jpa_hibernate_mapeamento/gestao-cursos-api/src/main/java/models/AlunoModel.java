package models;

import entities.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class AlunoModel {
    public void create(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(aluno);
            em.getTransaction().commit();
            System.out.println("Aluno criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar um aluno !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Aluno findById(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        Aluno aluno = null;

        try {
            System.out.println("Iniciando a transação");
            aluno = em.find(Aluno.class, id);
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao buscar um aluno !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }

        return aluno;
    }

    public List<Aluno> findAll() {
        List<Aluno> alunos = new ArrayList<Aluno>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            alunos = em.createQuery("from Aluno aluno", Aluno.class).getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar todos os alunos!!!" + e.getMessage());
        } finally {
            System.out.println("Finalizando a transação");
        }

        return alunos;
    }

    public void update(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            Aluno alunoAtual = findById(aluno.getId());
            em.getTransaction().begin();
            em.merge(aluno);
            em.getTransaction().commit();
            System.out.println("Aluno atualizado com sucesso!!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao atualizar aluno!!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            Aluno alunoExcluido = findById(aluno.getId());
            em.getTransaction().begin();
            em.remove(alunoExcluido);
            em.getTransaction().commit();
            System.out.println("Aluno removido com sucesso!!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao remover um aluno!!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

}
