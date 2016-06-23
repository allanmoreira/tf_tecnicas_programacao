package br.com.acme.negocio.util;

import org.joda.time.DateTime;
import java.sql.Date;
import java.util.Calendar;

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
}
