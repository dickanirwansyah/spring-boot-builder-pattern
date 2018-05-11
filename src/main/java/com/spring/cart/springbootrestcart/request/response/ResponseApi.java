package com.spring.cart.springbootrestcart.request.response;

import com.spring.cart.springbootrestcart.entity.Category;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
@Builder
public class ResponseApi {

    private String message;
    private Boolean success;

    public ResponseApi(String message, Boolean success){
        this.message = message;
        this.success = success;
    }

    public String getMessage(){
        return message;
    }


    public Boolean getSuccess(){
        return success;
    }


}
