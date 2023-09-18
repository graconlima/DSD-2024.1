package arcoeflecha;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class Tela extends JComponent{
    
    Flecha tentativa = new Flecha("nome:10:10");
    int TAM = 10, alvo = 0, area = 3;

    public Tela(){
        alvo = (int) (Math.random()*area)+1;
    }
    
    public Flecha getTentativa() {
        return tentativa;
    }

    public void setTentativa(Flecha tentativa) {
        this.tentativa = tentativa;
    }

    @Override
    protected void paintComponent(Graphics g) {

        g.setColor(Color.red);
        g.drawString("Acerte Aqui", alvo/2, alvo+TAM);
        g.fillOval(alvo, alvo+TAM, TAM*3, TAM*3);
        
        g.setColor(Color.black);
        g.drawString(tentativa.getNome(), tentativa.getX()-(tentativa.getX()/2), tentativa.getY());
        g.fillOval(tentativa.getX(), tentativa.getY(), TAM, TAM);
        
        if((tentativa.getX() >= alvo) && (tentativa.getY()+TAM <= alvo+TAM)){
            g.setColor(Color.darkGray);
            g.drawString("PARABENS: "+tentativa.getNome()+", Vc acertou", 0, TAM*10);
            System.out.println("Acertou");
        }
    }
    
    
}
