import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {

    private List<User> user_a = new ArrayList<User>();

    public void addUser(User user) {

        if (!(verificaUserUni(user.getUser()))) {
            user_a.add(user);
        } else {
            System.out.println("Usuario Existente");
        }
    }


    public void addFriendly(String u1, String u2) {
        
        int cont = 0;
        User user_t1 = null, user_t2 = null;
        if (u1 != u2) {

            for (User u : user_a) {

                if (u.getUser() == u1) {
                    user_t1 = u;
                    cont += 1;
                }

                if (u.getUser() == u2) {
                    user_t2 = u;
                    cont += 1;
                }

                if (cont == 2) {
                    break;
                }
            }
        }

        if ((user_t1 != null) && (user_t2 != null)) {
            user_t1.setAmigos(user_t2);
        }

    }

    public void getFriendly(String u1) {

        for (User u : user_a) {

            if (u.getUser() == u1) {
                System.out.print("Amigos de "+u1+": ");
                u.getAmigos();
                System.out.println("\n\n");
            }
        }

    }

    public void addPost(String u1 , Post p){
        for (User u : user_a) {
            if (u.getUser() == u1) {
               u.setPosts(p);
               break;
            }
        }
    }

  
    public void printPostComment(){

        for (User u : user_a) {

            System.out.println("Posts de "+u.getNome()+": ");
            u.getPosts();
            System.out.println("\n\n");

        }

    }


    public void addComment(String u1 , String u2, String p, Comment c){
        int cont = 0;
        User user_t1 = null, user_t2 = null;
  
            for (User u : user_a) {

                if (u.getUser() == u1) {
                    user_t1 = u;
                    cont += 1;
                }

                if (u.getUser() == u2) {
                    user_t2 = u;
                    cont += 1;
                }

                if (cont == 2) {
                    break;
                }
            
        }

        if ((user_t1 != null) && (user_t2 != null)) {
            c.setUser(u1);
            user_t2.setCommentPosts(p, c);
        }
    }

    private boolean verificaUserUni(String u_r) {

        boolean ret = false;

        for (User u : user_a) {

            if (u.getUser() == u_r) {
                ret = true;
            }
        }

        return ret;

    }

    
    public void liked(String u1, String u2,String p) {
        
        int cont = 0;
        User user_t1 = null, user_t2 = null;
        if (u1 != u2) {

            for (User u : user_a) {

                if (u.getUser() == u1) {
                    user_t1 = u;
                    cont += 1;
                }

                if (u.getUser() == u2) {
                    user_t2 = u;
                    cont += 1;
                }

                if (cont == 2) {
                    break;
                }
            }
        }

        if ((user_t1 != null) && (user_t2 != null)) {
            user_t1.setLikePosts(p,user_t2);
        }

    }


}
