public class Comment {
    private String id;
    private String user;
    private String mensagem;

    public Comment(String id, String mensagem) {
        this.id = id;
        this.mensagem = mensagem;
    }

    public void setUser(String user) {
        this.user = user;
    }


    public String getId() {
        return id;
    }
    public String getUser() {
        return user;
    }
    public String getMensagem() {
        return mensagem;
    }

}
