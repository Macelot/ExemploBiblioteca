/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exemplobiblioteca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author marce
 */
public class Livro {
    private int id; 
    private String titulo;
    private String autor;
    private String editora;

    public Livro() {
        this.id = 0;
        this.titulo = "";
        this.autor = "";
        this.editora = "";
    }

    public Livro(int id, String titulo, String autor, String editora) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
    
    public int contaLinhas(File file){
        System.out.println("Contando as linhas");
        int total=0;
        try {
            FileReader isr = new FileReader(file);
            BufferedReader bf = new BufferedReader(isr);
            String linha;
            linha=bf.readLine();
            int linhas=0;
            while(true){
                linha=bf.readLine();
                if(linha==null)
                    break;
                linhas++;
            }
            total=linhas;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }
    
    public void lista(Livro[] livros){
        System.out.println("Listando os Livros");
        for (Livro livro : livros) {
            System.out.println("Id......:"+livro.getId());
            System.out.println("Título..:"+livro.getTitulo());
            System.out.println("Autor...:"+livro.getAutor());
            System.out.println("----------------");
        }
    }
    
    public void listaOrdenado(Livro[] livros){
        Livro livroTemp;
        String a1,a2;
        for (int i = 0; i < livros.length; i++) {
            for (int j = 0; j < livros.length-1-i; j++) {
                a1=livros[j].getTitulo().trim();
                a2=livros[j+1].getTitulo().trim();
                if(a1.charAt(0)>a2.charAt(0)){
                    livroTemp=livros[j];
                    livros[j]=livros[j+1];
                    livros[j+1]=livroTemp;
                }
            }
        }
        this.lista(livros);
    }
    
    public void listaOrdenadoAutor(Livro[] livros){
        Livro livroTemp;
        String a1,a2;
        for (int i = 0; i < livros.length; i++) {
            for (int j = 0; j < livros.length-1-i; j++) {
                a1=livros[j].getAutor().trim();
                a2=livros[j+1].getAutor().trim();
                if(a1.charAt(0)>a2.charAt(0)){
                    livroTemp=livros[j];
                    livros[j]=livros[j+1];
                    livros[j+1]=livroTemp;
                }
            }
        }
        this.lista(livros);
    }
    
    public void buscar(Livro[] livros){
        String nome;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o termo desejado");
        nome = teclado.nextLine();
        
        for (Livro livro : livros) {
            if(livro.getTitulo().contains(nome)){
                System.out.println("Id......:"+livro.getId());
                System.out.println("Título..:"+livro.getTitulo());
                System.out.println("Autor...:"+livro.getAutor());
                System.out.println("----------------");
            }
            if(livro.getAutor().contains(nome)){
                System.out.println("Id......:"+livro.getId());
                System.out.println("Título..:"+livro.getTitulo());
                System.out.println("Autor...:"+livro.getAutor());
                System.out.println("----------------");
            }
            
        }
    }
    
    
}
