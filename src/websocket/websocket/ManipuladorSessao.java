package websocket.websocket;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonObject;
import javax.json.spi.JsonProvider;
import javax.websocket.Session;
import modelos.Comentario;

@ApplicationScoped
public class ManipuladorSessao {
    private final LinkedList<Session> sessoes = new LinkedList<Session>();
    private final LinkedList<Comentario> comentarios = new LinkedList<Comentario>();
    
    //manipulacao de sessoes
    public void adicionarSessao(Session s){
        sessoes.add(s);
        for(int i = 0; i < comentarios.size();i++){
            JsonProvider jp  = JsonProvider.provider();
            JsonObject jo = jp.createObjectBuilder().add("acao", "comentarioAdicionado").add("descricao", comentarios.get(i).getDescricao()).build();
            try {
                s.getBasicRemote().sendText(jo.toString());//enivar para todas as seções não ficou bom, enviando apenas para a nova
            } catch (IOException ex) {
                ex.printStackTrace();
            }        
        }

    }
    public void removerSessao(Session s){sessoes.remove(s);}

    //manipulacao dos modelos
    public void adicionarComentario(Comentario c){
        comentarios.add(c);
        
        //enviar para todas as sessoes ativas
        JsonProvider jp = JsonProvider.provider();
        JsonObject jo = jp.createObjectBuilder()
        .add("acao", "comentarioAdicionado")
        .add("descricao", c.getDescricao())
        .build();
        
        for(int i = 0; i < sessoes.size();i++){
            System.out.println("Sessao: "+i+", novo comentario: "+c.getDescricao());
            try {
                sessoes.get(i).getBasicRemote().sendText(jo.toString());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void removerComentario(Comentario c){comentarios.remove(c);}
}
