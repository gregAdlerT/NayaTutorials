package lesson01enum.enums.first_impl;

import lombok.RequiredArgsConstructor;
import java.util.function.BiFunction;

/**
 * @author Greg Adler
 */
@RequiredArgsConstructor

public enum HttpCode {
    INFORMATIONAL(100,199, (code,httpCode)->
             code>httpCode.max-((httpCode.max-httpCode.min)/2)?
                    Informational.HIGH_LEVEL.getMessage():Informational.LOW_LEVEL.getMessage()),
    SUCCESS(200,299, (code,httpCode)->
            code>httpCode.max-((httpCode.max-httpCode.min)/2)?
            Success.HIGH_LEVEL.getMessage():Success.LOW_LEVEL.getMessage()),
    REDIRECTION(300,399, (code,httpCode)->
            code>httpCode.max-((httpCode.max-httpCode.min)/2)?
            Redirection.HIGH_LEVEL.getMessage():Redirection.LOW_LEVEL.getMessage()),
    CLIENT_ERROR(400,499, (code,httpCode)->
            code>httpCode.max-((httpCode.max-httpCode.min)/2)?
            ClientError.HIGH_LEVEL.getMessage():ClientError.LOW_LEVEL.getMessage()),
    SERVER_ERROR(500,599, (code,httpCode)->
            code>httpCode.max-((httpCode.max-httpCode.min)/2)?
            ServerError.HIGH_LEVEL.getMessage():ServerError.LOW_LEVEL.getMessage());
    private final int min;
    private final int max;
    private final BiFunction<Integer,HttpCode,String> handler;


    public static String getMessageByCode(int code){
        HttpCode[] values = values();
        for (HttpCode value : values) {
            if (value.min<=code && value.max>code) return value.handler.apply(code,value);
        }
        throw new IllegalArgumentException("Code: "+code+" not supported");
    }
}
