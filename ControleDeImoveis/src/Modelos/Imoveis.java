/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.util.Scanner;

/**
 *
 * @author Aluno
 */
public class Imoveis {

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Variaveis
    private int id;
    private String nome;
    private String endereco;
    private double preco;

    public void pedeDados() {
        Scanner ler = new Scanner(System.in);
        System.out.println("qual o nome do imovel?");
        nome = ler.next();
        System.out.println("qual o endereço?");
        endereco = ler.next();
        System.out.println("qual o preço do imovel?");
        preco = ler.nextDouble();

    }

}
