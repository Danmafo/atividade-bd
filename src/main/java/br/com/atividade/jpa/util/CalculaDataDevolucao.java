package br.com.atividade.jpa.util;

import java.util.Calendar;
import java.util.Date;

public class CalculaDataDevolucao {

    public static Date calculaDataDevolucao(Date dataEmprestimo) {
        Calendar c = Calendar.getInstance();
        c.setTime(dataEmprestimo);
        c.add(Calendar.DATE, 15);
        Date dataEmprestimoMaisQuinzeDias = c.getTime();
        return dataEmprestimoMaisQuinzeDias;
    }
    
}
