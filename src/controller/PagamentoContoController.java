package controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import db.GestoreDB;
import model.*;
import util.*;

public class PagamentoContoController {
	
	
	public boolean check(String cf) {
		GestoreDB g = new GestoreDB();
		return g.checkCliente(cf);
	}
	
	public ArrayList<String> getClientePrewiev(String cf){
		GestoreDB g = new GestoreDB();
		ArrayList<String> cliente = g.getClienteHotelData(cf);
		return cliente;
	}
	
	
	public void pagaConto(Conto c, Pagamento p, int m) { 
		GestoreDB g = new GestoreDB();
		c.setStato(true);
		p.setConto(c);
		g.salvaPagamento(c.getIdConto(), p.getImportoTotale(), m);
	}
	
	public Conto calcoloConto(String cf) throws NumberFormatException, ParseException {
		GestoreDB g = new GestoreDB();
		
		ClienteHotel cliente = createCliente(cf, g);
		Soggiorno soggiorno = createSoggiorno(cf, g, cliente);
		Camera camera = createCamera(g, soggiorno.getIdCamera());
		FrigoBar frigo = createFrigo(g, camera);
		
		cliente.setSoggiorno(soggiorno);
		soggiorno.setCamera(camera);
		camera.setFrigo(frigo);
				
		
		OrdineRistorante ordineRistorante = createOrdineRistorante(g, soggiorno);
		OrdineBibita ordineBibita = createOrdineBibita(g, soggiorno);
		
		camera.setConsumiFrigoBarGiornalieri(ordineBibita);
		camera.setConsumiRistoranteGiornalieri(ordineRistorante);
		
		Conto conto = createConto(g, soggiorno);
		conto.setCliente(cliente);
		conto.calcoloTotaleConto(ordineBibita, ordineRistorante, soggiorno);
		return conto;		
	}
	
	
	public Pagamento createPagamento(Conto conto) {
		Pagamento pagamento = new Pagamento(conto);
		pagamento.setImportoTotale(conto.getConto());
		return pagamento;
	}
	
	public Scontrino createScontrino(Conto c) {
		Scontrino s = new Scontrino();
		s.setSaldoCamera(c.getCliente().getSoggiorno().getSaldo());
		s.setOrdiniBibite(c.getCliente().getSoggiorno().getCamera().getConsumiFrigoBarGiornalieri());
		s.setOrdiniRistorante(c.getCliente().getSoggiorno().getCamera().getConsumiRistoranteGiornalieri());
		return s;
	}
	
	
	public Conto createConto(GestoreDB g, Soggiorno s) {
		String cf = s.getCliente().getCodiceFiscale();
		int idReg = s.getIdRegistrazione();
		ArrayList<String> contoData = g.getContoData(cf, idReg);
		Conto conto = new Conto(Float.parseFloat(contoData.get(0)), Boolean.parseBoolean(contoData.get(1)), Integer.parseInt(contoData.get(2)));
		return conto;
	}
	
	public OrdineBibita createOrdineBibita(GestoreDB g, Soggiorno s) throws ParseException {
		String cf = s.getCliente().getCodiceFiscale();
		int idReg = s.getIdRegistrazione();
		int idCamera = s.getIdCamera();
		OrdineBibita o = new OrdineBibita(s.getCamera());
		ArrayList<String> ordineBibita = g.getOrdineBibitaData(cf, idCamera, idReg);
		Iterator<String> i = ordineBibita.iterator();
		while(i.hasNext()) {
			int id = Integer.parseInt(i.next());
			Date data = Util.toDate(i.next());
			int quantita = Integer.parseInt(i.next());
			ArrayList<String> pi = g.getBibitaData(id);
			Bibita b = new Bibita(id, Float.parseFloat(pi.get(0)), pi.get(1));
			RigaOrdineBibita r = new RigaOrdineBibita(b, data, quantita);
			o.creaLista(r);
		}
		return o;
	}
	
	public OrdineRistorante createOrdineRistorante(GestoreDB g, Soggiorno s) throws ParseException {
		String cf = s.getCliente().getCodiceFiscale();
		int idReg = s.getIdRegistrazione();
		int idCamera = s.getIdCamera();
		OrdineRistorante o = new OrdineRistorante(s.getCamera());
		ArrayList<String> ordineRistorante = g.getOrdineRistoranteData(cf, idCamera, idReg);
		Iterator<String> i = ordineRistorante.iterator();
		while(i.hasNext()) {
			int id = Integer.parseInt(i.next());
			Date data = Util.toDate(i.next());
			int quantita = Integer.parseInt(i.next());
			ArrayList<String> pi = g.getPietanzaData(id);
			Pietanza p = new Pietanza(id, Float.parseFloat(pi.get(0)), pi.get(1));
			RigaOrdineRistorante r = new RigaOrdineRistorante(p, data, quantita);
			o.creaLista(r);
		}
		return o;
	}
	
	public OrdineBibita createOrdineBibita() {
		OrdineBibita o = null;
		return o;
	}
	
	public FrigoBar createFrigo(GestoreDB g, Camera camera) {
		int idFrigo = g.getFrigoData(camera.getNumeroCamera());
		FrigoBar frigo = new FrigoBar(idFrigo, camera);
		return frigo;
	}
	
	
	public Camera createCamera(GestoreDB g, int idCamera) {
		ArrayList<String> cameraData = g.getCameraData(idCamera);
		Camera camera = new Camera(Integer.parseInt(cameraData.get(0)), cameraData.get(1), cameraData.get(2), Float.parseFloat(cameraData.get(3)), null);
		return camera;
	}
	
	
	public Soggiorno createSoggiorno(String cf, GestoreDB g, ClienteHotel cliente) throws NumberFormatException, ParseException {
		ArrayList<String> soggiornoData = g.getSoggiornoData(cf);
		Soggiorno soggiorno = new Soggiorno(Util.toDate(soggiornoData.get(0)), Integer.parseInt(soggiornoData.get(1)), Util.toDate(soggiornoData.get(2)), Float.parseFloat(soggiornoData.get(3)), null, null, cliente);
		soggiorno.setIdCamera(Integer.parseInt(soggiornoData.get(4)));
		return soggiorno;
	}
	
	
	public ClienteHotel createCliente(String cf, GestoreDB g) {
		ArrayList<String> clienteData = g.getClienteHotelData(cf);
		ClienteHotel cliente = new ClienteHotel(clienteData.get(0), clienteData.get(1), clienteData.get(2), null);
		return cliente;
	}
	
	
	
}
