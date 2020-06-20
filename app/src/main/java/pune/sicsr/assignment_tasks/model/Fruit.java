package pune.sicsr.assignment_tasks.model;

public class Fruit {

    private String fruitName;
    private Long fruitId;

    public Fruit(String fruitName, Long fruitId) {
        this.fruitName = fruitName;
        this.fruitId = fruitId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public Long getFruitId() {
        return fruitId;
    }

    public void setFruitId(Long fruitId) {
        this.fruitId = fruitId;
    }
}