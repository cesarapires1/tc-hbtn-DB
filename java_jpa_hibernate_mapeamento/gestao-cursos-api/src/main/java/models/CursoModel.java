package models;

import entities.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class CursoModel {
    public void create(Curso curso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();
            System.out.println("Curso criado com sucesso!!!");
        } catch (Exception e) {
            System.err.println("Erro ao criar um curso!!!" + e.getMessage());
        } finally {
            em.close();
            emf.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Curso findById(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        Curso curso = null;

        try {
            System.out.println("Iniciando a transação");
            curso = em.find(Curso.class, id);
        } catch (Exception e) {
            System.err.println("Erro ao buscar o curso !!!" + e.getMessage());
        } finally {
            em.close();
            emf.close();
            System.out.println("Finalizando a transação");

        }
        return null;
    }

    public List<Curso> findAll() {
        List<Curso> cursos = new ArrayList<Curso>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            cursos = em.createQuery("from Curso curso", Curso.class).getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar cursos!!!" + e.getMessage());
        } finally {
            System.out.println("Finalizando a transação");
        }

        return cursos;
    }

    public void update(Curso curso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            Curso cursoAtual = findById(curso.getId());
            em.merge(curso);
            em.getTransaction().commit();
            System.out.println("Curso atualizado com sucesso!!!");
        } catch (Exception e) {
            System.err.println("Erro ao atualizar o curso!!!" + e.getMessage());
        } finally {
            em.close();
            emf.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Curso curso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            Curso cursoExcluido = em.find(Curso.class, curso.getId());
            em.getTransaction().begin();
            em.remove(cursoExcluido);
            em.getTransaction().commit();
            System.out.println("Curso removido com sucesso!!!");
        } catch (Exception e) {
            System.err.println("Erro ao deletar o curso!!!" + e.getMessage());
        } finally {
            em.close();
            emf.close();
            System.out.println("Finalizando a transação");
        }
    }
}
