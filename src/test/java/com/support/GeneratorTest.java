package com.support;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class GeneratorTest {
    public static String dataHoraParaArquivo (){
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("yyyyMMddhhmmss").format(ts);
    }
}
