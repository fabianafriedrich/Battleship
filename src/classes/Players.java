package classes;


public class Players {

    //attributes
    private String name;
    private Integer age;
    private String email;
    private Integer score;

    //constructor dfault
    public  Players(){

    }

    //constructor with parameters
    public Players(String name, Integer age, String email, Integer score){
        this.name = name;
        this.age = age;
        this.email = email;
        this.score = score;

    }

    public boolean validationNumberOfPlayers(Integer numberOfPlayers) {
        String numbers = String.valueOf(numberOfPlayers);
        if (numbers.matches("[0-9]*")) {
            return true;
        } else {
            return false;
        }
    }
    public boolean validationName(String name){
        int space = name.indexOf(" ");
        if(space == -1 ){
            return false;
        }else {
            return true;
        }

    }
    public boolean validationAge(Integer age){

        if (age >= 12 && age <= 100){
            return true;
        }else {
            return false;
        }
    }

    //Validation
    public boolean validationEmail(String email){
        if(email.contains("@") && email.contains(".")){
            return true;
        }else {
            return false;
        }
    }


    //Get,Set methods accessors
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
