import java.util.ArrayList;
import java.util.List;

public class Post {

    private String id;
    private String mensagem;
    private List<Comment> coments = new ArrayList<Comment>();

    private List<User> user_a = new ArrayList<User>();


    public Post(String id, String mensagem) {
        this.id = id;
        this.mensagem = mensagem;
    }

    public String getId() {
        return id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void getComents() {//void só por motivo de teste
        for (Comment c : coments) {
            System.out.print("\n\tID: "+c.getId()+"\n\tUser: "+c.getUser()+"\n\tMensagem: "+c.getMensagem());
        }
    }

    public void setComents(Comment coments) {
        this.coments.add(coments);
    }

    
    public void setLik(User u) {
        this.user_a.add(u);
    }

    
}
