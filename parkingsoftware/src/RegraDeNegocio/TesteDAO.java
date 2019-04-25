/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegraDeNegocio;

import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo
 */
public class TesteDAO {
    public static Vagas[] estacionamento = new Vagas[10];

    public static void main(String[] args) {
        for(int i =0; i<estacionamento.length;i++){
            estacionamento[i] = new Vagas();
        }
        
        System.out.println("******************TESTANDO******************");
        String [] options = {"Entrada", "Saida"};
        int select = 0;
        JOptionPane.showMessageDialog(null, "Bem vindo ao Parking Fast");
            
        while(select >= 0){
            select = JOptionPane.showOptionDialog(null, "Selecione a função desejada", "ParkingFast", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            Veiculo carro = new Veiculo();
        
            switch(select){
                case 0:
                  EntradaVeiculo entrada = new EntradaVeiculo();
                  carro.setPlaca(JOptionPane.showInputDialog("Placa do Veiculo"));
                  carro.setModelo(JOptionPane.showInputDialog("Modelo do Veiculo"));
            
                  entrada.armazenarCarro(carro, estacionamento);
                  JOptionPane.showMessageDialog(null, "Entrada Registrada");
                break;
                case 1:
                    SaidaVeiculo saida = new SaidaVeiculo();
                    carro.setPlaca(JOptionPane.showInputDialog("Placa do Veiculo"));
                    carro.setModelo(JOptionPane.showInputDialog("Modelo do Veiculo"));
                    
                    
                    JOptionPane.showMessageDialog(null, "Saida Registrada");
                break;
                default:
                    for(Vagas posicao : estacionamento){
                        if(posicao.getVeiculo().getPlaca()!= null){
                            System.out.println("Placa[ " + posicao.getVeiculo().getPlaca() + "]");
                            System.out.println("Modelo[ " + posicao.getVeiculo().getModelo() + "]");
                            System.out.println("HoraEntrada [ " + posicao.getHorarioEntrada() + "]");
                        }
                    }
                    select = -1;
                break;
            }
        }
        System.out.println("******************FIM TESTE*****************");
    }
}
