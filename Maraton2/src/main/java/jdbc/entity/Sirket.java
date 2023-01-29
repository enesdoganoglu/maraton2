package jdbc.entity;

public class Sirket {

    private Integer id;
    private String sirket_ismi;
    private String sirket_unvani;
    private String sirket_sahibi;
    private String faaliyet_alani;
    private Integer kurulus_yili;



    public Sirket(Integer id, String sirket_ismi, String sirket_unvani, String sirket_sahibi, String faaliyet_alani, Integer kurulus_yili) {
        this.id = id;
        this.sirket_ismi = sirket_ismi;
        this.sirket_unvani = sirket_unvani;
        this.sirket_sahibi = sirket_sahibi;
        this.faaliyet_alani = faaliyet_alani;
        this.kurulus_yili = kurulus_yili;
    }

    public Sirket(String sirket_ismi, String sirket_unvani, String sirket_sahibi, String faaliyet_alani, Integer kurulus_yili) {
        this.sirket_ismi = sirket_ismi;
        this.sirket_unvani = sirket_unvani;
        this.sirket_sahibi = sirket_sahibi;
        this.faaliyet_alani = faaliyet_alani;
        this.kurulus_yili = kurulus_yili;
    }

    public Sirket(Integer id) {
        this.id = id;
    }

    public Sirket(Integer id, String sirket_ismi) {
        this.id = id;
        this.sirket_ismi = sirket_ismi;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSirket_ismi() {
        return sirket_ismi;
    }

    public void setSirket_ismi(String sirket_ismi) {
        this.sirket_ismi = sirket_ismi;
    }

    public String getSirket_unvani() {
        return sirket_unvani;
    }

    public void setSirket_unvani(String sirket_unvani) {
        this.sirket_unvani = sirket_unvani;
    }

    public String getSirket_sahibi() {
        return sirket_sahibi;
    }

    public void setSirket_sahibi(String sirket_sahibi) {
        this.sirket_sahibi = sirket_sahibi;
    }

    public String getFaaliyet_alani() {
        return faaliyet_alani;
    }

    public void setFaaliyet_alani(String faaliyet_alani) {
        this.faaliyet_alani = faaliyet_alani;
    }

    public Integer getKurulus_yili() {
        return kurulus_yili;
    }

    public void setKurulus_yili(Integer kurulus_yili) {
        this.kurulus_yili = kurulus_yili;
    }

    @Override
    public String toString() {
        return "Sirket{" +
                "id=" + id +
                ", sirket_ismi='" + sirket_ismi + '\'' +
                ", sirket_unvani='" + sirket_unvani + '\'' +
                ", sirket_sahibi='" + sirket_sahibi + '\'' +
                ", faaliyet_alani='" + faaliyet_alani + '\'' +
                ", kurulus_yili=" + kurulus_yili +
                '}';
    }
}

