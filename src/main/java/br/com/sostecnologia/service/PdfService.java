package br.com.sostecnologia.service;

import javax.inject.Inject;

import br.com.sostecnologia.domain.Pdf;
import br.com.sostecnologia.repository.PdfRepository;

public class PdfService {

	 @Inject
	    private PdfRepository pdfRepository;

	    public Pdf criarPdf(Pdf pdf){
	        return pdfRepository.save(pdf);
	    }

	    public Pdf buscarPdf(Pdf pdf){
	        return pdfRepository.find(pdf.getId()).get();
	    }


}
