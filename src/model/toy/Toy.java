package model.toy;

import java.io.Serializable;
import java.util.Objects;

public class Toy implements Serializable, Comparable<Toy>  {
    private int id;
    private String nameToy;
    private int countToy;
    private int toyDropRate;


    public Toy(int id, String nameToy, int count, int toyDropRate) {
        this.id = id;
        this.nameToy = nameToy;
        this.countToy = count;
        this.toyDropRate = toyDropRate;
    }
    public Toy(String nameToy) {
        this.id = 0;
        this.nameToy = nameToy;
        this.countToy = 0;
        this.toyDropRate = 0;
    }

    public int getId() {
        return id;
    }

    public String getNameToy() {
        return nameToy;
    }

    public int getCountToy() {
        return countToy;
    }

    public int getToyDropRate() {
        return toyDropRate;
    }

    public void setNameToy(String nameToy) {
        this.nameToy = nameToy;
    }

    public void setCountToy(int countToy) {

        this.countToy = countToy;
    }

    public void setToyDropRate(int toyDropRate) {
        if ((toyDropRate>0) && (toyDropRate<=100)) {
            this.toyDropRate = toyDropRate;
        }
    }

    public String getInfo(){
//        var formatter = DateTimeFormatter.ISO_LOCAL_DATE;

        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", ");
        sb.append(nameToy);
        sb.append(" ");
        sb.append(toyDropRate);
        sb.append("\n");

        return sb.toString();
    }
    @Override
    public String toString() {
        return getInfo();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Toy)) {
            return false;
        }
         Toy toy = (Toy) object;
        return nameToy.equals(toy.nameToy);
    }



    @Override
    public int hashCode() {
        return Objects.hash(nameToy);
    }

    @Override
    public int compareTo(Toy toy) {
        return getNameToy().compareTo(toy.getNameToy()) ;
    }

    public enum Gender {
        Mail, Fimale
    }
}
