package br.com.sostecnologia.util;

import br.com.sostecnologia.exception.RequestException;
import com.squareup.okhttp.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RequestAPIUtil {

    protected static final Logger logger = LogManager.getLogger();

    public static String ostRequest(String body, HttpUrl httpUrl) throws Exception{

        logger.info("Iniciando REST Request POST");
        try {
            OkHttpClient client = new OkHttpClient();
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), body);
            Request request = new Request.Builder().url(httpUrl).post(requestBody).build();
            Response response = client.newCall(request).execute();
            if (response.code() == javax.ws.rs.core.Response.Status.ACCEPTED.getStatusCode()) {
                return response.body().string();
            } else {
                throw new RequestException("Erro ao fazer requisição ao serviço");
            }
        } catch (Exception e) {
            throw new RequestException(e.getMessage());
        }
    }

    public static String getRequest(HttpUrl httpUrl) throws Exception{
        logger.info("Iniciando REST Request GET");
        try {
            OkHttpClient client = new OkHttpClient();
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), "");
            Request request = new Request.Builder().url(httpUrl).post(requestBody).build();
            Response response = client.newCall(request).execute();
            if (response.code() == javax.ws.rs.core.Response.Status.ACCEPTED.getStatusCode()) {
                return response.body().string();
            } else {
                throw new RequestException("Erro ao fazer requisição ao serviço");
            }
        } catch (Exception e) {
            throw new RequestException(e.getMessage());
        }
    }

    public static String updateRequest(String body, HttpUrl httpUrl) throws Exception{
        logger.info("Iniciando REST Request UPDATE");
        try {
            OkHttpClient client = new OkHttpClient();
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), body);
            Request request = new Request.Builder().url(httpUrl).put(requestBody).build();
            Response response = client.newCall(request).execute();
            if (response.code() == javax.ws.rs.core.Response.Status.ACCEPTED.getStatusCode()) {
                return response.body().string();
            } else {
                throw new RequestException("Erro ao fazer requisição ao serviço");
            }
        } catch (Exception e) {
            throw new RequestException(e.getMessage());
        }
    }

    public static String deleteRequest(String body, HttpUrl httpUrl) throws Exception{
        logger.info("Iniciando REST Request DELETE");
        try {
            OkHttpClient client = new OkHttpClient();
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), body);
            Request request = new Request.Builder().url(httpUrl).delete(requestBody).build();
            Response response = client.newCall(request).execute();
            if (response.code() == javax.ws.rs.core.Response.Status.ACCEPTED.getStatusCode()) {
                return response.body().string();
            } else {
                throw new RequestException("Erro ao fazer requisição ao serviço");
            }
        } catch (Exception e) {
            throw new RequestException(e.getMessage());
        }
    }



}
