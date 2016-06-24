package br.com.acme.negocio.util;

import org.joda.time.DateTime;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by allanmoreira on 22/06/16.
 */
public class ManipulaData {

    public Date getDataHoje(){
        DateTime hoje = new DateTime();
        return new Date(hoje.toDate().getTime());
    }

    public Date somaDiasAData(java.util.Date data, int dias) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.add(Calendar.DATE, dias);

        return new Date(calendar.getTime().getTime());
    }
    
    public String getDataPorExtenso(java.sql.Date data){
		Locale local = new Locale("pt","BR");
		DateTime novaData = new DateTime(data);
		java.util.Date novaDataUtil = novaData.toDate();
		SimpleDateFormat formatoDataPorExtenso = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy",local);
		
		return formatoDataPorExtenso.format(novaDataUtil) + " - " + novaData.dayOfWeek().getAsText(local);
	}
}
