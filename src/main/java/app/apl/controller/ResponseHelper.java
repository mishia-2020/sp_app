package app.apl.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

public class ResponseHelper{
    public Map responseBody (Object body){
        Map responseBody = new HashMap<String, Object>();
        responseBody.put("status","成功");
        responseBody.put("result",body);

        return responseBody;
    }


}
