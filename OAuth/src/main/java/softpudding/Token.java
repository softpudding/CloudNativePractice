package softpudding;

public class Token {
    String access_token;
    String token_type;
    String getAccess_token(){
        return this.access_token;
    }
    String getToken_type(){
        return this.token_type;
    }
    void setAccess_token(String s){
        this.access_token=s;
    }
    void setToken_type(String s){
        this.token_type=s;
    }
}
