package Models;

public class Models_Menbros {

    private long codigo;
    private String nome;
    private String telefone;
    private String status;
    private String imagem;
    private byte[] img_arq;

    public Models_Menbros(long codigo, String nome, String telefone, String status, String imagem, byte[] img_arq) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.status = status;
        this.imagem = imagem;
        this.img_arq = img_arq;
    }

    public Models_Menbros() {
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public byte[] getImg_arq() {
        return img_arq;
    }

    public void setImg_arq(byte[] img_arq) {
        this.img_arq = img_arq;
    }

}
