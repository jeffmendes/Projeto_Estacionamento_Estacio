/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegraDeNegocio;

import DAOs.DAOEntrada;

/**
 *
 * @author Eduardo
 */
public class TesteDAO {
    public static void main(String[] args) {
        System.out.println("******************TESTANDO DAO******************");
        DAOEntrada entrada = new DAOEntrada();
        entrada.entradaDeVeiculo();
        System.out.println("******************FIM TESTE DAO*****************");
    }
}
