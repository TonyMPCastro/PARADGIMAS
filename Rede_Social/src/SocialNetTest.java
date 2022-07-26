
public class SocialNetTest {
    public static void main(String[] args) throws Exception {

    
        SocialNetwork rede = new SocialNetwork ();

        rede.addUser (new User ("u1", "Joao Carlos") );
        rede.addUser (new User ("u2", "Maria Antonia") );
        rede.addUser (new User ("u3", "Emanuel Benedito") );
        rede.addUser (new User ("u4", "Josefina de Almeida") );

        // adiciona uma amizade, dado dois user ids
        rede.addFriendly ("u1", "u2");
        rede.addFriendly ("u1", "u3");
        rede.addFriendly ("u2", "u4");

   rede.getFriendly ("u1");

        
// adiciona um pos relacionado a um usuário
rede.addPost ("u1", new Post ("p1", "Tomando café"));
rede.addPost ("u2",new Post ("p1", "amizade é tudo de bom ") );
rede.addPost ("u2", new Post ("p2", "passeando com meu cachorro"));




// um usuario (u3) adicionado um comentario ao post p3 do usuario u2
rede.addComment ("u3", "u1", "p1",
 new Comment ("c1", "Com pão de queijo? tudo de bão") );


 rede.addComment ("u4", "u2", "p2",
 new Comment ("c2", "Top") );

 rede.liked ("u4", "u2", "p2");
 rede.printPostComment();
       
 }
}
