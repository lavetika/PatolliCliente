/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Dominio.Jugador;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author laura
 */
public class MultiCliente extends Thread{
    Socket clientSocket;
    DataInputStream din;
    DataOutputStream dout;
    boolean stop = false;
    //public ClientData clientData;
    private Jugador jugador;
    public PnlChat GUI;

    public MultiCliente(Socket OurMultiSocket, PnlChat gui, Jugador jugador) {
        clientSocket = OurMultiSocket;
        this.jugador=jugador;
        //this.clientData = new ClientData();
        GUI = gui;
    }

    public void ClientOutServerIn(String Text) {
        //write the line from console to server
        try {
            if (Text.equals("change channel")) {
                System.out.print("sending changing channel: " + Text + "\n");
                dout.writeUTF(Text);
                dout.flush();
            } else if (Text.equals("new user")) {
                System.out.print("sending new user: " + Text + "\n");
                dout.writeUTF(Text + ":" + jugador.getNickname() + "=" + jugador.getCodigoPartida());
                dout.flush();
            } else {
                dout.writeUTF(jugador.getCodigoPartida() + "=" + this.getName() + ": " + Text);
                dout.flush();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void SetClient(String channel, String Name) {
        jugador.setNickname(Name);
        jugador.setCodigoPartida(Integer.parseInt(channel));
    }

    public void run() {
        try {
            din = new DataInputStream(clientSocket.getInputStream());
            dout = new DataOutputStream(clientSocket.getOutputStream());
            while (!stop) {
                try {
                    while (din.available() == 0) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    //if there is something just show it on console
                    //and then go back and do the same
                    String respuesta = din.readUTF();
                    String canal = ExtractChannel(respuesta);
                    String nombre = ExtractName(respuesta);
                    /*if (reply.equals("change canal"))
					{
						System.out.print("changing canal in body: "+reply+"\n");
						//GUI.ClearDisplay();
						setChangedChannel();
					}*/
//                    if (nombre.equals("new user")) {
//                        System.out.print("new user in body: " + respuesta + "\n");
//                        //GUI.ClearDisplay();
//                        setChannel(respuesta);
//                    } else {
                        PrintReply(canal, respuesta);
//                    }
                    //System.out.println(reply);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    try {
                        din.close();
                        dout.close();
                        clientSocket.close();
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            try {
                din.close();
                dout.close();
                clientSocket.close();
            } catch (IOException x) {
                // TODO Auto-generated catch block
                x.printStackTrace();
            }
        }
    }

    public void CloseClient() {
        try {
            din.close();
            dout.close();
            clientSocket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String ExtractName(String nombre) {
        String[] Y = nombre.split(":");
        return Y[0];
    }

    public String ExtractChannel(String canal) {
        String[] Y = canal.split("=");
        return Y[0];
    }

    public void PrintReply(String canal, String respuesta) {
        if (jugador.getCodigoPartida()==(Integer.parseInt(canal))) {
            String[] Y = respuesta.split("=");
            //AQUÍ SE HABLA AL PROXY PARA EL DISPLAY
            GUI.setDisplay(Y[1]);
            //System.out.println(Y[1]+"\n \n \n \n");
        }

    }

//    public void setChannel(String canal) {
//        String[] Y = canal.split(":");
//        String[] Z = Y[1].split("=");
//        System.out.print("Configurando " + Z[0] + " canal a " + Z[1] + "\n");
//        //GUI.setUserInChannel(Z[0]);
//    }

//    public void setChangedChannel() {
//        GUI.setUserInChannel(jugador.GetName() + ": " + jugador.GetChannel());
//    }

}
