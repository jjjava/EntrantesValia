package org.pasa.sispasa.valia.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.apache.log4j.Logger;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class DateUtil {

    public static final String PATTERN_DATA = "dd.MM.yyyy";
    public static final String PATTERN_DATA2 = "ddMMyyyy";
    
    private static final Logger LOGGER = Logger.getLogger(DateUtil.class);

    public static Date toDate(final String data) {
        Date retorno;
        if (data == null) {
            return null;
        }
        String trim = data.trim();
        if (trim.equalsIgnoreCase("")) {
            return null;
        }
        try {
            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PATTERN_DATA, Locale.getDefault());
            retorno = simpleDateFormat.parse(trim);
        } catch (ParseException ex) {
            System.err.println(ex);
            LOGGER.error(ex);
            retorno = null;
        }
        return retorno;
    }

    public static Date obterDataAtual() {
        return Calendar.getInstance().getTime();
    }

    public static String dataParaArquivo() {
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
