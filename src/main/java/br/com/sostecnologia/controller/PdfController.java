package br.com.sostecnologia.controller;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.omnifaces.util.Faces;

import br.com.sostecnologia.domain.Pdf;
import br.com.sostecnologia.service.PdfService;
import br.com.sostecnologia.to.PdfTO;
import br.com.sostecnologia.util.ConstantsUtil;
import br.com.sostecnologia.util.MappingUtil;


@ApplicationScoped
@Named(value = "pdfController")
@Path("/api/sos-tecnologia")
public class PdfController extends AbstractController {

    private Logger logger = Logger.getLogger(PdfController.class);

   
    @Inject
    private PdfService pdfService;

    private PdfTO pdfTO;

    
    private Pdf selectedPdf;

    @Inject
    private MappingUtil<Pdf, PdfTO> mappingUtil;

    @POST
    @Path(ConstantsUtil.CRIAR_PATRIMONIO_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarPdf(@BeanParam PdfTO pdfTO){
        logger.info(pdfTO);
        Pdf pdf = mappingUtil.toToEntity(pdfTO, Pdf.class);
        this.pdfTO = new PdfTO();
        return Response.ok(pdfService.criarPdf(pdf)).build();
    }


    @GET
    @Path(ConstantsUtil.BUSCAR_PATRIMONIO_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPdf(@BeanParam PdfTO patrimonio, @PathParam("id") String id){
        return Response.ok(pdfService.buscarPdf(mappingUtil.toToEntity(pdfTO, Pdf.class))).build();
    }

   
    public PdfTO getPdfTO() {
        if (pdfTO == null ) {
        	pdfTO = new PdfTO();
           
        }
        return pdfTO;
    }

    public void setPdfTO(PdfTO pdfTO) {
        this.pdfTO = pdfTO;
    }

    public Pdf getSelectedPdf(){
        if (selectedPdf == null ) {
            selectedPdf = Faces.getFlashAttribute("selectedPatrimonio");
        }
        return selectedPdf;
    }

    public void setSelectecPatrimonio(Pdf pdf){
        Faces.setFlashAttribute("selectedPdf", pdf);
        selectedPdf = pdf;
    }

}