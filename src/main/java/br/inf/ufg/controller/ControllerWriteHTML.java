/*
 * Copyright (c) 2016. Jean Lucas Monte Carvalho
 * Creative Commons Attribution 4.0 International License.
 */

package br.inf.ufg.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import br.inf.ufg.model.Retorno;
import br.inf.ufg.write.WriteInterface;
import edu.emory.mathcs.backport.java.util.TreeMap.Entry;

public class ControllerWriteHTML implements WriteInterface {
    

    @Override
    public void write(ArrayList<Retorno> listaRetorno) {
        try {
            PrintWriter writer = new PrintWriter("resultado.html", "UTF-8");
            writer.println("<!DOCTYPE html>" + "<html>" + 
                    "<head>" + "<style>" + "table {"+
                     "font-family: arial, sans-serif;" + 
                    "border-collapse: collapse;" + "width: 100%;}" + 
                     "td, th {"+
                    " border: 1px solid #dddddd;" + 
                    "text-align: left;" + "padding: 8px;}" + 
                    "tr:nth-child(even) {"+ 
                    "background-color: #dddddd;}" + 
                    " </style>" + 
                    "</head>" + 
                    "<body>" + 
                    "<table>" + 
                    "<tr>"+
                    "<th>Expressao</th>" + 
                    "<th>Valor Resultado</th>" + 
                    "<th>Valor Esperado</th>" + 
                    "<th>Codigo Erro</th>" + 
                    "</tr>" + 
                    "<tr>");

          
            for (int i=0;i<listaRetorno.size();i++) {
                writer.println("<td>" + listaRetorno.get(i).getExpr() + "</td>");
                writer.println("<td>" +  listaRetorno.get(i).getValorResultado() + "</td>");
                writer.println("<td>" +  listaRetorno.get(i).getValorEsperado() + "</td>");
                writer.println("<td>" +  listaRetorno.get(i).getCodigoErro() + "</td>");
                writer.println("</tr>");
            }

            writer.println( "</table>" + "</body>" + "</html>");

            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
