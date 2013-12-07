package me.arganzheng.project.reading.common;

import java.io.IOException;
import java.io.PrintStream;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * MappingJsonpHttpMessageConverter. Support jsonp callback
 * 
 * @author arganzheng
 * @date 2013-12-7
 */
@Component
public class MappingJsonpHttpMessageConverter extends MappingJacksonHttpMessageConverter {

    public MappingJsonpHttpMessageConverter(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationConfig(objectMapper.getSerializationConfig().withSerializationInclusion(Inclusion.NON_NULL));
        setObjectMapper(objectMapper);
    }

    @Override
    protected void writeInternal(Object o, HttpOutputMessage outputMessage) throws IOException,
                                                                           HttpMessageNotWritableException {
        String jsonpCallback = null;

        RequestAttributes reqAttrs = RequestContextHolder.currentRequestAttributes();
        if (reqAttrs instanceof ServletRequestAttributes) {
            jsonpCallback = ((ServletRequestAttributes) reqAttrs).getRequest().getParameter("callback");
        }

        if (jsonpCallback != null) {
            new PrintStream(outputMessage.getBody()).print(jsonpCallback + "(");
        }

        super.writeInternal(o, outputMessage);

        if (jsonpCallback != null) {
            new PrintStream(outputMessage.getBody()).println(");");
        }
    }
}
