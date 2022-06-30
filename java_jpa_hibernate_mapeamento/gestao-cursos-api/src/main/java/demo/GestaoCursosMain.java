package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class GestaoCursosMain {
    public static void main (String[] args) throws ParseException {
        AlunoModel alunoModel = new AlunoModel();
        CursoModel cursoModel = new CursoModel();


        Aluno aluno1 = new Aluno();
        Telefone telefoneAluno1 = new Telefone("35", "99987-2682");
        Endereco enderecoAluno1 = new Endereco("Rua", "Bernadino Macieira", "144", "Centro", "Lavras", "MG", 37200200);

        Aluno aluno2 = new Aluno();
        Telefone telefoneAluno2 = new Telefone("35", "99966-2725");
        Endereco enderecoAluno2 = new Endereco("Rua", "Bernadino Macieira", "144", "Centro", "Lavras", "MG", 37200200);

        Aluno aluno3 = new Aluno();
        Telefone telefoneAluno3 = new Telefone("35", "99987-2682");
        Endereco enderecoAluno3 = new Endereco("Rua", "Bernadino Macieira", "144", "Centro", "Lavras", "MG", 37200200);

        aluno1.setNomeCompleto("Cesar Augusto Pires");
        aluno1.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("04/02/1999"));
        aluno1.setMatricula("201910560");
        aluno1.setEmail("cesarp@ciandt.com");
        aluno1.setTelefone(List.of(telefoneAluno1));
        aluno1.setEndereco(List.of(enderecoAluno1));

        aluno2.setNomeCompleto("Alice Lopes");
        aluno2.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("26/06/1999"));
        aluno2.setMatricula("201910500");
        aluno2.setEmail("alicelopes@vidaveg.com");
        aluno2.setTelefone(List.of(telefoneAluno2));
        aluno2.setEndereco(List.of(enderecoAluno2));

        aluno3.setNomeCompleto("Meg Rodrigues Pires");
        aluno3.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("25/03/2022"));
        aluno3.setMatricula("201910560");
        aluno3.setEmail("megrodriguespires@estudante.com");
        aluno3.setTelefone(List.of(telefoneAluno3));
        aluno3.setEndereco(List.of(enderecoAluno3));

        alunoModel.create(aluno1);
        alunoModel.create(aluno2);
        alunoModel.create(aluno3);

        System.out.println(alunoModel.findById(2L));

        aluno2.setNomeCompleto("Alice Lopes Rodrigues");
        alunoModel.update(aluno2);

        System.out.println(alunoModel.findById(2L));

        List<Aluno> alunos = alunoModel.findAll();
        System.out.println("Alunos cadastrados no sistema: " + alunos.size());

        alunoModel.delete(aluno3);

        alunos = alunoModel.findAll();
        System.out.println("Alunos cadastrados no sistema: " + alunos.size());

        alunoModel.create(aluno3);

        System.out.println(alunoModel.findById(1L));
        System.out.println(alunoModel.findById(2L));
        System.out.println(alunoModel.findById(3L));

        Professor professor1 = new Professor();
        professor1.setNomeCompleto("Bruno Sanchez");
        professor1.setMatricula("201420145");
        professor1.setEmail("brunosanchez@hotmail.com");

        MaterialCurso materialCurso1 = new MaterialCurso();
        materialCurso1.setUrl("https://www.google.com");

        Curso curso1 = new Curso();
        curso1.setNome("Introdução aos Algoritmos");
        curso1.setSigla("GCC107");
        curso1.setProfessor(professor1);
        curso1.setMaterialCurso(materialCurso1);
        curso1.setAlunos(List.of(aluno1, aluno2));

        Professor professor2 = new Professor();
        professor2.setNomeCompleto("LUIZ HENRIQUE DE CAMPOS MERSCHMANN");
        professor2.setMatricula("201174123");
        professor2.setEmail("luiz.henrique@hotmail.com");

        MaterialCurso materialCurso2 = new MaterialCurso();
        materialCurso2.setUrl("https://www.ufla.br");

        Curso curso2 = new Curso();
        curso2.setNome("Apredendo sobre Mineração de Dados");
        curso2.setSigla("GCC147");
        curso2.setProfessor(professor2);
        curso2.setMaterialCurso(materialCurso2);
        curso2.setAlunos(List.of(aluno2));

        cursoModel.create(curso1);
        cursoModel.create(curso2);

        List<Curso> cursos = cursoModel.findAll();
        System.out.println("Cursos cadastrados no sistema: " + cursos.size());
        cursos.forEach(System.out::println);

        curso1.setNome("");
        cursoModel.update(curso1);

        Curso cursoById = cursoModel.findById(1L);
        System.out.println(cursoById);

        cursoModel.delete(curso1);
        cursoModel.findById(1L);
    }
}
