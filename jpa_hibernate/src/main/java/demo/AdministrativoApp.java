package demo;

import entities.Pessoa;
import entities.Produto;
import models.PessoaModel;
import models.ProdutoModel;

import java.util.List;

public class AdministrativoApp {

    public static void main(String[] args) {
        ProdutoModel produtoModel = new ProdutoModel();

        Produto p1 = new Produto();
        p1.setNome("TV");
        p1.setPreco(300.0);
        p1.setQuantidade(100);
        p1.setStatus(true);

        Produto p2 = new Produto();
        p2.setNome("Fogão");
        p2.setPreco(550.0);
        p2.setQuantidade(200);
        p2.setStatus(true);


        // 1) Criando um produto
        produtoModel.create(p1);

        //2) Buscando todos os produtos na base de dados
        List<Produto> produtos = produtoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + produtos.size());

        //3) Criando um produto
        produtoModel.create(p2);

        //4) Buscando todos os produtos na base de dados
        produtos = produtoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + produtos.size());

        //5) Alterando produto
        p2.setNome("Geladeira");
        produtoModel.update(p2);

        //4) Buscando todos os produtos na base de dados
        produtos = produtoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + produtos.size());

        Produto produtoBuscado = produtoModel.findById(p2);
        System.out.println("=================Produto Buscado=================");
        System.out.println("ID: " + produtoBuscado.getId());
        System.out.println("Nome: " + produtoBuscado.getNome());
        System.out.println("Preco: " + produtoBuscado.getPreco());
        System.out.println("Quantidade: " + produtoBuscado.getQuantidade());
        System.out.println("=================================================");

        //6) Removendo o produto 2
        produtoModel.delete(p2);

        //7) Buscando todos os produtos na base de dados
        produtos = produtoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + produtos.size());

        System.out.println("==============================================================================================");

        PessoaModel pessoaModel = new PessoaModel();

        Pessoa pe1 = new Pessoa();
        pe1.setNome("TVPessoa");
        pe1.setIdade(18);
        pe1.setEmail("tepessoa@hotmail.com");

        Pessoa pe2 = new Pessoa();
        pe2.setNome("fogaoPessoa");
        pe2.setIdade(35);
        pe2.setEmail("fogao@gemail.com");


        // 1) Criando uma pessoa
        pessoaModel.create(pe1);

        //2) Buscando todos as pessoas na base de dados
        List<Pessoa> pessoas = pessoaModel.findAll();
        System.out.println("Qtde de  pessoas encontradas : " + pessoas.size());

        //3) Criando uma pessoa
        pessoaModel.create(pe2);

        //4) Buscando todos as pessoas na base de dados
        pessoas = pessoaModel.findAll();
        System.out.println("Qtde de pessoas encontradas : " + pessoas.size());

        //5) Alterando pessoa
        p2.setNome("geladeiraPessoa");
        pessoaModel.update(pe2);

        //4) Buscando todos as pessoas na base de dados
        pessoas = pessoaModel.findAll();
        System.out.println("Qtde de pessoas encontradas: " + pessoas.size());

        Pessoa pessoaBuscada = pessoaModel.findById(pe2);
        System.out.println("=================Pessoa Buscada=================");
        System.out.println("ID: " + pessoaBuscada.getId());
        System.out.println("Nome: " + pessoaBuscada.getNome());
        System.out.println("Email: " + pessoaBuscada.getEmail());
        System.out.println("=================================================");

        //6) Removendo a pessoa 2
        pessoaModel.delete(pe2);

        //7) Buscando todas as pessoas na base de dados
        pessoas = pessoaModel.findAll();
        System.out.println("Qtde de pessoas encontradas : " + pessoas.size());

    }
}
