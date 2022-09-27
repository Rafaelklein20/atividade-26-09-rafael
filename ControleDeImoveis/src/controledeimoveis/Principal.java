/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controledeimoveis;

import Modelos.ImovNovo;
import Modelos.ImovUsado;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Aluno
 */
public class Principal {

    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Connection connection = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String serverName = "127.0.0.1:3306";
            String mydatabase = "controleimoveis";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase + "?usetTimezone=true&serverTimezone=UTC";
            String username = "root";
            String password = "";

            connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                System.out.println("Status--->Conectado com sucesso!");
            } else {
                System.out.println("Status--->Não foi possivel realizar a conexão");
            }

            int x = 0;
            System.out.println("oque voce gostaria de fazer ?");
            System.out.println("1 imoveis novos, 2 imoveis usados, 9 sair ?");
            Scanner ler2 = new Scanner(System.in);
            x = ler2.nextInt();
            while (x != 9) {

//switch
                switch (x) {
                    //case1
                    case 1:
                        ImovNovo Inovo = new ImovNovo();
                        //pedindo dados
                        Inovo.pedeDados();
                        //mostrando dados
                        System.out.println("os dados inseridos foram");
                        System.out.println("nome" + Inovo.getNome() + "endereço" + Inovo.getEndereco() + "preco" + Inovo.getPreco());
                        System.out.println("o preço Final do imovel será");
                        System.out.println(Inovo.getPrecoFinal());
                        //insert
                        String sql = "INSERT INTO imoveis (nome, endereco, preco ) VALUES (?,?,?)";
                        PreparedStatement ps = connection.prepareStatement(sql);
                        ps.setString(1, Inovo.getNome());
                        ps.setString(2, Inovo.getEndereco());
                        ps.setDouble(3, Inovo.getPrecoFinal());
                        //verificação
                        boolean Insert = ps.execute();
                        if (Insert) {
                            System.out.println("erro ao inserir");
                        } else {
                            System.out.println("Inserido com sucesso");
                        }
                        break;

                    //case2
                    case 2:
                        ImovUsado Iusado = new ImovUsado();
                        //pedindo dados
                        Iusado.pedeDados();
                        //mostrando dados
                        System.out.println("os dados inseridos foram");
                        System.out.println("nome" + Iusado.getNome() + "endereço" + Iusado.getEndereco() + "preco" + Iusado.getPreco());
                        System.out.println("o preço Final do imovel será");
                        System.out.println(Iusado.getPrecoFinal());
                        //insert
                        String sql2 = "INSERT INTO imoveis (nome, endereco, preco ) VALUES (?,?,?)";
                        PreparedStatement ps2 = connection.prepareStatement(sql2);
                        ps2.setString(1, Iusado.getNome());
                        ps2.setString(2, Iusado.getEndereco());
                        ps2.setDouble(3, Iusado.getPrecoFinal());
                        //verificação
                        boolean Insert2 = ps2.execute();
                        if (Insert2) {
                            System.out.println("erro ao inserir");
                        } else {
                            System.out.println("Inserido com sucesso");
                        }
                        break;

                }

                System.out.println("oque voce gostaria de fazer ?");
                System.out.println("1 imoveis novos, 2 imoveis usados, 9 sair ?");
                x = ler2.nextInt();

            }
            //select
            String sql = "Select * from imoveis ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id2 = rs.getInt("id");
                String nome2 = rs.getString("nome");
                String endereco2 = rs.getString("endereco");
                Double preco = rs.getDouble("preco");
                System.out.printf("id %d; %s - %s  %s  \n", id2, nome2, endereco2, preco);
            }
            //parte do update /
            System.out.println("Mudando o preco do id 1 para 15000");
            String sqlU = "UPDATE imoveis SET  preco = 15000 WHERE (id = 1)";
            PreparedStatement ps3 = connection.prepareStatement(sqlU);
            ps3.executeUpdate();

            //parte do delete
            System.out.println("Deletando o id 3");
            String sqlD = "DELETE FROM imoveis WHERE (id = 3)";
            PreparedStatement psD = connection.prepareStatement(sqlD);
            boolean Delete = psD.execute();
            if (Delete) {
                System.out.println("erro ao deletar");
            } else {
                System.out.println("deletado com sucesso com sucesso");
            }

        } catch (ClassNotFoundException e) { // driver não encontrado
            System.out.println("O driver expecificado não foi encontrado");
        } catch (SQLException e) {
            //não conseguindo se conectar ao banco
            System.out.println("não foi possivel conectar ao Banco de Dados. " + e.getMessage());

        } finally {
            connection.close();
        }

    }

}
