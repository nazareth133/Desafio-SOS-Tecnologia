package br.com.sostecnologia.service;

import br.com.sostecnologia.domain.Patrimonio;
import br.com.sostecnologia.repository.PatrimonioRepository;
import br.com.sostecnologia.util.RequestAPIUtil;
import com.google.gson.Gson;
import com.squareup.okhttp.HttpUrl;

import javax.inject.Inject;

public class PatrimonioService {

    @Inject
    private PatrimonioRepository patrimonioRepository;

///    private final WebTarget webTarget;
    //    private final Client client;
//    private static final String BASE_URI = "http://localhost:8080";

//    public PatrimonioClient() {
//        client = ClientBuilder.newClient();
//        webTarget = client.target(BASE_URI).path("/sos-tecnologia/api");
//    }

    public void criarPatrimonio(Patrimonio patrimonio) throws Exception{
        patrimonioRepository.create(patrimonio);
    }

//    public String countREST() throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("count");
//        return resource.request(MediaType.TEXT_PLAIN).get(String.class);
//    }
//
//    public void edit(Object requestEntity, String id) throws ClientErrorException {
//        webTarget.path(MessageFormat.format("/patrimonios/{0}", new Object[]{id})).request(MediaType.APPLICATION_JSON).put(Entity.entity(requestEntity, MediaType.APPLICATION_JSON));
//    }
//
//    public <T> T find(Class<T> responseType, String id) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path(MessageFormat.format("/patrimonios/{0}", new Object[]{id}));
//        return resource.request(MediaType.APPLICATION_JSON).get(responseType);
//    }
//
//    public <T> T findRange(Class<T> responseType, String from, String to) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path(MessageFormat.format("/patrimonios/{0}/{1}", new Object[]{from, to}));
//        return resource.request(MediaType.APPLICATION_JSON).get(responseType);
//    }
//
//    public void create(Object requestEntity) throws ClientErrorException {
//        webTarget.request(MediaType.APPLICATION_JSON).post(Entity.entity(requestEntity, MediaType.APPLICATION_JSON));
//    }
//
//    public <T> T findAll(Class<T> responseType) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        return resource.request(MediaType.APPLICATION_JSON).get(responseType);
//    }
//
//    public void remove(String id) throws ClientErrorException {
//        webTarget.path(MessageFormat.format("/patrimonios/{0}", new Object[]{id})).request().delete();
//    }
//
//    public void close() {
//        client.close();
//    }
}
