package com.api.redesocial.service.mensagem;

import com.api.redesocial.entity.amigos.Amizade;
import com.api.redesocial.entity.mensagem.Mensagem;
import com.api.redesocial.entity.usuario.Perfil;
import com.api.redesocial.repository.AmizadeRepository;
import com.api.redesocial.repository.MensagemRepository;
import com.api.redesocial.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class MensagemService {

    @Autowired
    private PerfilRepository perfilRepository;
    @Autowired
    private AmizadeRepository amizadeRepository;
    @Autowired
    private MensagemRepository mensagemRepository;

    public void enviarMensagem(UUID remetenteId, UUID destinatarioId, String conteudo, String emogi,
                               LocalDateTime dataEnvio, Boolean lida){

        Perfil remetente = perfilRepository.findById(remetenteId).orElse(null);
        Perfil destinatario = perfilRepository.findById(destinatarioId).orElse(null);

        Amizade amizade = amizadeRepository.findByRemetenteAndDestinatario(remetente, destinatario);

        if(amizade != null && amizade.isSomosAmigos()){
            Mensagem novaMensagem = new Mensagem();
            novaMensagem.setRemetente(remetente);
            novaMensagem.setDestinatario(destinatario);
            novaMensagem.setConteudo(conteudo);
            novaMensagem.setEmogi(emogi);
            novaMensagem.setDataEnvio(dataEnvio);
            novaMensagem.setLida(lida);

            mensagemRepository.save(novaMensagem);

        }
    }

    public List<Mensagem> obterMensagens(UUID remetenteId, UUID destinatarioId) {
        // Obtenha as mensagens entre o remetente e o destinatário
        // Se nao conseguir recuperar as mensagens tente trocar de UUID para Perfil
        // em MensagemRepository, fiquei em duvida do correto.
        List<Mensagem> mensagens = mensagemRepository.findByRemetenteIdAndDestinatarioIdOrderByDataEnvio(remetenteId, destinatarioId);

        // Atualize o status de leitura das mensagens para lido
        for (Mensagem mensagem : mensagens) {
            if (!mensagem.isLida()) {
                mensagem.setLida(true);
                mensagemRepository.save(mensagem);
            }
        }

        return mensagens;
    }

}
