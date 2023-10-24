package view;

import javax.swing.JOptionPane;

import controller.Musica;
import controller.PlayerController;
import model.ListaEncadeadaSimples_TipoGenerico;

public class Principal {

	public static void main(String[] args) throws Exception {
		PlayerController player = new PlayerController();
		ListaEncadeadaSimples_TipoGenerico<Musica> playlist = new ListaEncadeadaSimples_TipoGenerico<>();
		
		int opc = Integer.parseInt(
				JOptionPane.showInputDialog(null, 
				"1 - Inserir Música na Playlist\n"+
				"2 - Remover Música da Playlist\n"+
				"3 - Tocar Playlist\n"+
				"9 - Sair do Vitufy",
				"Insira a Opção desejada", -1)
				);
		while(opc != 9) {
			
			switch(opc) {
				case 1:
					String musica = JOptionPane.showInputDialog("Insira a musica no formato: Nome_da_musica;nome_artista;duracao");
					player.adicionaMusica(playlist, musica);
					break;
					
				case 2:
					if(!playlist.isEmpty()) {
						int posicao = Integer.parseInt(JOptionPane.showInputDialog("Insira a Posição da Música que deseja excluir"));
						player.removeMusica(playlist, posicao);
						break;
					}else {
						throw new Exception("A Playlist está Vazia");
					}
					
				case 3:
					if(!playlist.isEmpty()) {
						player.executaPlayist(playlist);
					}else {
						throw new Exception("A Playlist está Vazia");
					}
					break;
					
				case 9:
					break;
					
				default:
					JOptionPane.showConfirmDialog(null, "Por Favor Insira Uma Opção Válida", "Opção Inválida", -1);
					break;
			}
			/*↓↓↓ Mesmo Menu ↓↓↓*/
			opc = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Inserir Música na Playlist\n"+"2 - Remover Música da Playlist\n"+"3 - Tocar Playlist\n"+"9 - Sair do Vitufy","Insira a Opção desejada", -1));
		}
		JOptionPane.showConfirmDialog(null, "Obrigado Por escolher nosso App", "Vitufy Agradece", -1);
	}

}
