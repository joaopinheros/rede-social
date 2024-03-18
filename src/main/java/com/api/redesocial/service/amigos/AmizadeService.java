package com.api.redesocial.service.amigos;

import com.api.redesocial.entity.amigos.Amizade;
import com.api.redesocial.entity.usuario.Perfil;
import com.api.redesocial.repository.AmizadeRepository;
import com.api.redesocial.repository.PerfilRepository;
import com.api.redesocial.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AmizadeService {

    @Autowired
    private AmizadeRepository amizadeRepository;
    @Autowired
    private PerfilRepository perfilRepository;

    public void enviarSolicitacaoAmizade(UUID remetenteId, UUID destinatarioId){
        Perfil remetente = perfilRepository.findById(remetenteId).orElse(null);
        Perfil destinatario = perfilRepository.findById(destinatarioId).orElse(null);

        Amizade solicitacao = new Amizade();
        solicitacao.setRemetente(remetente);
        solicitacao.setDestinatario(destinatario);
        solicitacao.setSomosAmigos(false);
        solicitacao.setAceita(false);

        amizadeRepository.save(solicitacao);
    }

    public void aceitarSolicitacao(Long solicitacaoId){
        Amizade solicitacao = amizadeRepository.findById(solicitacaoId).orElse(null);

        //Aceitar Solicitação de Amizade
        if (solicitacao != null && !solicitacao.isSomosAmigos() && !solicitacao.isAceita()) {
            solicitacao.setAceita(true);
            solicitacao.setSomosAmigos(true);
            amizadeRepository.save(solicitacao);

            // Fazer ambos serem amigos
            if(solicitacao.isAceita() && solicitacao.isSomosAmigos()){
                Perfil remetente = solicitacao.getRemetente();
                Perfil destinatario = solicitacao.getDestinatario();

                Amizade novaAmizade = new Amizade();
                novaAmizade.setSomosAmigos(true);
                novaAmizade.setAceita(true);
                novaAmizade.setRemetente(remetente);
                novaAmizade.setDestinatario(destinatario);
                amizadeRepository.save(novaAmizade);

                // Adicionando amigos um ao outro
                remetente.getAmigos().add(novaAmizade);
                destinatario.getAmigos().add(novaAmizade);
            }
        }
    }

    public void rejeitarSolicitacaoDeAmizade(Long solicitacaoId){
        amizadeRepository.deleteById(solicitacaoId);
    }

}
