package test;

import java.text.ParseException;

import controller.PagamentoContoController;

public class Tester {

	public static void main(String[] args) throws NumberFormatException, ParseException {
		// TODO Auto-generated method stub
		PagamentoContoController p = new PagamentoContoController();
		System.out.println(p.check("BNCLGU70P11D205C"));
	}

}
