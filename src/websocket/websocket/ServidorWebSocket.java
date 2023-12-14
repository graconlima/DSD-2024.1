package websocket.websocket;

import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.server.ServerEndpoint;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import modelos.Comentario;
@ApplicationScoped
@ServerEndpoint("/acoes")
public class ServidorWebSocket {
    
    @Inject
    private ManipuladorSessao ms;
    
    @OnOpen public void abrir(Session s){
        System.out.println("Adicionando novo usuario");
        ms.adicionarSessao(s);
    }
    @OnClose public void fechar(Session s){ms.removerSessao(s);}
    @OnError public void erro(Throwable t){
        Logger.getLogger(
                ServidorWebSocket.class.getName()
        ).log(Level.SEVERE, null, t);
    }
    @OnMessage public void mensagem(String m, Session s){
        System.out.println("Mensagem: "+m);
        try(JsonReader jr = Json.createReader(new StringReader(m))){
            JsonObject jo = jr.readObject();
            if(jo.getString("acao").equals("adicionar")){
                Comentario c = new Comentario();
                c.setDescricao(jo.getString("descricao"));
                ms.adicionarComentario(c);
            }
        }
    }
}
