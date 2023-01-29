package jdbc.entity;

public class Calisan {
    private Integer id;
    private Sirket calisansirket;
    private String calisanisim;
    private Integer yas;
    private Integer maas;
    private String departman;

    public Calisan(Integer id, Sirket calisansirket, String calisanisim, Integer yas, Integer maas, String departman) {
        this.id = id;
        this.calisansirket = calisansirket;
        this.calisanisim = calisanisim;
        this.yas = yas;
        this.maas = maas;
        this.departman = departman;
    }

    public Calisan(Sirket calisansirket, String calisanisim, Integer yas, Integer maas, String departman) {
        this.calisansirket = calisansirket;
        this.calisanisim = calisanisim;
        this.yas = yas;
        this.maas = maas;
        this.departman = departman;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Sirket getCalisansirket() {
        return calisansirket;
    }

    public void setCalisansirket(Sirket calisansirket) {
        this.calisansirket = calisansirket;
    }

    public String getCalisanisim() {
        return calisanisim;
    }

    public void setCalisanisim(String calisanisim) {
        this.calisanisim = calisanisim;
    }

    public Integer getYas() {
        return yas;
    }

    public void setYas(Integer yas) {
        this.yas = yas;
    }

    public Integer getMaas() {
        return maas;
    }

    public void setMaas(Integer maas) {
        this.maas = maas;
    }

    public String getDepartman() {
        return departman;
    }

    public void setDepartman(String departman) {
        this.departman = departman;
    }

    @Override
    public String toString() {
        return "Calisan{" +
                "id=" + id +
                ", calisansirket=" + calisansirket +
                ", calisanisim='" + calisanisim + '\'' +
                ", yas=" + yas +
                ", maas=" + maas +
                ", departman='" + departman + '\'' +
                '}';
    }
}
