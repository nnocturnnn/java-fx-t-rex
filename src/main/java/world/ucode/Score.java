package world.ucode;

public class Product {

    public String name;
    public int score;
 
    public Product(String name, int score) {
        this.name = name;
        this.score = score;
    }
 
    @Override
    public String toString() {
        return String.format("name : %s | score : %s",
                this.name, this.score);
    }
}
