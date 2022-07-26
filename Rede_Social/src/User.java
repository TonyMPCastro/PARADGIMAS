import java.util.ArrayList;
import java.util.List;

public class User {

    private String user;
    private String nome;
    private List<Post> posts = new ArrayList<Post>();
    private List<User> amigos = new ArrayList<User>();

    public User(String u, String n) {
        this.user = u;
        nome = n;
    }


    public String getNome() {
        return nome;
    }


    public void getPosts() {//void só por motivo de teste
        for (Post p : posts) {
            System.out.print("\n"+p.getId()+": "+p.getMensagem());
            System.out.println("\n\nComentarios: ");
            p.getComents();
        }
    }

    public void setPosts(Post post) {
        this.posts.add(post);
    }


    public void setCommentPosts(String p_u, Comment c) {
        for (Post p : posts) {
            if (p.getId() == p_u) {
               p.setComents(c);
            }
        }
    }

    public void setAmigos(User amigo) {
        this.amigos.add(amigo);
    }

    public void getAmigos() {//void só por motivo de teste
        for (User u : amigos) {
            System.out.print(" "+u.getUser());
        }
    }

    public String getUser() {
        return user;
    }

  
    public void setLikePosts(String p_u, User c) {
        for (Post p : posts) {
            if (p.getId() == p_u) {
               p.setLik(c);
            }
        }
    }


}
