package br.sp.protestolivre;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.os.Build;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

public class Tela05 extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela05);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela05, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	
	public void createPDF(View v){
		String nome = ((EditText)findViewById(R.id.nome)).getText().toString();
		String endereco = ((EditText)findViewById(R.id.endereco)).getText().toString();
		String cidade = ((EditText)findViewById(R.id.cidade)).getText().toString();
		String profissao = ((EditText)findViewById(R.id.profissao)).getText().toString();
		String rg = ((EditText)findViewById(R.id.rg)).getText().toString();
		String cpf = ((EditText)findViewById(R.id.cpf)).getText().toString();
		String titulo = ((EditText)findViewById(R.id.titulo)).getText().toString();
		
//		if (nome == "" || endereco == "" || cidade == "" || profissao == "" ||rg == "" || cpf == "" || titulo == ""){
//			Toast toast = Toast.makeText(getApplicationContext(), "Todos os campos devem ser preenchidos", 10); 
//			return;
//		}
		
		
		int sigla = ((Spinner)findViewById(R.id.spinner1)).getSelectedItemPosition();
		String[] listEstados = {"Acre","Alagoas","Amap�","Amazonas","Bahia","Cear�","Distrito Federal","Esp�rito Santo","Goi�s","Maranh�o","Mato Grosso","Mato Grosso do Sul","Minas Gerais","Par�","Para�ba","Paran�","Pernambuco","Piau�","Rio de Janeiro","Rio Grande do Norte","Rio Grande do Sul","Rond�nia","Roraima","Santa Catarina","S�o Paulo","Sergipe","Tocantins"};
		String estado = listEstados[sigla];
		
		String text1 = nome +", brasileiro, residente e domiciliado na "+endereco+", "+profissao+", portador da C.I n� "+rg+", inscrito no CPF sob o n� "+cpf+", cidad�o registrado sob o t�tulo de eleitor n� "+titulo+", vem, EM CAUSA PR�PRIA, impetrar a presente ORDEM DE HABEAS CORPUS PREVENTIVO COM PEDIDO DE LIMINAR apontando como autoridade coatora a Pol�cia Militar do Estado de "+ estado+", pelos fatos e fundamentos que passa a expor:";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String data = sdf.format(new Date());
		
		Calendar c = Calendar.getInstance();
		String dia = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		String[] meses = {"Janeiro","Fevereiro","Mar�o","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
		String mes = meses[c.get(Calendar.MONTH)];
		String ano = String.valueOf(c.get(Calendar.YEAR));
		
		Font text = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.NORMAL);
		Font bold = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.BOLD);
		Font italic = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.ITALIC);
		Font bitalic = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.BOLDITALIC);
		String path = Environment.getExternalStorageDirectory().getPath() + "/ProtestoLivre";
		try {
			File p = new File(path);
			
			  File f = new File(p,nome.replaceAll(" ","")+data+".pdf");
			  Toast toast = Toast.makeText(getApplicationContext(), "Documento salvo em: " + f.toString(), 15);
				toast.show();
		      Document doc = new Document();
		      PdfWriter.getInstance(doc, new FileOutputStream(f));
		      doc.open();
		      doc.add(new Paragraph("EXMO. SR. JUIZ DE DIREITO DO TRIBUNAL DE JUSTI�A DO ESTADO DE "+estado.toUpperCase(), text));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(text1,text));
		      doc.newPage();
		      Phrase phrase = new Phrase();
		      phrase.add(new Chunk("     O Impetrante deseja ", text));
		      phrase.add(new Chunk("exercer seus direitos fundamentais relativos � liberdade de manifesta��o do pensamento ", bold));
		      phrase.add(new Chunk("(art. 5�, IV, CR/88); ",text));
		      phrase.add(new Chunk("liberdade de locomo��o no territ�rio nacional", bold));
		      phrase.add(new Chunk(" (art. 5�, XV, CR/88), ",text));
		      phrase.add(new Chunk("liberdade de reuni�o para fins pac�ficos",bold));
		      phrase.add(new Chunk(" (art. 5�, XVI, CR/88), contudo, teme ter sua liberdade cerceada face aos abusos cometidos pelas for�as de seguran�a Estadual, sobretudo sua pol�cia Militar, ao reprimir as manifesta��es ocorridas nos �ltimos tempos.",text));
		      Paragraph par = new Paragraph(phrase);
		      par.setAlignment(Element.ALIGN_JUSTIFIED);
		      doc.add(par);
		      doc.add(new Paragraph("     H� que ser ressaltado que nos autos de cautelar inominada interposta pelo Estado de Minas Gerais contra o SINDICATO DOS SERVIDORES DA POLICIA CIVIL DO ESTADO DE MINAS GERAIS � SINDPOL, de autos n� 0411481-04.2013.8.13.0000, foi deferida medida liminar para:",text));
		      phrase = new Phrase();
		      phrase.add(new Chunk("�1) ",text));
		      phrase.add(new Chunk("determinar que as r�s se abstenham de praticar os atos enunciados em seus pronunciamentos",bold));
		      phrase.add(new Chunk(", especialmente os de embargar as vias de acesso ao Mineir�o e de todo o seu entorno, bem assim �s demais regi�es e logradouros p�blicos situados no territ�rio estadual; 2) ",text));
		      phrase.add(new Chunk("determinar que esta proibi��o se estenda a todo e qualquer manifestante ",bold));
		      phrase.add(new Chunk("que porventura tente impedir o normal tr�nsito de pessoas e ve�culos, bem assim o regular funcionamento dos servi�os p�blicos estaduais, apresenta��o de espet�culos e de demais eventos esportivos e culturais e, 3) ",text));
		      phrase.add(new Chunk("fixar multa di�ria de R$500.000,00",bold));
		      phrase.add(new Chunk(" (quinhentos mil reais) para cada entidade sindical, em caso de descumprimento da ordem, e a todas e ",text));
		      phrase.add(new Chunk("quaisquer outras entidades que aderirem � manifesta��o, ",bold));
		      phrase.add(new Chunk("ordenando, desde logo, a utiliza��o imediata do sistema de bloqueio on line (BACENJUD) em caso de descumprimento.�",text));
		      par = new Paragraph(phrase);
		      par.setAlignment(Element.ALIGN_JUSTIFIED);
		      par.setIndentationLeft(150);
		      doc.add(par);
		      phrase =new Phrase();
		      phrase.add(new Chunk("     Tal proibi��o de manifesta��es d� a entender que estariam vetadas toda e qualquer manifesta��o no territ�rio de Minas Gerais, o que, por �bvio, ",text));
		      phrase.add(new Chunk("rasga o texto expresso da Constitui��o",bold));
		      phrase.add(new Chunk("em clara e evidente afronta aos direitos fundamentais assegurados pela Lei Maior da Rep�blica Federativa do Brasil. Assim, para cumprir essa absurda determina��o, as for�as p�blicas de seguran�a v�m abusando da for�a atrav�s de disparos � esmo de armas de fogo com balas de borracha; uso de g�s lacrimog�neo, cassetetes e outros instrumentos capazes de ferir e/ou matar manifestantes; bem como uso arbitr�rio de pris�es de manifestantes como forma de acabar com os protestos.",text));
		      par = new Paragraph(phrase);
		      par.setAlignment(Element.ALIGN_JUSTIFIED);
		      doc.add(par);
		      phrase =new Phrase();
		      phrase.add(new Chunk("     Felizmente o ",text));
		      phrase.add(new Chunk("Supremo Tribunal Federal reconheceu o absurdo da decis�o",bold));
		      phrase.add(new Chunk(" desse Egr�gio Tribunal de Justi�a do Estado de Minas Gerais e, no julgamento de pedido de liminar feito na reclama��o n� 15887, o Ministro Luiz Fux cassou a decis�o no dia 19 de junho de 2013, assim decidindo: �Ex positis, concedo a liminar, cassando a decis�o reclamada, nos termos do art. 21, V, do RISTF, porquanto consideradas leg�timas as manifesta��es populares realizadas sem vandalismo, preservado o poder de pol�cia estatal na repress�o de eventuais abusos.�",text));
		      par = new Paragraph(phrase);
		      par.setAlignment(Element.ALIGN_JUSTIFIED);
		      doc.add(par);
		      phrase =new Phrase();
		      phrase.add(new Chunk("     Oportuno ressaltar decis�o do ",text));
		      phrase.add(new Chunk("Superior Tribunal de Justi�a",bold));
		      phrase.add(new Chunk(" sobre caso de materialidade semelhante. O Habeas Corpus Preventivo foi impetrado em favor de grupo manifestante contra ",text));
		      phrase.add(new Chunk("decis�o absurda da justi�a federal",bold));
		      phrase.add(new Chunk(" que permitia o uso da for�a policial em manifesta��es ordeiras e legais no Munic�pio de Natal/RN. Decidiu o ministro Herman Benjamin no sentido de que �o Rem�dio heroico � cab�vel em situa��es de que resulte possibilidade de ofensa ao �",text));
		      phrase.add(new Chunk("jus manendi, ambulandi, eundi ultro citroque",italic));
		      phrase.add(new Chunk(" [direito de permanecer, indo e voltando]�� (STJ/HABEAS CORPUS N� 272.607 - RN).",text));
		      par = new Paragraph(phrase);
		      par.setAlignment(Element.ALIGN_JUSTIFIED);
		      doc.add(par);
		      phrase =new Phrase();
		      phrase.add(new Chunk("     Obviamente, ",text));
		      phrase.add(new Chunk("n�o cabe ao poder judici�rio determinar a utiliza��o da ",bold));
		      phrase.add(new Chunk("coertio",bitalic));
		      phrase.add(new Chunk(" pelo Estado",bold));
		      phrase.add(new Chunk(", sobretudo contra express�es leg�timas do povo, t�o importantes para a constru��o de uma na��o democr�tica e igualit�ria. Por sorte, neste caso a via estreita do Habeas Corpus serviu para salvaguardar os direitos de livre reuni�o e manifesta��o, tal como se pede no presente ",text));
		      phrase.add(new Chunk(" writ.",italic));
		      par = new Paragraph(phrase);
		      par.setAlignment(Element.ALIGN_JUSTIFIED);
		      doc.add(par);
		      phrase =new Phrase();
		      phrase.add(new Chunk("     Novamente, frise-se que se trata de manifesta��es ordeiras e pac�ficas, sendo certo que o impetrante n�o apoia e nem participa de qualquer forma de atos de vandalismo e criminosos que possam ter sido cometidos por grupos isolados e que se aproveitam da aglomera��o de pessoas dos manifestos para cometer seus atos criminosos. Assim, o impetrante e os demais manifestantes desejam apenas ",text));
		      phrase.add(new Chunk("defender publicamente seu pensamento",bold));
		      phrase.add(new Chunk(", manifestando suas insatisfa��es de forma a propor mudan�as ao Pa�s � direito esse que, em tempos de paz ",text));
		      phrase.add(new Chunk("n�o podem ser suprimidos em nenhuma hip�tese",bold));
		      phrase.add(new Chunk(" ou circunst�ncia. Frise-se que as exce��es constitucionais dizem respeito ao Estado de S�tio e de Defesa, que n�o abrangem a realiza��o de nenhum dos eventos esportivos dos quais o Brasil � sede.",text));
		      par = new Paragraph(phrase);
		      par.setAlignment(Element.ALIGN_JUSTIFIED);
		      doc.add(par);
		      phrase =new Phrase();
		      phrase.add(new Chunk("     Liberdade! � o que se requer neste ",text));
		      phrase.add(new Chunk("writ",italic));
		      phrase.add(new Chunk(", que seja assegurada a liberdade do Impetrante de se manifestar de ",text));
		      phrase.add(new Chunk("forma pac�fica",bold));
		      phrase.add(new Chunk(" sem que tenha sua liberdade cerceada desnecessariamente pelas for�as de seguran�a p�blica. Tamb�m requer que as for�as de seguran�a p�blica garantam a manifesta��o pac�fica e a seguran�a de todos os envolvidos no protesto, sem viol�ncia.",text));
		      par = new Paragraph(phrase);
		      par.setAlignment(Element.ALIGN_JUSTIFIED);
		      doc.add(par);
		      phrase =new Phrase();
		      phrase.add(new Chunk("     Insta salientar que em alguns Estados da Federa��o h� relatos de pris�es por ",text));
		      phrase.add(new Chunk("uso de m�scaras",bold));
		      phrase.add(new Chunk(" e at� por ",text));
		      phrase.add(new Chunk("porte de vinagre",bold));
		      phrase.add(new Chunk(" de uso dom�stico. Ora, Excelent�ssimo Juiz de Direito, nenhuma dessas subst�ncias � proibida, n�o havendo motivos para pris�es por seu porte durante manifesta��es.",text));
		      par = new Paragraph(phrase);
		      par.setAlignment(Element.ALIGN_JUSTIFIED);
		      doc.add(par);
		      phrase =new Phrase();
		      phrase.add(new Chunk("     A Constitui��o da Rep�blica ",text));
		      phrase.add(new Chunk("garante o direito � liberdade",bold));
		      phrase.add(new Chunk(", sendo a pris�o a exce��o do ordenamento constitucional, que, nos termos do art. 5�, LIV, da CR/88, necessita do devido processo legal. Assim, a pris�o por participar dos manifestos ou para averigua��es, como tem sido recorrente em manifesta��es pelo Pa�s, � ",text));
		      phrase.add(new Chunk("rente em manifesta��es pelo Pa�s, � desprovida de legitimidade constitucional",bold));
		      phrase.add(new Chunk(" e deve ser combatida por esse E. Tribunal de Justi�a.",text));
		      par = new Paragraph(phrase);
		      par.setAlignment(Element.ALIGN_JUSTIFIED);
		      doc.add(par);
		      phrase =new Phrase();
		      phrase.add(new Chunk("     Ademais, o Pacto Interamericano de Direitos Humanos de S�o Jos� da Costa Rica, que conforme decidiu o Supremo Tribunal Federal, possui ",text));
		      phrase.add(new Chunk("hierarquia supralegal",bold));
		      phrase.add(new Chunk(" e ingressou em nosso ordenamento interno pelo Decreto 678/1992. O diploma assegura o direito � liberdade e seguran�a pessoal (art. 7�, 1), � n�o priva��o da liberdade f�sica, salvo condi��es previamente especificadas (art. 7�, 2) e o direito � n�o deten��o arbitr�ria (art. 7�, 3). Assegura ainda a liberdade do pensamento (art. 13 e seus respectivos incisos).",text));
		      par = new Paragraph(phrase);
		      par.setAlignment(Element.ALIGN_JUSTIFIED);
		      doc.add(par);
		      phrase =new Phrase();
		      phrase.add(new Chunk("     O que est� em julgamento n�o � apenas o ",text));
		      phrase.add(new Chunk("direito de manifestar",bold));
		      phrase.add(new Chunk(", � o ",text));
		      phrase.add(new Chunk("direito � liberdade",bold));
		      phrase.add(new Chunk(" do impetrante e indiretamente, decorrentes do pr�prio Estado Democr�tico de Direito e que necessitam ser reafirmados por esse Egr�gio Tribunal de Justi�a.",text));
		      par = new Paragraph(phrase);
		      par.setAlignment(Element.ALIGN_JUSTIFIED);
		      doc.add(par);
		      par = new Paragraph(new Phrase("     Sobre a liberdade de manifesta��o do pensamento, decidiu o Supremo Tribunal Federal:",text));
		      par.setAlignment(Element.ALIGN_JUSTIFIED);
		      doc.add(par);
		      par = new Paragraph(new Phrase("�\"Decreto 20.098/1999 do Distrito Federal. Liberdade de reuni�o e de manifesta��o p�blica. Limita��es. Ofensa ao art. 5�, XVI, da CF. A liberdade de reuni�o e de associa��o para fins l�citos constitui uma das mais importantes conquistas da civiliza��o, enquanto fundamento das modernas democracias pol�ticas. A restri��o ao direito de reuni�o estabelecida pelo Decreto distrital 20.098/1999, a toda evid�ncia, mostra-se inadequada, desnecess�ria e desproporcional quando confrontada com a vontade da Constitui��o (Wille zur Verfassung).\" (ADI 1.969, Rel. Min. Ricardo Lewandowski, julgamento em 28-6-2007, Plen�rio, DJ de 31-8-2007.)�",text));
		      par.setAlignment(Element.ALIGN_JUSTIFIED);
		      par.setIndentationLeft(150);
		      doc.add(par);
		      phrase =new Phrase();
		      phrase.add(new Chunk("     Assim sendo, resta demonstrado que o impetrante tem direito a n�o ser preso, salvo flagrante delito ou ordem judicial fundamentada, durante as manifesta��es realizadas e a serem realizadas. Deve a ordem ser concedida para assegurar o �bvio ululante direito � liberdade pessoal e � manifesta��o do pensamento do impetrante, servindo a decis�o deste writ como um salvo conduto para as poss�veis viola��es aos direitos supracitados.",text));
		      par = new Paragraph(phrase);
		      par.setAlignment(Element.ALIGN_JUSTIFIED);
		      doc.add(par);
		      phrase =new Phrase();
		      phrase.add(new Chunk("DOS PEDIDOS",text));
		      par = new Paragraph(phrase);
		      par.setAlignment(Element.ALIGN_JUSTIFIED);
		      doc.add(par);
		      phrase =new Phrase();
		      phrase.add(new Chunk("Pelo exposto pede:",text));
		      par = new Paragraph(phrase);
		      par.setAlignment(Element.ALIGN_JUSTIFIED);
		      doc.add(par);
		      phrase =new Phrase();
		      phrase.add(new Chunk("a)     LIMINARMENTE a concess�o da ordem para assegurar ao impetrante o direito de participar das manifesta��es que ocorrerem antes e durante o per�odo da Copa do Mundo sem ser preso, ressalvadas as hip�teses constitucionais, expedindo o competente salvo conduto;",text));
		      par = new Paragraph(phrase);
		      par.setAlignment(Element.ALIGN_JUSTIFIED);
		      doc.add(par);
		      phrase =new Phrase();
		      phrase.add(new Chunk("b)     LIMINARMENTE a concess�o da ordem para assegurar ao impetrante o direito de portar vinagre antes e durante as manifesta��es que ocorrerem durante o per�odo da Copa do Mundo sem ser preso, ressalvadas as hip�teses constitucionais, expedindo o competente salvo conduto;",text));
		      par = new Paragraph(phrase);
		      par.setAlignment(Element.ALIGN_JUSTIFIED);
		      doc.add(par);
		      phrase =new Phrase();
		      phrase.add(new Chunk("b)     LIMINARMENTE a concess�o da ordem para assegurar ao impetrante o direito de portar vinagre antes e durante as manifesta��es que ocorrerem durante o per�odo da Copa do Mundo sem ser preso, ressalvadas as hip�teses constitucionais, expedindo o competente salvo conduto;",text));
		      par = new Paragraph(phrase);
		      par.setAlignment(Element.ALIGN_JUSTIFIED);
		      doc.add(par);
		      phrase =new Phrase();
		      phrase.add(new Chunk("c)     LIMINARMENTE a concess�o da ordem para assegurar ao impetrante o direito de usar m�scaras aleg�ricas durante as manifesta��es que ocorrerem antes e durante o per�odo da Copa do Mundo sem ser preso, ressalvadas as hip�teses constitucionais, expedindo o competente salvo conduto;",text));
		      par = new Paragraph(phrase);
		      par.setAlignment(Element.ALIGN_JUSTIFIED);
		      doc.add(par);
		      phrase =new Phrase();
		      phrase.add(new Chunk("d)     NO M�RITO a concess�o da ordem para assegurar ao impetrante o direito de participar das manifesta��es que ocorrerem durante o per�odo da Copa do Mundo sem ser preso, ressalvadas as hip�teses constitucionais, bem como para confirmar as liminares concedidas, expedindo o competente salvo conduto;",text));
		      par = new Paragraph(phrase);
		      par.setAlignment(Element.ALIGN_JUSTIFIED);
		      doc.add(par);
		      phrase =new Phrase();
		      phrase.add(new Chunk("e)     A CONCESS�O DE EFEITO EXTENSIVO, no caso de concess�o, � ordem de habeas corpus e ao pedido de liminar para, nos termos do art. 580 do C�digo de Processo Penal, estender os efeitos da ordem � todos os manifestantes do Estado de "+estado+" que estiverem nas mesmas condi��es. ",text));
		      par = new Paragraph(phrase);
		      par.setAlignment(Element.ALIGN_JUSTIFIED);
		      doc.add(par);
		      phrase =new Phrase();
		      phrase.add(new Chunk("Nestes termos,",text));
		      par = new Paragraph(phrase);
		      par.setAlignment(Element.ALIGN_JUSTIFIED);
		      doc.add(par);
		      phrase =new Phrase();
		      phrase.add(new Chunk("Pede deferimento.",text));
		      par = new Paragraph(phrase);
		      par.setAlignment(Element.ALIGN_JUSTIFIED);
		      doc.add(par);
		      phrase =new Phrase();
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(" "));
		      doc.add(new Paragraph(cidade+", "+dia + " " + mes + " " + ano, text));
		      doc.add(new Paragraph("__________________________________",text));
		      doc.add(new Paragraph(nome,text));
		      doc.close();
		      
		} catch (Exception e) {
			Toast toast = Toast.makeText(getApplicationContext(),e.toString(), 10);
			toast.show(); 
		}
		
		finish();
		
		
	}
	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_tela05,
					container, false);
			return rootView;
		}
	}

}
