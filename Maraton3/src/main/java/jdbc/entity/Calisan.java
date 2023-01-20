package jdbc.entity;

public class Calisan {
    private Integer id;
    private Sirket sirket;
    private String isim;
    private Integer yas;
    private Integer maas;
    private String departman;

    public Calisan(Integer id, Sirket sirket, String isim, Integer yas, Integer maas, String departman) {
        this.id = id;
        this.sirket = sirket;
        this.isim = isim;
        this.yas = yas;
        this.maas = maas;
        this.departman = departman;
    }

    public Calisan(Sirket sirket, String isim, Integer yas, Integer maas, String departman) {
        this.sirket = sirket;
        this.isim = isim;
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

    public Sirket getSirket() {
        return sirket;
    }

    public void setSirket(Sirket sirket) {
        this.sirket = sirket;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
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
                ", sirket=" + sirket +
                ", isim='" + isim + '\'' +
                ", yas=" + yas +
                ", maas=" + maas +
                ", departman='" + departman + '\'' +
                '}';
    }
}
