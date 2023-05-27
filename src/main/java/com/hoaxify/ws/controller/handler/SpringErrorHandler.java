package com.hoaxify.ws.controller.handler;

import com.hoaxify.ws.core.results.ErrorResult;
import com.hoaxify.ws.core.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;
import java.util.SortedMap;

@RestController
public class SpringErrorHandler implements ErrorController {

    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping("/error")
    public Result<?> handleError(WebRequest webRequest){
        Map<String, Object> attributes = this.errorAttributes.getErrorAttributes(webRequest,
                ErrorAttributeOptions.of(ErrorAttributeOptions.Include.MESSAGE, ErrorAttributeOptions.Include.BINDING_ERRORS));
        String message = (String) attributes.get("message");
        String path = (String) attributes.get("path");
        Integer status = (Integer) attributes.get("status");
        Result<SortedMap<String, String>> error = new ErrorResult<>(HttpStatus.valueOf(status), message, path);

        /*
        Aşağıdaki if kısmı ile GlobalExceptionHandler içerisinde metot yazmadan aynı işlevi yerine
        getirebiliyoruz. Ancak geriye dönen ErrorResult nesnesi içerisindeki message alanı buradaki
        gibi dönüldüğünde anlamsız/gereksiz olabiliyor. O yüzden aşağısı kapatılarak GlobalExceptionHandler
        kullanımına devam edildi. Bu metot yalnızca Spring'in authentication hatası için kullanılacak.

        if(attributes.containsKey("errors")){
            List<FieldError> fieldErrors =(List<FieldError>) attributes.get("errors");
            final SortedMap<String, String> errorList = new TreeMap<>();
            fieldErrors
                .forEach(objectError -> {
                        final String errorField = objectError.getField();
                        final String errorMessage = objectError.getDefaultMessage();
                        errorList.put(errorField, errorMessage);
                    });
            error.setData(errorList);
        }
        */

        return error;
    }

}
