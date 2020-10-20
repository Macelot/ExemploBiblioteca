/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exemplobiblioteca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author marce
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File file = new File("livros.txt");
        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader bf = new BufferedReader(isr);
            String linha;
            linha=bf.readLine();
            Livro[] livros;
            Livro livro=new Livro();
            livros = new Livro[livro.contaLinhas(file)];
            int linhas=0;
            while(true){
                linha=bf.readLine();
                if(linha==null)
                    break;
                String[] dados=linha.split(";");
                livro=new Livro();
                livro.setId(Integer.parseInt(dados[0]));
                livro.setTitulo(dados[1]);
                livro.setAutor(dados[2]);
                livros[linhas]=livro;
                linhas++;
            }
            bf.close();
            
            Scanner teclado;
            teclado = new Scanner(System.in);
            int opcao=0;
            
            for(;;){
                System.out.println("Escolha uma opção");
                System.out.println("1 - Listar livros");
                System.out.println("2 - Listar livros por ordem de Titulo");
                System.out.println("3 - Listar livros por ordem de Autor");
                System.out.println("4 - Buscar livros ");
                System.out.println("9 - Sair");
                opcao = teclado.nextInt();
                
                switch(opcao){
                    case 1: 
                        livro.lista(livros);
                        break;
                    case 2:
                        livro.listaOrdenado(livros); 
                        break;
                    case 3:
                        livro.listaOrdenadoAutor(livros); 
                        break; 
                    case 4:
                        livro.buscar(livros); 
                        break;     
                    case 9:
                        System.out.println("FIM");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Escolha outra opção");    
                }
                
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
}
