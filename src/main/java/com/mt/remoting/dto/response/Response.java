package com.mt.remoting.dto.response;

import com.mt.remoting.gameenum.CommonEnum;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Response<T> {
    private Integer code;
    private String message;
    private T data;
    public static <T> Response<T> success(T data){
        Response<T> response = new Response<>();
        response.setCode(CommonEnum.SUCCESS.getCode());
        response.setMessage(CommonEnum.SUCCESS.getMessage());
        if(null!=data){
            response.setData(data);
        }
        return response;
    }
    public static <T> Response<T> fail(){
        Response<T> response = new Response<>();
        response.setMessage(CommonEnum.FAIL.getMessage());
        response.setCode(CommonEnum.FAIL.getCode());
        return response;

    }

}
