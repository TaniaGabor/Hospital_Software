package sample;

public class Pacienti {
    String nume,prenume,stareDeSanatate;

    public Pacienti(String nume, String prenume, String stareDeSanatate)
    {
        this.nume=nume;
        this.prenume=prenume;
        this.stareDeSanatate=stareDeSanatate;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getStareDeSanatate() {
        return stareDeSanatate;
    }

    public void setStareDeSanatate(String stareDeSanatate) {
        this.stareDeSanatate = stareDeSanatate;
    }
}
