package softpudding;

public class User {
    private String code;
    private boolean qualified;
    String getCode(){
        return code;
    }
    boolean getQualified(){
        return qualified;
    }
    void setQualified(boolean b){
        this.qualified=b;
    }
    User(String s){
        this.code = s;
        this.qualified = false;
    }
}
