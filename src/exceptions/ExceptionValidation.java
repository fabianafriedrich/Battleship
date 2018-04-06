package exceptions;

public class ExceptionValidation extends  Exception {

    private String msg;

    public ExceptionValidation(String msg){
        this.msg = msg;
    }
    public String getMessage(){
        return msg;
    }

}
