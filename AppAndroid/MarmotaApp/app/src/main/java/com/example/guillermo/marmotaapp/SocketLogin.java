package com.example.guillermo.marmotaapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by JuanJosé on 20/02/2016.
 */
public class SocketLogin implements Runnable, Serializable {
    private String strMensaje;
    private boolean threadActivo;
    private boolean boolResultado;
    public boolean bLogin(String entrada){
        strMensaje = entrada;
        new Thread(this).start();
        threadActivo = true;
        while(threadActivo){
            try{
                Thread.sleep(100);
                System.out.println(threadActivo);
            }catch(Exception e){
                System.out.println(e);
            }
        }
        return boolResultado;
    }
    @Override
    public void run() {
        boolResultado=false;
        try {
            Socket socConn = new Socket(InetAddress.getByName("10.12.175.205"),7890);
            BufferedReader buffEntrada = new BufferedReader(new InputStreamReader(socConn.getInputStream()));
            PrintWriter prSalida = new PrintWriter(new BufferedWriter(
                    new OutputStreamWriter(socConn.getOutputStream())),true);
            prSalida.println("1");
            prSalida.println(strMensaje);

            String strRespuesta = buffEntrada.readLine();
            System.out.println(strRespuesta);
            if(strRespuesta.equals("2")){
                boolResultado = true;
            }else
            {
                boolResultado = false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        threadActivo = false;
    }
}
