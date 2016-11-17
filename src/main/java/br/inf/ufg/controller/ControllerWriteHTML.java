/*
 * Copyright (c) 2016. Jean Lucas Monte Carvalho
 * Creative Commons Attribution 4.0 International License.
 */

package br.inf.ufg.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import br.inf.ufg.model.Retorno;
import br.inf.ufg.write.WriteInterface;
import edu.emory.mathcs.backport.java.util.TreeMap.Entry;

public class ControllerWriteHTML implements WriteInterface {
    private Map<String, Float> map = new HashMap<String, Float>();

    @Override
    public void write(Retorno retorno) {
        map = retorno.getMapRetorno();
        try {
            PrintWriter writer = new PrintWriter("resultado.html", "UTF-8");
            writer.println("<!DOCTYPE html>" + "<html>" + "<head>" + "<style>" + "table {"
                    + "font-family: arial, sans-serif;" + "border-collapse: collapse;" + "width: 100%;}" + "td, th {"
                    + " border: 1px solid #dddddd;" + "text-align: left;" + "padding: 8px;}" + "tr:nth-child(even) {"
                    + "background-color: #dddddd;}" + " </style>" + "</head>" + "<body>" + "<table>" + "<tr>"
                    + "<th>Expressao</th>" + "<th>Resultado Esperado</th>" + "</tr>" + "<tr>");

            for (Map.Entry<String, Float> entry : map.entrySet()) {
                String key = entry.getKey();
                Float value = entry.getValue();
                writer.println("<td>" + key.toString() + "</td>");
                writer.println("<td>" + value.toString() + "</td>");
            }

            writer.println("</tr>" + "</table>" + "</body>" + "</html>");

            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
