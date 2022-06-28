package models;

import entities.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class ProdutoModel {

    public void create(Produto produto) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(produto);
            em.getTransaction().commit();
            System.out.println("Produto criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Produto produtoNovo) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            Produto produto = em.find(entities.Produto.class, produtoNovo.getId());
            em.merge(produto);
            em.getTransaction().commit();
            System.out.println("Produto: " + produto.toString() + " atualizado com sucesso!!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao alterar produto!!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Produto produto) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            Produto produtoRemovido = em.find(entities.Produto.class, produto.getId());
            em.getTransaction().begin();
            em.remove(produtoRemovido);
            em.getTransaction().commit();
            System.out.println("Produto: " + produto.toString() + " removido com sucesso!!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao remover produto!!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Produto findById(Produto produtoBuscado) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        Produto produto = null;

        try {
            System.out.println("Iniciando a transação");
            produto = em.find(Produto.class, produtoBuscado.getId());
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao obter produto por id!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
        return produto;
    }

    public List<Produto> findAll() {
        List<Produto> produtos = new ArrayList<Produto>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            produtos = em.createQuery("from Produto produto", Produto.class).getResultList();
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao buscar todos os produtos!!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
        return produtos;
    }
}